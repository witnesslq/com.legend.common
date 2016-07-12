package com.legend.common.core.pack.p8583;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.config.exception.ConfigLoadException;
import com.legend.common.config.pack.p8583.Pack8583Config;
import com.legend.common.core.config.config;
import com.legend.common.core.exception.Pack8583ConvException;
import com.legend.common.core.exception.Unpack8583ConvException;

public class Pack8583ConverterTest {

	@Test
	public void test8583()
			throws Pack8583ConvException, UnsupportedEncodingException, Unpack8583ConvException, ConfigLoadException {
		Pack8583Config pack8583Config = new Pack8583Config(config.TPS_CONFIG + "/host/Pack8583DicMap.xml");
		Pack8583Converter pack8583Converter = new Pack8583Converter(pack8583Config);
		Map<String, Object> reqMap = new LinkedHashMap<String, Object>();
		String reqMsgid = "0010";
		reqMap.put("MSGID", reqMsgid);
		String req0020 = "00001";
		reqMap.put("0020", req0020);
		String req0030 = "000002";
		reqMap.put("0030", req0030);
		Double req0040 = 123.45;
		reqMap.put("0040", req0040);
		Integer req0070 = 123;
		reqMap.put("0070", req0070);
		String req0370 = "621231123123";
		reqMap.put("0370", req0370);
		String req0570 = "周勇沩1哈哈";
		reqMap.put("0570", req0570);
		String req1020 = "ABCDEF";
		reqMap.put("1020", req1020);
		byte[] req1280 = "EEEEEEEE".getBytes();
		reqMap.put("1280", req1280);
		byte[] pack8583 = pack8583Converter.to8583(reqMap);
		String s = new String(pack8583, "UTF-8");
		System.out.println("PACK=[" + s + "][" + pack8583.length + "]");
		System.out.println("MAB=[" + reqMap.get("MAB") + "]");
		System.out.println("=======================================");
		Map<String, Object> rspMap = new LinkedHashMap<String, Object>();
		rspMap = pack8583Converter.toMap(pack8583);
		System.out.println(rspMap);
		System.out.println("MAB=[" + rspMap.get("MAB") + "]");
		Assert.assertEquals(reqMsgid, rspMap.get("MSGID"));
		Assert.assertEquals(req0020, rspMap.get("0020"));
		Assert.assertEquals(req0030, rspMap.get("0030"));
		Assert.assertEquals(req0040, rspMap.get("0040"));
		Assert.assertEquals(req0070, rspMap.get("0070"));
		Assert.assertEquals(req0370, rspMap.get("0370"));
		Assert.assertEquals(req0570, rspMap.get("0570"));
		Assert.assertEquals(req1020, rspMap.get("1020"));
		Assert.assertEquals(new String(req1280), new String((byte[]) rspMap.get("1280")));
		Assert.assertEquals(reqMap.get("MAB"), rspMap.get("MAB"));
	}

}
