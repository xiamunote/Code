package com.tarena.tts.abs.util;

public class ChangeTypeUtil {

	public static String changeUserCertifTypeToWord(String message) {
		String result = null;
		if ("NI".equals(message)) {
			result = "身份证";
		} else if ("PP".equals(message)) {
			result = "护照";
		} else {
			result = "其他证件";
		}
		return result;
	}
	
	public static String changeUserCertifTypeToLetter(String message) {
		String result = null;
		if ("身份证".equals(message)) {
			result = "NI";
		} else if ("护照".equals(message)) {
			result = "PP";
		} else {
			result = "ID";
		}
		return result;
	}
	
	public static String changePsgTypeToWord(String message) {
		String result;
		if ("A".equals(message)) {
			result = "成人";
		} else if ("C".equals(message)) {
			result = "儿童";
		} else {
			result = "婴儿";
		}
		return result;
	}
	
	public static String changePsgTypeToLetter(String message) {
		String result = null;
		if ("成人".equals(message)) {
			result = "A";
		} else if ("儿童".equals(message)) {
			result = "C";
		} else {
			result = "I";
		}
		return result;
	}
}
