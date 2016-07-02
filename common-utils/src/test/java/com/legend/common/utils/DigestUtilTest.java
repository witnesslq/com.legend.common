package com.legend.common.utils;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class DigestUtilTest {
	
	@Test
	public void testByteToHex(){
		String s = DigestUtil.byteToHex("0123456789".getBytes());
		Assert.assertEquals(s,"30313233343536373839");
	}
	
	@Test
	public void testByteToBin(){
		String s = DigestUtil.byteToBin("123".getBytes());
		Assert.assertEquals(s,"001100010011001000110011");
	}

	@Test
	public void testMd5() throws NoSuchAlgorithmException {
		String s = DigestUtil.md5("abc");
		Assert.assertTrue(s.length()==32);
	}

}
