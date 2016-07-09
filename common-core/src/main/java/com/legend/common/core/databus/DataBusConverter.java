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
import com.legend.common.core.databus.dataconv.DataConv.Format;
import com.legend.common.core.databus.dataconv.DataConv.Source;
import com.legend.common.core.databus.dataconv.DataConvMap;
import com.legend.common.core.exception.DataBusToMapConvException;
import com.legend.common.core.exception.DataConvLoadException;
import com.legend.common.core.exception.MapToDataBusConvException;
import com.legend.common.utils.DataUtil;

public class DataBusConverter {

	private static Logger logger = LoggerFactory.getLogger(DataBusConverter.class);

	private Map<String, Map<String, DataConv>> conv = new HashMap<String, Map<String, DataConv>>();

	public DataBusConverter(String convFileDirectName) throws DataConvLoadException {
		loadDataConvMap(convFileDirectName);
		logger.info("装载数据转换配置文件成功！！！");
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
				if (fileList[i].isFile() && fileName.endsWith(".databus.xml")) {
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

	public void toDataBus(String idConv, Map<String, Object> src, DataBus dataBus) throws MapToDataBusConvException { // map转换
		Map<String, DataConv> convMap = this.conv.get(idConv);
		if (convMap == null) {
			throw new MapToDataBusConvException("转换标识[" + idConv + "]尚未配置");
		}
		Set<Entry<String, DataConv>> convMapEntries = convMap.entrySet();
		for (Entry<String, DataConv> convMapEntrie : convMapEntries) {
			DataConv dataConv = convMapEntrie.getValue();
			if (dataConv == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误");
			}
			Source source = dataConv.getSource();
			if (source == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String valueKey = source.getValue();
			if (valueKey == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String from = source.getFrom();
			if (from == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String type = source.getType();
			if (type == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			Object value = null;
			if (from.equals("constant")) {
				String valueString = dataConv.getSource().getValue();
				if (valueString == null) {
					throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				if(type.equals("integer")){
					value = Integer.valueOf(valueString);
				}else if(type.equals("double")){
					value = Double.valueOf(valueString);
				}else{
					value = valueString;
				}
			} if (from.equals("databus")) {
				value = src.get(valueKey);
				if(value == null){
					continue;
				}
			} else {
				throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			Format format = dataConv.getFormat();
			if (format != null) {
				String formatStr = format.getValue().value();
				if (formatStr == null) {
					throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				Integer dec = format.getDec();
				if (dec == null) {
					throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				if (formatStr.equals("point")) {
					value = DataUtil.addPoint((Double) value, dec);
				}else{
					throw new MapToDataBusConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
			}
			dataBus.put(key, value);
		}
	}

	public void toMap(String idConv, DataBus dataBus, Map<String, Object> map) throws DataBusToMapConvException {
		Map<String, DataConv> convMap = this.conv.get(idConv);
		if (convMap == null) {
			throw new DataBusToMapConvException("转换标识[" + idConv + "]尚未配置");
		}
		Set<Entry<String, DataConv>> convMapEntries = convMap.entrySet();
		for (Entry<String, DataConv> convMapEntrie : convMapEntries) {
			DataConv dataConv = convMapEntrie.getValue();
			if (dataConv == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			Source source = dataConv.getSource();
			if (source == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String valueKey = source.getValue();
			if (valueKey == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String from = source.getFrom();
			if (from == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String type = source.getType();
			if (type == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			String key = dataConv.getDestination();
			if (key == null) {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误");
			}
			Object value = null;
			if (from.equals("constant")) {
				String valueString = dataConv.getSource().getValue();
				if (valueString == null) {
					throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				if(type.equals("integer")){
					value = Integer.valueOf(valueString);
				}else if(type.equals("double")){
					value = Double.valueOf(valueString);
				}else{
					value = valueString;
				}
			} else if (from.equals("databus")) {
				value = dataBus.get(valueKey, Object.class);
				if(value==null){
					continue;
				}
			}else {
				throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
			}
			Format format = dataConv.getFormat();
			if (format != null) {
				String formatStr = format.getValue().value();
				if (formatStr == null) {
					throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				Integer dec = format.getDec();
				if (dec == null) {
					throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
				if (formatStr.equals("point")) {
					value = DataUtil.removePoint((Double) value, dec);
				}else{
					throw new DataBusToMapConvException("转换文件[" + idConv + "]配置错误[" + dataConv + "]");
				}
			}
			map.put(key, value);
		}
	}

}
