package com.legend.common.pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.legend.common.model.beps121.Document;
import com.legend.common.model.test.DataBase;
import com.legend.common.model.test.ObjectFactory;

public class testPackXmlConverter {

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
	
	@Test
	public void testToBean121() throws IOException {
		InputStream is = testPackXmlConverter.class.getClassLoader().getResourceAsStream("beps.121.001.01.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String xmlStr = "";
		String s = "";
		while(( s = br.readLine())!=null){
			xmlStr += s;
		}
		System.out.println(xmlStr);
		try {
			Document document = (Document) PackXmlConverter.toBean(xmlStr,Document.class,"UTF-8");
			System.out.println(document);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
