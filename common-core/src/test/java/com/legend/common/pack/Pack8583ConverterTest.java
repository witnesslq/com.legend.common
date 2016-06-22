package com.legend.common.pack;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.legend.common.exception.Pack8583Exception;

public class Pack8583ConverterTest {
	
	private static Map<Integer, Pack8583Dic> dataDic; 

	/*
	 * 初始化8583数据字典
	 */
	@Before
	public void init(){
		dataDic = new LinkedHashMap<Integer, Pack8583Dic>();
		dataDic.put(1, new Pack8583Dic(1, "0010", "1", "1", 5, 0, "机构"));
		dataDic.put(2, new Pack8583Dic(1, "0020", "1", "1", 5, 0, "柜员"));
		dataDic.put(3, new Pack8583Dic(1, "0030", "1", "1", 5, 0, "机构"));
		dataDic.put(4, new Pack8583Dic(1, "0040", "1", "1", 5, 0, "柜员"));
		dataDic.put(5, new Pack8583Dic(1, "0050", "1", "1", 5, 0, "机构"));
		dataDic.put(6, new Pack8583Dic(1, "0060", "1", "1", 5, 0, "柜员"));
		dataDic.put(7, new Pack8583Dic(1, "0070", "1", "1", 5, 0, "机构"));
		dataDic.put(8, new Pack8583Dic(1, "0080", "1", "1", 5, 0, "柜员"));
		dataDic.put(9, new Pack8583Dic(1, "0090", "1", "1", 5, 0, "机构"));
		dataDic.put(10, new Pack8583Dic(1, "0100", "1", "1", 5, 0, "柜员"));
		dataDic.put(11, new Pack8583Dic(1, "0110", "1", "1", 5, 0, "机构"));
		dataDic.put(12, new Pack8583Dic(1, "0120", "1", "1", 5, 0, "柜员"));
		dataDic.put(13, new Pack8583Dic(1, "0130", "1", "1", 5, 0, "机构"));
		dataDic.put(14, new Pack8583Dic(1, "0140", "1", "1", 5, 0, "柜员"));
		dataDic.put(15, new Pack8583Dic(1, "0150", "1", "1", 5, 0, "机构"));
		dataDic.put(16, new Pack8583Dic(1, "0160", "1", "1", 5, 0, "柜员"));
		dataDic.put(17, new Pack8583Dic(1, "0170", "1", "1", 5, 0, "机构"));
		dataDic.put(18, new Pack8583Dic(1, "0180", "1", "1", 5, 0, "柜员"));
		dataDic.put(19, new Pack8583Dic(1, "0190", "1", "1", 5, 0, "机构"));
		dataDic.put(20, new Pack8583Dic(1, "0200", "1", "1", 5, 0, "柜员"));
		dataDic.put(21, new Pack8583Dic(1, "0210", "1", "1", 5, 0, "机构"));
		dataDic.put(22, new Pack8583Dic(1, "0220", "1", "1", 5, 0, "柜员"));
		dataDic.put(23, new Pack8583Dic(1, "0230", "1", "1", 5, 0, "机构"));
		dataDic.put(24, new Pack8583Dic(1, "0240", "1", "1", 5, 0, "柜员"));
		dataDic.put(25, new Pack8583Dic(1, "0250", "1", "1", 5, 0, "机构"));
		dataDic.put(26, new Pack8583Dic(1, "0260", "1", "1", 5, 0, "柜员"));
		dataDic.put(27, new Pack8583Dic(1, "0270", "1", "1", 5, 0, "机构"));
		dataDic.put(28, new Pack8583Dic(1, "0280", "1", "1", 5, 0, "柜员"));
		dataDic.put(29, new Pack8583Dic(1, "0290", "1", "1", 5, 0, "机构"));
		dataDic.put(30, new Pack8583Dic(1, "0300", "1", "1", 5, 0, "柜员"));
		dataDic.put(31, new Pack8583Dic(1, "0310", "1", "1", 5, 0, "机构"));
		dataDic.put(32, new Pack8583Dic(1, "0320", "1", "1", 5, 0, "柜员"));
		dataDic.put(33, new Pack8583Dic(1, "0330", "1", "1", 5, 0, "机构"));
		dataDic.put(34, new Pack8583Dic(1, "0340", "1", "1", 5, 0, "柜员"));
		dataDic.put(35, new Pack8583Dic(1, "0350", "1", "1", 5, 0, "机构"));
		dataDic.put(36, new Pack8583Dic(1, "0360", "1", "1", 5, 0, "柜员"));
		dataDic.put(37, new Pack8583Dic(1, "0370", "1", "1", 5, 0, "机构"));
		dataDic.put(38, new Pack8583Dic(1, "0380", "1", "1", 5, 0, "柜员"));
		dataDic.put(39, new Pack8583Dic(1, "0390", "1", "1", 5, 0, "机构"));
		dataDic.put(40, new Pack8583Dic(1, "0400", "1", "1", 5, 0, "柜员"));
		dataDic.put(41, new Pack8583Dic(1, "0410", "1", "1", 5, 0, "机构"));
		dataDic.put(42, new Pack8583Dic(1, "0420", "1", "1", 5, 0, "柜员"));
		dataDic.put(43, new Pack8583Dic(1, "0430", "1", "1", 5, 0, "机构"));
		dataDic.put(44, new Pack8583Dic(1, "0440", "1", "1", 5, 0, "柜员"));
		dataDic.put(45, new Pack8583Dic(1, "0450", "1", "1", 5, 0, "机构"));
		dataDic.put(46, new Pack8583Dic(1, "0460", "1", "1", 5, 0, "柜员"));
		dataDic.put(47, new Pack8583Dic(1, "0470", "1", "1", 5, 0, "机构"));
		dataDic.put(48, new Pack8583Dic(1, "0480", "1", "1", 5, 0, "柜员"));
		dataDic.put(49, new Pack8583Dic(1, "0490", "1", "1", 5, 0, "机构"));
		dataDic.put(50, new Pack8583Dic(1, "0500", "1", "1", 5, 0, "柜员"));
		dataDic.put(51, new Pack8583Dic(1, "0510", "1", "1", 5, 0, "机构"));
		dataDic.put(52, new Pack8583Dic(1, "0520", "1", "1", 5, 0, "柜员"));
		dataDic.put(53, new Pack8583Dic(1, "0530", "1", "1", 5, 0, "机构"));
		dataDic.put(54, new Pack8583Dic(1, "0540", "1", "1", 5, 0, "柜员"));
		dataDic.put(55, new Pack8583Dic(1, "0550", "1", "1", 5, 0, "机构"));
		dataDic.put(56, new Pack8583Dic(1, "0560", "1", "1", 5, 0, "柜员"));
		dataDic.put(57, new Pack8583Dic(1, "0570", "1", "1", 5, 0, "机构"));
		dataDic.put(58, new Pack8583Dic(1, "0580", "1", "1", 5, 0, "柜员"));
		dataDic.put(59, new Pack8583Dic(1, "0590", "1", "1", 5, 0, "机构"));
		dataDic.put(60, new Pack8583Dic(1, "0600", "1", "1", 5, 0, "柜员"));
		dataDic.put(61, new Pack8583Dic(1, "0610", "1", "1", 5, 0, "机构"));
		dataDic.put(62, new Pack8583Dic(1, "0620", "1", "1", 5, 0, "柜员"));
		dataDic.put(63, new Pack8583Dic(1, "0630", "1", "1", 5, 0, "机构"));
		dataDic.put(64, new Pack8583Dic(1, "0640", "1", "1", 5, 0, "柜员"));
	}

	@Test
	public void test8583_64() throws Pack8583Exception, UnsupportedEncodingException {
		Pack8583Converter pack8583Converter = new Pack8583Converter(dataDic);
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("0020", "00001");
		dataMap.put("0030", "0002");
		dataMap.put("0070", "110011");
		dataMap.put("0370", "621238787346445453");
		dataMap.put("0540", "周勇沩");
		dataMap.put("0640", "ABCDEF");
		byte[] pack8583 = pack8583Converter.to8583_64(dataMap);
		String s = new String(pack8583,"UTF-8");
		System.out.println("PACK=["+s+"]["+pack8583.length+"]");
		System.out.println("=======================================");
		dataMap = pack8583Converter.toMap_64(pack8583);
		System.out.println(dataMap);
	}

}
