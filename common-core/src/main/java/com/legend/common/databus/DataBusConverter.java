package com.legend.common.databus;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.databus.dataconv.DataConv;
import com.legend.common.databus.dataconv.DataConvMap;
import com.legend.common.databus.datadic.DataDic;
import com.legend.common.databus.datadic.DataDicMap;
import com.legend.common.exception.ConvConfigNotFoundException;
import com.legend.common.exception.DataBusLoadException;
import com.legend.common.exception.DataConvLoadException;
import com.legend.common.exception.IllegalDataBusKeyException;
import com.legend.common.exception.IllegalDataBusTypeException;

public class DataBusConverter {

	private static Logger logger = LoggerFactory.getLogger(DataBusConverter.class);

	private Map<String, Map<String, String>> conv;
	private Map<String, DataDic> validateMap; // 数据总线数据字典，在进行数据总线导入导出时进行类型检查

	public DataBusConverter(String dataDicFileName, String convFileDirectName)
			throws DataBusLoadException, DataConvLoadException {

		loadDataBusValidateMap(dataDicFileName);

		loadDataConvMap(convFileDirectName);

	}

	private void loadDataBusValidateMap(String dataDicFileName) throws DataBusLoadException {
		DataDicMap dataDicMap = null;
		String dataDicFilePath = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(DataDicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			dataDicFilePath = DataBusConverter.class.getClassLoader().getResource(dataDicFileName).getPath();
			logger.info("装载总线数据字典[" + dataDicFilePath + "]");
			dataDicMap = (DataDicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			logger.error("读取数据总线数据字典配置文件错误[" + dataDicFilePath + "][" + dataDicFileName + "]" + e);
			throw new DataBusLoadException("读取数据总线数据字典配置文件错误" + e);
		}

		this.validateMap = new HashMap<String, DataDic>();
		List<DataDic> dataDics = dataDicMap.getDataDic();
		for (DataDic dataDic : dataDics) {
			this.validateMap.put(dataDic.getDataCode(), dataDic);
		}
		logger.info("数据总线数据字典初始化完成");
	}

	private void loadDataConvMap(String convFileDirectName) throws DataConvLoadException {
		String convFileDirectPath = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(DataConvMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			convFileDirectPath = DataBusConverter.class.getClassLoader().getResource(convFileDirectName).getPath();
			this.conv = new HashMap<String, Map<String, String>>();
			logger.info("装载数据转换配置文件目录[" + convFileDirectPath + "]");
			File file = new File(convFileDirectPath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String key = null;
				String fileName = fileList[i].getName();
				if (fileList[i].isFile() && fileName.endsWith(".conv.xml")) {
					key = fileList[i].getName().substring(0, fileName.indexOf("."));
					String convFileName = convFileDirectPath + "/" + fileName;
					logger.info("装载数据转换配置文件[" + convFileName + "]");
					DataConvMap dataConvMap = (DataConvMap) ums.unmarshal(new File(convFileName));
					Map<String, String> map = new HashMap<String, String>();
					List<DataConv> dataConvs = dataConvMap.getDataConv();
					for (DataConv dataConv : dataConvs) {
						map.put(dataConv.getSource(), dataConv.getDestination());
					}
					this.conv.put(key, map);
				}
			}
		} catch (JAXBException e) {
			logger.error("读取数据转换配置文件错误[" + convFileDirectPath + "]" + e);
			throw new DataConvLoadException("读取数据转换配置文件错误" + e);
		}
		logger.info("数据转换配置文件初始化完成");
	}

	public DataBus toDataBus(String idConv, Map<String, Object> src) throws ConvConfigNotFoundException, IllegalDataBusKeyException, IllegalDataBusTypeException { // map转换
		Map<String, String> convMap = this.conv.get(idConv);
		if (convMap == null) {
			logger.error("转换标识[" + idConv + "]尚未配置");
			throw new ConvConfigNotFoundException("转换标识[" + idConv + "]尚未配置");
		}
		DataBus dataBus = new DataBus();
		Set<Entry<String, Object>> entries = src.entrySet();
		for (Entry<String, Object> entry : entries) {
			String key = convMap.get(entry.getKey());
			Object value = entry.getValue();
			try {
				dataBusValidate(key, value);
			} catch (IllegalDataBusKeyException e) {
				throw new IllegalDataBusKeyException(e);
			} catch (IllegalDataBusTypeException e) {
				throw new IllegalDataBusTypeException(e);
			}
			dataBus.put(key, value);
		}
		return dataBus;
	}

	public Map<String, Object> toMap(String idConv, DataBus dataBus) throws IllegalDataBusKeyException, IllegalDataBusTypeException, ConvConfigNotFoundException {
		Map<String, String> convMap = this.conv.get(idConv);
		if (convMap == null) {
			logger.error("转换标识[" + idConv + "]尚未配置");
			throw new ConvConfigNotFoundException("转换标识[" + idConv + "]尚未配置");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		Set<Map.Entry<String, Object>> entries = dataBus.entrySet();
		for (Entry<String, Object> entry : entries) {
			String key = convMap.get(entry.getKey());
			Object value = entry.getValue();
			try {
				dataBusValidate(entry.getKey(), value);
			} catch (IllegalDataBusKeyException e) {
				throw new IllegalDataBusKeyException(e);
			} catch (IllegalDataBusTypeException e) {
				throw new IllegalDataBusTypeException(e);
			}
			map.put(key, value);
		}
		return map;
	}

	private void dataBusValidate(String key, Object value)
			throws IllegalDataBusKeyException, IllegalDataBusTypeException {
		DataDic dataDic = this.validateMap.get(key);
		if (dataDic == null) {
			logger.error("非法的数据总线KEY值["+key+"]");
			throw new IllegalDataBusKeyException("非法的数据总线KEY值["+key+"]");
		}
		Class<?> clazz = null;
		try {
			clazz = Class.forName(dataDic.getDataType());
		} catch (ClassNotFoundException e) {
			logger.error("数据总线类型定义错误["+key+"]["+dataDic.getDataType()+"]");
			throw new IllegalDataBusKeyException("数据总线类型定义错误["+key+"]["+dataDic.getDataType()+"]");
		}
		if (clazz != value.getClass()) {
			logger.error("非法的数据值["+key+"]["+value+"]["+ value.getClass()+"]!=["+clazz+"]");
			throw new IllegalDataBusTypeException("非法的数据值["+key+"]["+value+"]["+ value.getClass()+"]!=["+clazz+"]");
		}
	}

}
