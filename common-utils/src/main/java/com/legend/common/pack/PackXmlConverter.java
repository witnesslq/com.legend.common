package com.legend.common.pack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PackXmlConverter {

	public static String toXml(Object obj) {
		XStream xstream = new XStream(new DomDriver("utf8"));
		xstream.processAnnotations(obj.getClass());
		return xstream.toXML(obj);
	}

	public static <T> T toBean(String xmlStr, Class<T> clazz) {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(clazz);
		@SuppressWarnings("unchecked")
		T t = (T) xstream.fromXML(xmlStr);
		return t;
	}

}