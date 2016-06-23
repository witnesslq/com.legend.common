package com.legend.common.pack.pXml;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.legend.common.model.test.DataBase;
import com.legend.common.model.test.ObjectFactory;
import com.legend.common.pack.pXml.PackXmlConverter;

public class PackXmlConverter1Test {

	@Test
	public void testToXml() {
		ObjectFactory dataBaseFactory = new ObjectFactory();
		DataBase dataBase = dataBaseFactory.createDataBase();
		dataBase.setPassword("PP");
		dataBase.setUsername("UU");
		dataBase.setUrl("RR");
		try {
			String xmlPack = PackXmlConverter.toXml(dataBase,DataBase.class,"UTF-8");
			System.out.println(xmlPack);
		} catch (UnsupportedEncodingException | JAXBException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testToBean() throws UnsupportedEncodingException {
		String xmlStr="<DataBase xmlns=\"http://www.example.org/test\">"
					+ "<Username>Username</Username>" 
					+ "<Password>Password</Password>"
					+"<url>url</url>"
					+"</DataBase>";
		try {
			DataBase dataBase = PackXmlConverter.toBean(xmlStr,DataBase.class,"UTF-8");
			System.out.println(dataBase);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
