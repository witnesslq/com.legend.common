package com.legend.common.pack.pXml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Test;

import com.legend.common.exception.PackXmlConvException;
import com.legend.common.exception.UnpackXmlConvException;
import com.legend.common.model.beps.beps_121_001_01.CustomerCreditTransfer;
import com.legend.common.model.beps.beps_121_001_01.Document;
import com.legend.common.model.beps.beps_121_001_01.ObjectFactory;
import com.legend.common.model.beps.beps_121_001_01.PKGGroupHeader1;
import com.legend.common.pack.pXml.PackXmlConverter;

public class PackXmlConverter2Test {

	@Test
	public void testToXml() throws PackXmlConvException {
		ObjectFactory dataBaseFactory = new ObjectFactory();
		Document document = dataBaseFactory.createDocument();
		PKGGroupHeader1 pKGGrpHdr = new PKGGroupHeader1();
		pKGGrpHdr.setMsgId("20100101020302932");
		pKGGrpHdr.setRmk("Rmk");
		CustomerCreditTransfer customerCreditTransfer = new CustomerCreditTransfer();
		customerCreditTransfer.setPKGGrpHdr(pKGGrpHdr);
		document.setCstmrCdtTrf(customerCreditTransfer);
		String xmlPack = PackXmlConverter.toXml(document, Document.class, "UTF-8");
		System.out.println(xmlPack);
	}

	@Test
	public void testToBean() throws IOException, UnpackXmlConvException {
		InputStream is = PackXmlConverter2Test.class.getClassLoader().getResourceAsStream("beps.121.001.01.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xmlStr = "";
		String s = "";
		while ((s = br.readLine()) != null) {
			xmlStr += s;
		}
		Document document = (Document) PackXmlConverter.toBean(xmlStr, Document.class, "UTF-8");
		System.out.println(document);
	}

	@Test
	public void testGetTxCode1() throws IOException, UnpackXmlConvException {
		InputStream is = PackXmlConverter2Test.class.getClassLoader().getResourceAsStream("beps.121.001.01.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xmlStr = "";
		String s = "";
		while ((s = br.readLine()) != null) {
			xmlStr += s;
		}
		String txCode = PackXmlConverter.getTxCode(xmlStr, "/xmlns:Document/xmlns:CstmrCdtTrf/child::*[2]", "UTF-8");
		System.out.println("txCode=[" + txCode + "]");
	}

	@Test
	public void testGetTxCode2() throws IOException, UnpackXmlConvException {
		InputStream is = PackXmlConverter2Test.class.getClassLoader().getResourceAsStream("BQReq.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xmlStr = "";
		String s = "";
		while ((s = br.readLine()) != null) {
			xmlStr += s;
		}
		String txCode = PackXmlConverter.getTxCode(xmlStr, "/Cartoon/Message/*[@id]", "UTF-8");
		System.out.println("txCode=[" + txCode + "]");
	}

}
