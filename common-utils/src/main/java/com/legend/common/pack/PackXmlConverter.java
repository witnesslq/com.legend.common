package com.legend.common.pack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PackXmlConverter {

	public static <T>  String toXml(T model,Class<T> clazz,String charsetName) throws JAXBException, UnsupportedEncodingException {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty("jaxb.encoding", charsetName);
            ms.setProperty("jaxb.formatted.output", true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            ms.marshal(model, baos);
            return baos.toString(charsetName);
    }

	public static <T> T toBean(String xmlStr,Class<T> clazz,String charsetName) throws JAXBException, UnsupportedEncodingException {
        	JAXBContext  jc = JAXBContext.newInstance(clazz);
            Unmarshaller ums = jc.createUnmarshaller();
            ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes(charsetName));
            @SuppressWarnings("unchecked")
			T model =  (T) ums.unmarshal(bais);
            return model;
    }

}