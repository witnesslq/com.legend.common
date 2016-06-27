package com.legend.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {

	public static String byteToHex(byte[] src) {
		StringBuffer sb = new StringBuffer();
		for (byte b : src) {
			sb.append(Integer.toHexString((b & 0XF0) >> 4)).append(Integer.toHexString(b & 0X0F));
		}
		return sb.toString().toUpperCase();
	}

	public static String byteToBin(byte[] src) {
		StringBuffer sb = new StringBuffer();
		for (byte b : src) {
			String high = Integer.toBinaryString((b & 0XF0) >> 4);
			String low = Integer.toBinaryString((b & 0X0F));
			int highLen = high.length();
			int lowLen = low.length();
			while (highLen < 4) {
				sb.append("0");
				++highLen;
			}
			sb.append(high);
			while (lowLen < 4) {
				sb.append("0");
				++lowLen;
			}
			sb.append(low);
		}
		return sb.toString().toUpperCase();
	}

	public static String md5(String src) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		return byteToHex(md.digest(src.getBytes()));
	}

}
