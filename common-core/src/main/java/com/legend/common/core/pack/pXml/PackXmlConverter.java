package com.legend.common.core.pack.pXml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import com.legend.common.core.exception.PackXmlConvException;
import com.legend.common.core.exception.UnpackXmlConvException;
import com.legend.common.utils.DataUtil;

public class PackXmlConverter {

	public static String toXml(Object bean, Class<?> clazz, String charsetName) throws PackXmlConvException {
		if (bean == null) {
			throw new PackXmlConvException("Xml报文转换失败，数据源Bean为NULL");
		}
		if (DataUtil.isEmpty(charsetName)) {
			charsetName = "UTF-8";
		}
		JAXBContext jc;
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		try {
			jc = JAXBContext.newInstance(clazz);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty("jaxb.encoding", charsetName);
			ms.setProperty("jaxb.formatted.output", true);
			ms.marshal(bean, baos);
		} catch (JAXBException e) {
			throw new PackXmlConvException("Xml报文转换失败" + e);
		}
		String xmlStr = null;
		try {
			xmlStr = baos.toString(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw new PackXmlConvException("不支持的编码类型[" + charsetName + "]" + e);
		}
		return xmlStr;
	}

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xmlStr, Class<T> clazz, String charsetName)
			throws UnpackXmlConvException {
		if (DataUtil.isEmpty(xmlStr)) {
			throw new UnpackXmlConvException("Xml报文转换失败，收到的Xml字符串为空");
		}
		if (DataUtil.isEmpty(charsetName)) {
			charsetName = "UTF-8";
		}
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(xmlStr.getBytes(charsetName));
		} catch (UnsupportedEncodingException e) {
			throw new UnpackXmlConvException("不支持的编码类型[" + charsetName + "]" + e);
		}
		T model = null;
		try{
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller ums = jc.createUnmarshaller();
			model = (T) ums.unmarshal(bais);
		}catch (JAXBException e) {
			throw new UnpackXmlConvException("Xml报文转换失败"+e);
		}
		return model;
	}

	public static String getTxCode(String xmlStr, String xPath, String charsetName)
			throws UnpackXmlConvException {
		String XMLNS = "xmlns";
		if (DataUtil.isEmpty(xmlStr)) {
			throw new UnpackXmlConvException("收到的Xml文档为null,解析交易码失败");
		}
		if (DataUtil.isEmpty(xPath)) {
			throw new UnpackXmlConvException("收到的xPath为null,解析交易码失败");
		}
		if (DataUtil.isEmpty(charsetName)) {
			charsetName = "UTF-8";
		}
		ByteArrayInputStream bais;
		try {
			bais = new ByteArrayInputStream(xmlStr.getBytes(charsetName));
		} catch (UnsupportedEncodingException e) {
			throw new UnpackXmlConvException("不支持的编码类型[" + charsetName + "]" + e);
		}
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(bais);
		} catch (DocumentException e) {
			throw new UnpackXmlConvException("解析Xml报文交易码失败"+e);
		}
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
		XPath x0 = document.createXPath(xPath);
		x0.setNamespaceURIs(xmlMap);
		Node node = x0.selectSingleNode(document);
		if (node == null) {
			throw new UnpackXmlConvException("交易代码不存在");
		}
		return node.getName();
	}

}