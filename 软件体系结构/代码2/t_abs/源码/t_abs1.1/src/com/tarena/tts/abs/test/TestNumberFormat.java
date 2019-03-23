package com.tarena.tts.abs.test;

import java.text.NumberFormat;

/**
 * @ file_name TestNumberFormat.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 27, 20125:17:15 PM
 * @ description
 * @ reviewed_by 
 */
public class TestNumberFormat {
	public static void main(String[] args) {
		int i = 1;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(2);
		System.out.println(nf.format(i));
	}
}
