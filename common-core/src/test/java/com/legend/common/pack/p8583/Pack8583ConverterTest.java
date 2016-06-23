package com.legend.common.pack.p8583;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.legend.common.exception.Pack8583Exception;
import com.legend.common.pack.p8583.Pack8583Converter;

public class Pack8583ConverterTest {

	@Test
	public void test8583() throws Pack8583Exception, UnsupportedEncodingException {
		Pack8583Converter pack8583Converter = new Pack8583Converter("Pack8583DicMap.xml");
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("0020", "00001");
		dataMap.put("0030", "0002");
//		dataMap.put("0070", "110011");
//		dataMap.put("0370", "621238787346445453");
//		dataMap.put("0540", "周勇沩");
//		dataMap.put("0640", "ABCDEF");
		byte[] pack8583 = pack8583Converter.to8583(dataMap);
		String s = new String(pack8583, "UTF-8");
		System.out.println("PACK=[" + s + "][" + pack8583.length + "]");
		System.out.println("=======================================");
		dataMap = pack8583Converter.toMap(pack8583);
		System.out.println(dataMap);
	}

}
