package com.legend.common.databus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataBus {

	private Map<String, Object> map = new HashMap<String, Object>();

	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	public <T> T get(String key, Class<T> clazz) {
		return (T) map.get(key);
	}
	
	Set<Map.Entry<String, Object>> entrySet(){
		return map.entrySet();
	}

	@Override
	public String toString() {
		return "DataBus [map=" + map + "]";
	}
	
	

}