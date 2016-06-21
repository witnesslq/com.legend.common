package com.legend.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;

public class DataUtil {

	public static void beanCopy(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static boolean isEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static <T> Map<String, Object> beanToMap(T bean)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		beanToMap(bean, map, bean.getClass().getSimpleName().toLowerCase());
		return map;
	}

	private static <T> void beanToMap(T bean, Map<String, Object> map, String prefix)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get") && !methodName.equals("getClass")) {
				String key = prefix == null ? methodName.substring(3).toLowerCase()
						: prefix + "." + methodName.substring(3).toLowerCase();
				Object value = method.invoke(bean);
				Class<?> returnType = method.getReturnType();
				if (returnType == String.class || returnType == Date.class || returnType == char.class
						|| returnType == Byte.class || returnType == byte.class || returnType == Boolean.class
						|| returnType == boolean.class || returnType == Short.class || returnType == short.class
						|| returnType == Integer.class || returnType == int.class || returnType == Float.class
						|| returnType == float.class || returnType == Long.class || returnType == long.class
						|| returnType == Double.class || returnType == double.class) {
					map.put(key, value);
				} else {
					beanToMap(value, map, key);
				}
			}
		}
	}

	public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return mapToBean(map, clazz, clazz.getSimpleName().toLowerCase());
	}

	private static <T> T mapToBean(Map<String, Object> map, Class<T> clazz, String prefix)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T model = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("set") && method.getParameterCount() == 1) {
				String key = prefix == null ? methodName.substring(3).toLowerCase()
						: prefix + "." + methodName.substring(3).toLowerCase();
				Class<?> parameterType = method.getParameters()[0].getType();
				if (parameterType == String.class || parameterType == Date.class || parameterType == char.class
						|| parameterType == Byte.class || parameterType == byte.class || parameterType == Boolean.class
						|| parameterType == boolean.class || parameterType == Short.class
						|| parameterType == short.class || parameterType == Integer.class || parameterType == int.class
						|| parameterType == Float.class || parameterType == float.class || parameterType == Long.class
						|| parameterType == long.class || parameterType == Double.class
						|| parameterType == double.class) {
					Object value = map.get(key);
					if (value != null) {
						System.out.println(key);
						method.invoke(model, value);
					}
				} else {
					Object value = mapToBean(map, parameterType, key);
					method.invoke(model, value);
				}
			}
		}
		return model;
	}

}
