package com.legend.common.core.databus;

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

import com.legend.common.core.databus.dataconv.DataConv;
import com.legend.common.core.databus.dataconv.DataConv.Source;
import com.legend.common.core.databus.dataconv.DataConvMap;
import com.legend.common.core.databus.datadic.DataDic;
import com.legend.common.core.databus.datadic.DataDicMap;
import com.legend.common.core.exception.DataBusLoadException;
import com.legend.common.core.exception.DataConvLoadException;
import com.legend.common.core.exception.DatabusConvException;

public class DataBusConverter {

	private static Logger logger = LoggerFactory.getLogger(DataBusConverter.class);

	private Map<String, Map<String, DataConv>> conv = new HashMap<String, Map<String, DataConv>>();
	private Map<String, DataDic> validateMap = new HashMap<String, DataDic>(); // 数据总线数据字典，在进行数据总线导入导出时进行类型检查

	public DataBusConverter(String dataDicFileName, String convFileDirectName)
			throws DataBusLoadException, DataConvLoadException {

		loadDataBusValidateMap(dataDicFileName);
		logger.info("装载数据总线数据字典配置文件成功！！！");

		loadDataConvMap(convFileDirectName);
		logger.info("装载数据转换配置文件成功！！！");

	}

	private void loadDataBusValidateMap(String dataDicFilePath) throws DataBusLoadException {
		DataDicMap dataDicMap = null;
		if (dataDicFilePath == null) {
			throw new DataBusLoadException("装载数据总线数据字典配置文件错误[" + dataDicFilePath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(DataDicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载总线数据字典[" + dataDicFilePath + "]");
			dataDicMap = (DataDicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			throw new DataBusLoadException("装载数据总线数据字典配置文件错误[" + dataDicFilePath + "]" + e);
		}

		List<DataDic> dataDics = dataDicMap.getDataDic();
		for (DataDic dataDic : dataDics) {
			this.validateMap.put(dataDic.getDataCode(), dataDic);
		}
	}

	private void loadDataConvMap(String convFileDirectPath) throws DataConvLoadException {
		if (convFileDirectPath == null) {
			throw new DataConvLoadException("装载数据转换配置文件错误[" + convFileDirectPath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(DataConvMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("数据转换配置文件目录[" + convFileDirectPath + "]");
			File file = new File(convFileDirectPath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String key = null;
				String fileName = fileList[i].getName();
				if (fileList[i].isFile() && fileName.endsWith(".conv.xml")) {
					key = fileList[i].getName().substring(0, fileName.indexOf("."));
					String convFileName = convFileDirectPath + File.separator + fileName;
					logger.info("装载数据转换配置文件[" + convFileName + "]");
					DataConvMap dataConvMap = (DataConvMap) ums.unmarshal(new File(convFileName));
					Map<String, DataConv> map = new HashMap<String, DataConv>();
					List<DataConv> dataConvs = dataConvMap.getDataConv();
					for (DataConv dataConv : dataConvs) {
						map.put(dataConv.getSource().getValue(), dataConv);
					}
					this.conv.put(key, map);
				} else if (fileList[i].isDirectory()) {
					loadDataConvMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new DataConvLoadException("装载数据转换配置文件错误[" + convFileDirectPath + "]" + e);
		}

	}

	public void toDataBus(String idConv, Map<String, Object> src, DataBus dataBus) throws DatabusConvException { // map转换
		Map<String, DataConv> convMap = this.conv.get(idConv);
		if (convMap == null) {
			throw new DatabusConvException("转换标识[" + idConv + "]尚未配置");
		}
		Set<Entry<String, Object>> entries = src.entrySet();
		for (Entry<String, Object> entry : entries) {
			DataConv dataConv = convMap.get(entry.getKey());
			if (dataConv == null) {
				continue;
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			Source convSource = dataConv.getSource();
			if (convSource == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			String type = convSource.getType();
			if (type == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			Object value = null;
			if(type.equals("databus")){
				value = entry.getValue();
			}else if(type.equals("constant")){
				logger.info("转换文件[" + idConv + "]配置为常量，不应赋值["+entry.getKey()+"]");
				continue;
			}else{
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]["+type+"]");
			}
			dataBusValidate(key, value);
			dataBus.put(key, value);
		}
		
		Set<Entry<String, DataConv>> convMapEntries = convMap.entrySet();
		for (Entry<String, DataConv> convMapEntrie : convMapEntries) {
			DataConv dataConv = convMapEntrie.getValue();
			if(dataConv==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			Source source = dataConv.getSource();
			if(source==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			String type = source.getType();
			if(type==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误");
			}
			Object value = null;
			if(type.equals("constant")){
				value = dataConv.getSource().getValue();
				if(value==null){
					throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
				}
			}else{
				continue;
			}
			dataBus.put(key, value);
		}
	}

	public void toMap(String idConv, DataBus dataBus, Map<String, Object> map) throws DatabusConvException {
		Map<String, DataConv> convMap = this.conv.get(idConv);
		if (convMap == null) {
			throw new DatabusConvException("转换标识[" + idConv + "]尚未配置");
		}
		Set<Map.Entry<String, Object>> entries = dataBus.entrySet();
		for (Entry<String, Object> entry : entries) {
			DataConv dataConv = convMap.get(entry.getKey());
			if (dataConv == null) {
				continue;
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			Source convSource = dataConv.getSource();
			if (convSource == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			String type = convSource.getType();
			if (type == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]");
			}
			Object value = null;
			if(type.equals("databus")){
				value = entry.getValue();
			}else if(type.equals("constant")){
				logger.info("转换文件[" + idConv + "]配置为常量，不应赋值["+entry.getKey()+"]");
				continue;
			}else{
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+entry.getKey()+"]["+type+"]");
			}
			dataBusValidate(entry.getKey(), value);
			map.put(key, value);
		}
		
		Set<Entry<String, DataConv>> convMapEntries = convMap.entrySet();
		for (Entry<String, DataConv> convMapEntrie : convMapEntries) {
			DataConv dataConv = convMapEntrie.getValue();
			if(dataConv==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			Source source = dataConv.getSource();
			if(source==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			String type = source.getType();
			if(type==null){
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new DatabusConvException("转换文件[" + idConv + "]配置错误");
			}
			Object value = null;
			if(type.equals("constant")){
				value = dataConv.getSource().getValue();
				if(value==null){
					throw new DatabusConvException("转换文件[" + idConv + "]配置错误["+dataConv+"]");
				}
			}else{
				continue;
			}
			map.put(key, value);
		}
	}

	private void dataBusValidate(String key, Object value) throws DatabusConvException {
		if (value == null || value == null) {
			throw new DatabusConvException("非法的数据总线KEY值或数据值[" + key + "][" + value + "]");
		}
		DataDic dataDic = this.validateMap.get(key);
		if (dataDic == null) {
			throw new DatabusConvException("非法的数据总线KEY值[" + key + "]");
		}
		Class<?> clazz = null;
		try {
			clazz = Class.forName(dataDic.getDataType());
		} catch (ClassNotFoundException e) {
			throw new DatabusConvException("非法的数据总线类型定义[" + key + "][" + dataDic.getDataType() + "]");
		}
		if (clazz != value.getClass()) {
			throw new DatabusConvException(
					"非法的数据值[" + key + "][" + value + "][" + value.getClass() + "]!=[" + clazz + "]");
		}
	}

}
