package com.legend.common.pack.p8583;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.legend.common.config.config;
import com.legend.common.exception.Pack8583Exception;
import com.legend.common.pack.p8583.Pack8583Converter;

public class Pack8583ConverterTest {

	@Test
	public void test8583() throws Pack8583Exception, UnsupportedEncodingException {
		Pack8583Converter pack8583Converter = new Pack8583Converter(config.TPS_CONFIG+"/host/Pack8583DicMap.xml");
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("MSGID", "0010");
		dataMap.put("0020", "00001");
		dataMap.put("0030", "000002");
		dataMap.put("0040", 123.45);
		dataMap.put("0070", 123);
		dataMap.put("0370", "621231123123");
		dataMap.put("0570", "周勇沩1哈哈");
		dataMap.put("1020", "ABCDEF");
		dataMap.put("1280", "EEEEEEEE".getBytes());
		byte[] pack8583 = pack8583Converter.to8583(dataMap);
		String s = new String(pack8583, "UTF-8");
		System.out.println("PACK=[" + s + "][" + pack8583.length + "]");
		System.out.println("MAB=["+dataMap.get("MAB")+"]");
		System.out.println("=======================================");
		dataMap = pack8583Converter.toMap(pack8583);
		System.out.println(dataMap);
		System.out.println("MAB=["+dataMap.get("MAB")+"]");
	}

}
