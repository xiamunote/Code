package com.tarena.tts.abs.ui;

import com.tarena.tts.abs.biz.CityBiz;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.CityBizImpl;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.biz.impl.UserBizImpl;

/**
 * Swing界面引导程序, 负责装配Swing界面 控制器 以及业务层.
 * @author Ronin
 *
 */
public class Main {
  public static void main(String[] args) {
	  
	  //创建控制器
	  ClientContext context = new ClientContext();
	  
	  //创建界面对象
	  LoginFrame loginFrame = new LoginFrame(context);
	  MainFrame mainFrame = new MainFrame(context);  
	  //注入控制器
	  context.setLoginFrame(loginFrame);
	  context.setMainFrame(mainFrame);
	  
	  //创建业务对象
	  UserBiz userBiz = new UserBizImpl();
	  CityBiz cityBiz = new CityBizImpl();
	  FlightBiz flightBiz = new FlightBizImpl();
	  //注入控制器
	  context.setUserBiz(userBiz);
	  context.setCityBiz(cityBiz);
	  context.setFlightBiz(flightBiz);
	  
	  context.show();
  }
}
