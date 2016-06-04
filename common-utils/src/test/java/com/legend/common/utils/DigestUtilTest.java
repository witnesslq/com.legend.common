package com.legend.common.utils;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class DigestUtilTest {

	@Test
	public void testMd5() throws NoSuchAlgorithmException {
		String s = DigestUtil.md5("abc");
		Assert.assertTrue(s.length()==32);
	}

}
