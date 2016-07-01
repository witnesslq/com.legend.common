package com.legend.common.pack.pXml;

import org.junit.Test;

import com.legend.common.exception.PackXmlConvException;
import com.legend.common.exception.UnpackXmlConvException;
import com.legend.common.model.test.DataBase;
import com.legend.common.model.test.ObjectFactory;

public class PackXmlConverter1Test {

	@Test
	public void testToXml() throws PackXmlConvException {
		ObjectFactory dataBaseFactory = new ObjectFactory();
		DataBase dataBase = dataBaseFactory.createDataBase();
		dataBase.setPassword("PP");
		dataBase.setUsername("UU");
		dataBase.setUrl("RR");
		String xmlPack = PackXmlConverter.toXml(dataBase, DataBase.class, "UTF-8");
		System.out.println(xmlPack);
	}

	@Test
	public void testToBean() throws UnpackXmlConvException  {
		String xmlStr = "<DataBase xmlns=\"http://www.example.org/test\">" + "<Username>Username</Username>"
				+ "<Password>Password</Password>" + "<url>url</url>" + "</DataBase>";
		DataBase dataBase = PackXmlConverter.toBean(xmlStr, DataBase.class, "UTF-8");
		System.out.println(dataBase);
	}

}
