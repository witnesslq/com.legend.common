package com.legend.common.core.databus;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.core.databus.datadic.DataDic;
import com.legend.common.core.databus.datadic.DataDicMap;
import com.legend.common.core.exception.DataBusLoadException;
import com.legend.common.core.exception.DatabusConvException;

public class DataBus {

	private static Logger logger = LoggerFactory.getLogger(DataBus.class);
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, DataDic> validateMap = new HashMap<String, DataDic>(); // 数据总线数据字典，在进行数据总线导入导出时进行类型检查

	public DataBus(String dataDicFileName) throws DataBusLoadException{
		loadDataBusValidateMap(dataDicFileName);
		logger.info("装载数据总线数据字典配置文件成功！！！");
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

	public Object put(String key, Object value){
		try {
			dataBusValidate(key,value);
		} catch (DatabusConvException e) {
			throw new RuntimeException(e);
		}
		return map.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> clazz) {
		try {
			dataBusValidate(key);
		} catch (DatabusConvException e) {
			throw new RuntimeException(e);
		}
		return (T) map.get(key);
	}
	
	Set<Map.Entry<String, Object>> entrySet(){
		return map.entrySet();
	}

	@Override
	public String toString() {
		return "DataBus [map=" + map + "]";
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
	
	private void dataBusValidate(String key) throws DatabusConvException {
		if (key == null ) {
			throw new DatabusConvException("非法的数据总线KEY值[" + key + "]");
		}
		DataDic dataDic = this.validateMap.get(key);
		if (dataDic == null) {
			throw new DatabusConvException("非法的数据总线KEY值[" + key + "]");
		}
	}

}