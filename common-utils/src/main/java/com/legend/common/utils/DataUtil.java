package com.legend.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.legend.common.utils.exception.BeanToMapException;
import com.legend.common.utils.exception.MapToBeanException;

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

	public static <T> Map<String, Object> beanToMap(T bean) throws BeanToMapException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		beanToMap(bean, map, bean.getClass().getSimpleName().toLowerCase());
		return map;
	}

	private static <T> void beanToMap(T bean, Map<String, Object> map, String prefix) throws BeanToMapException {
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (methodName.startsWith("get") && !methodName.equals("getClass")) {
				String key = prefix == null ? methodName.substring(3).toLowerCase()
						: prefix + "." + methodName.substring(3).toLowerCase();
				Object value;
				try {
					value = method.invoke(bean);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					throw new BeanToMapException("调用bean[" + bean + "]的方法[" + methodName + "]异常" + e);
				}
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

	public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) throws MapToBeanException
			{
		return mapToBean(map, clazz, clazz.getSimpleName().toLowerCase());
	}

	private static <T> T mapToBean(Map<String, Object> map, Class<T> clazz, String prefix) throws MapToBeanException
			{
		T model = null;
		try {
			model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new MapToBeanException("实例化bean["+clazz+"]异常" + e);
		}
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
						try {
							method.invoke(model, value);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							throw new MapToBeanException("调用bean[" + clazz + "]的方法[" + methodName + "]异常" + e);
						}
					}
				} else {
					Object value = mapToBean(map, parameterType, key);
					try {
						method.invoke(model, value);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						throw new MapToBeanException("调用bean[" + clazz + "]的方法[" + methodName + "]异常" + e);
					}
				}
			}
		}
		return model;
	}

	public static String fillZeroLeft(Integer source, int dataLen) {
		return String.format("%0" + dataLen + "d", source);
	}

	public static String fillSpaceRight(String source, int dataLen) {
		return String.format("%-" + dataLen + "s", source);
	}

	public static String removePoint(Double source, int dataLen, int dec) {
		Double d = source * Math.pow(10, dec);
		return String.format("%0" + dataLen + "d", Math.round(d));
	}

	public static Double addPoint(Double source, int dataLen, int dec) {
		return source / Math.pow(10, dec);
	}

}
