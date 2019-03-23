package com.tarena.tts.abs.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ file_name Test.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 27, 201211:50:35 AM
 * @ description
 * @ reviewed_by 
 */
public class TestCalendar {
	public static void main(String[] args) {
		Date d = new Date();
		//02 起飞日期当日结束时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		System.out.println(cal.get(Calendar.YEAR));
	}
}
