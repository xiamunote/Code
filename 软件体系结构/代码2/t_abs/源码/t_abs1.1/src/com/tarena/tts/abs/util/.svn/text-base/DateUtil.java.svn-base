package com.tarena.tts.abs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_PATTERN1 = "yyyy-MM-dd";
	
	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date);
	}
	
	public static String format1(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN1);
		return sdf.format(date);
	}

	public static Date parse(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
