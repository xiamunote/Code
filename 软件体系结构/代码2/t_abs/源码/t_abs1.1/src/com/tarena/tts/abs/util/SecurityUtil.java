package com.tarena.tts.abs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *	对字符串进行加密的算法
 *	md5加密算法，原则上不可逆的一种加密方法
 */
public class SecurityUtil {
	public static String md5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs = md.digest(str.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			String str1 = encoder.encode(bs);
			System.out.println(str1);
			return str1;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
