package system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

public class MyTool {
	
	static Image img;
	static Dimension dimension ;
	/**
	 * �������
	 * @param size
	 * @return
	 */
	public static Font getFontP(int size){//plain
		return new Font("΢���ź�", Font.PLAIN, size) ;
	}
	public static Font getFontB(int size){//bold
		return new Font("΢���ź�", Font.BOLD,size);
	}
	
	/*
	 * ��ȡ��ǰʱ��
	 */
	public static String getCurrentTime(){
		String pattern = "yyyy-MM-dd HH:mm:ss";//�Զ�������ģ��
		SimpleDateFormat sdf = new SimpleDateFormat() ;
		sdf.applyPattern(pattern);
		return sdf.format(new java.util.Date());//��ǰDate��ʽ��
	}
	
	/**
	 * 
	 * �����Ļ�ߴ�
	 */
	public static Dimension getScreen(){
		return Toolkit.getDefaultToolkit().getScreenSize() ;
	}
}

