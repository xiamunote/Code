package com.tarena.tts.abs.ui;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.tts.abs.biz.CityBiz;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.entity.City;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.SecurityUtil;
import com.tarena.tts.abs.vo.Flight01;

/**
 * 客户端控制器 负责控制Swing界面的流程
 * 
 * @author Ronin
 * 
 */
public class ClientContext {

	// UI
	private LoginFrame loginFrame;
	private MainFrame mainFrame;

	// BIZ
	private UserBiz userBiz;
	private CityBiz cityBiz;
	private FlightBiz flightBiz;

	// Entity
	User user;
	
	// set&get方法
	public void setLoginFrame(LoginFrame loginFrame) {this.loginFrame = loginFrame;}
	public void setMainFrame(MainFrame mainFrame) {this.mainFrame = mainFrame;}
	public void setUserBiz(UserBiz userBiz) {this.userBiz = userBiz;}
	public void setCityBiz(CityBiz cityBiz) {this.cityBiz = cityBiz;}
	public void setFlightBiz(FlightBiz flightBiz) {this.flightBiz = flightBiz;}
	
	/**
	 * 界面显示流程控制
	 */
	public void show() {
		loginFrame.setVisible(true);
	}

	/**
	 * 登录流程控制
	 */
	public User login() {

		String name = loginFrame.getName();
		String pwd = SecurityUtil.md5(new String(loginFrame.getPassword()));

		try {
			user = userBiz.login(name, pwd);

			if (user != null) {
				
				loginFrame.setVisible(false);
				
				// 1. 业务查询(获得City的List集合)
				List<City> cities = this.getCities();
				// 2. 更新界面
				mainFrame.updateCity(cities);
				
				mainFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this.loginFrame,
						"用户名或密码错误! 请重新输入");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(mainFrame, "服务器异常");
		}

		return user;
	}
	
	/**
	 * 获得城市(City)的List集合
	 */
	private List<City> getCities() {
		
		// 1. 业务查询(获得所有city的list集合)
		try {
			List<City> cities = cityBiz.getCityList();
			return cities;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(mainFrame, "服务器异常");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 退出系统
	 * 
	 * @param source
	 */
	public void exit(JFrame source) {
		int val = JOptionPane.showConfirmDialog(source, "走呀?", "离开系统",
				JOptionPane.YES_NO_OPTION);
		if (val == JOptionPane.YES_OPTION) {
			source.setVisible(false);
			System.exit(0);
		}
	}
	
	/**
	 * 查询航班(Flight)信息
	 */
	public void search(){
		
		//1. 从界面获得查询条件(获取出发城市、目的城市、出发时间)
		String deptCity = 
			(String)mainFrame.getDeptBox().getSelectedItem();	//出发城市
		String destCity = 
			(String)mainFrame.getDestBox().getSelectedItem();	//目的城市
		Date flightDate = getFlightDate();	//出发日期
		
		//2. 业务查询(查询出航班信息)
		
		List<Flight01> flightList = null;
		try {
			flightList = flightBiz.findFlight01(
					deptCity ,destCity , flightDate , null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (flightList.isEmpty()) {
			JOptionPane.showMessageDialog(
					this.mainFrame , "没有航班信息!");
		}
			
		System.out.println(flightList);
		
		//3. 更新界面显示查询结果
		mainFrame.updateSearchReault(flightList);
	}
	
	/**
	 * 获得Date格式的出发时间
	 * @return
	 */
	private Date getFlightDate() {
		Calendar c = 
			(GregorianCalendar)mainFrame.getDatePicker().getModel().getValue();
		if(c!=null){
			return c.getTime();
		}
		return null;
	}
	
	/**
	 * 准备订单数据(MainFrame界面点击"下一步"按钮)
	 */
	public void preorder() {
		//1. 从界面获得条件
		int passengerNum = (Integer)mainFrame.getPassengerNum().getSelectedItem();
		
		//2. 更新界面
		mainFrame.updateCenterPane_Preorder(passengerNum);
		
	}
	
}
