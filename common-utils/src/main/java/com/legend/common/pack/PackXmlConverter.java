package com.legend.common.pack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import com.legend.common.utils.DataUtil;

public class PackXmlConverter {

	public static <T> String toXml(T model, Class<T> clazz, String charsetName)
			throws JAXBException, UnsupportedEncodingException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Marshaller ms = jc.createMarshaller();
		ms.setProperty("jaxb.encoding", charsetName);
		ms.setProperty("jaxb.formatted.output", true);
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		ms.marshal(model, baos);
		return baos.toString(charsetName);
	}

	public static <T> T toBean(String xmlStr, Class<T> clazz, String charsetName)
			throws JAXBException, UnsupportedEncodingException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller ums = jc.createUnmarshaller();
		ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes(charsetName));
		@SuppressWarnings("unchecked")
		T model = (T) ums.unmarshal(bais);
		return model;
	}

	public static String getTxCode(String xmlStr, String xpath, String charsetName)
			throws DocumentException, UnsupportedEncodingException {
		String XMLNS = "xmlns";
		ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes(charsetName));
		SAXReader reader = new SAXReader();
		Document document = reader.read(bais);
		HashMap<String, String> xmlMap = new HashMap<String, String>();
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")
		List<Namespace> nameSpaces = root.declaredNamespaces();
		for (Namespace ns : nameSpaces) {
			String key = XMLNS;
			if (!DataUtil.isEmpty(ns.getPrefix())) {
				key += ":" + ns.getPrefix();
			}
			xmlMap.put(key, ns.getURI());
		}
		XPath x0 = document.createXPath(xpath);
		x0.setNamespaceURIs(xmlMap);
		Node node = x0.selectSingleNode(document);
		if(node==null){
			throw new DocumentException("交易代码不存在");
		}
		return node.getName();
	}

}