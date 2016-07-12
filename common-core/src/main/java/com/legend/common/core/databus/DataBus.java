package com.legend.common.core.databus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.databus.DataBusConfig;
import com.legend.common.config.databus.DataDic;
import com.legend.common.core.exception.DatabusConvException;

public class DataBus {

	private static Logger logger = LoggerFactory.getLogger(DataBus.class);
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, DataDic> dataBusValidator ;

	public DataBus(DataBusConfig dataBusConfig) {
		this.dataBusValidator = dataBusConfig.getDataBusValidator();
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
		DataDic dataDic = this.dataBusValidator.get(key);
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
		DataDic dataDic = this.dataBusValidator.get(key);
		if (dataDic == null) {
			throw new DatabusConvException("非法的数据总线KEY值[" + key + "]");
		}
	}

}