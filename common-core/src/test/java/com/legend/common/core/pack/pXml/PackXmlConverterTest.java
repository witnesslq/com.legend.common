package com.legend.common.core.pack.pXml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.core.exception.PackXmlConvException;
import com.legend.common.core.exception.UnpackXmlConvException;
import com.legend.common.core.pack.pXml.model.beps.beps_121_001_01.Document;


public class PackXmlConverterTest {

	@Test
	public void testPackXmlConverter() throws IOException, UnpackXmlConvException, PackXmlConvException {
		String filePath = PackXmlConverterTest.class.getClassLoader().getResource("beps.121.001.01.xml").getPath();
		File file = new File(filePath);
		byte[] context = new byte[(int) file.length()];
		InputStream is = new FileInputStream(file);
		is.read(context);
		is.close();
		String reqXml = new String(context,"UTF-8");
		Document document = (Document) PackXmlConverter.toBean(reqXml, Document.class, "UTF-8");
		Assert.assertEquals(document.getCstmrCdtTrf().getPKGGrpHdr().getMsgId(), "2010101000001260");
		String rspXml = PackXmlConverter.toXml(document, Document.class, "UTF-8");
//		System.out.println(rspXml);
		Assert.assertTrue(rspXml.length()>100);
	}

	@Test
	public void testGetTxCode1() throws IOException, UnpackXmlConvException {
		InputStream is = PackXmlConverterTest.class.getClassLoader().getResourceAsStream("beps.121.001.01.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xmlStr = "";
		String s = "";
		while ((s = br.readLine()) != null) {
			xmlStr += s;
		}
		String txCode = PackXmlConverter.getTxCode(xmlStr, "/xmlns:Document/xmlns:CstmrCdtTrf/child::*[2]", "UTF-8");
		Assert.assertEquals(txCode, "CstmrCdtTrfInf");
	}

	@Test
	public void testGetTxCode2() throws IOException, UnpackXmlConvException {
		InputStream is = PackXmlConverterTest.class.getClassLoader().getResourceAsStream("BQReq.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String xmlStr = "";
		String s = "";
		while ((s = br.readLine()) != null) {
			xmlStr += s;
		}
		String txCode = PackXmlConverter.getTxCode(xmlStr, "/Cartoon/Message/*[@id]", "UTF-8");
		Assert.assertEquals(txCode, "BQReq");
	}

}
