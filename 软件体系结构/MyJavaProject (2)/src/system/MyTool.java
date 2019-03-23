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
	 * 获得字体
	 * @param size
	 * @return
	 */
	public static Font getFontP(int size){//plain
		return new Font("微软雅黑", Font.PLAIN, size) ;
	}
	public static Font getFontB(int size){//bold
		return new Font("微软雅黑", Font.BOLD,size);
	}
	
	/*
	 * 获取当前时间
	 */
	public static String getCurrentTime(){
		String pattern = "yyyy-MM-dd HH:mm:ss";//自定义日期模板
		SimpleDateFormat sdf = new SimpleDateFormat() ;
		sdf.applyPattern(pattern);
		return sdf.format(new java.util.Date());//当前Date格式化
	}
	
	/**
	 * 
	 * 获得屏幕尺寸
	 */
	public static Dimension getScreen(){
		return Toolkit.getDefaultToolkit().getScreenSize() ;
	}
}

