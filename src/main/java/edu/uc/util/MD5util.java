package edu.uc.util;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5util {
	public static String getMD5BySalt(String str, String salt) {
		String encodeStr = null;
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			digest.update(salt.getBytes());
			byte[] byteArray = digest.digest(str.getBytes());
			for (int i = 0; i < byteArray.length; i++) {
				sb.append(Integer.toHexString((byteArray[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			encodeStr = getMD5ByCodeC(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	public static String getMD5ByCodeC(String str) {
		String encodeStr = DigestUtils.md5Hex(str);
		return encodeStr;
	}
}
