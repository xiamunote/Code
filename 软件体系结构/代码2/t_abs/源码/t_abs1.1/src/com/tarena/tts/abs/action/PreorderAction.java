package com.tarena.tts.abs.action;

import java.util.ArrayList;
import java.util.List;

import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.vo.Flight01;

/**
 * @ file_name PreorderAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 28, 20122:19:54 PM
 * @ description
 * @ reviewed_by 
 */
public class PreorderAction extends BaseAction{
	
	//input
	private String buy;		//保存的是头等舱flightNum_F,公务舱flightNum_B,经济舱flightNum_E
	private int adult;		//成年乘机人人数
	private int child;		//小孩子乘机人人数
	private int infaint;	//baby乘机人人数
	
	//output
	private Flight01 fl;
	private String cabinClassName;		//舱位：头等舱、公务舱、经济舱
	
	private List<Passenger> psgAdult = new ArrayList<Passenger>();	//常用乘机人(成人)
	private List<Passenger> psgChild = new ArrayList<Passenger>();	//常用乘机人(小孩子)
	private List<Passenger> psgInfant = new ArrayList<Passenger>();	//常用乘机人(婴儿)
	
	@Override
	public String execute() throws Exception {
		
		FlightBiz biz = new FlightBizImpl();
		PassengerBiz passengerBiz = new PassengerBizImpl();
		
		//1 通过传入的FlightId查询航班信息
		String fid = buy.substring(0,buy.indexOf("_"));	
		fl = biz.findFlById(fid);
		
		//2 舱位信息
		String cabin = buy.substring(buy.lastIndexOf("_") , buy.length());
		if("_F".equals(cabin)){
			cabinClassName = "头等舱";
		}
		if("_B".equals(cabin)){
			cabinClassName = "公务舱";
		}
		if("_E".equals(cabin)){
			cabinClassName = "经济舱";
		}
		
		User user = (User) session.get("user");
		
		//查找出所有的常用旅客信息
		List<Passenger> passengers = 
			passengerBiz.getPassengersByLoginUser(user.getUserId());
		
		for(Passenger p : passengers){
		
			if("A".equals(p.getPsgType())){	//成人
				psgAdult.add(p);
			}
			else if("C".equals(p.getPsgType())){	//儿童
				psgChild.add(p);
			}
			else if("I".equals(p.getPsgType())){	//婴儿
				psgInfant.add(p);
			}
		}
		
		return "success";
	}

	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getInfaint() {
		return infaint;
	}
	public void setInfaint(int infaint) {
		this.infaint = infaint;
	}
	public Flight01 getFl() {
		return fl;
	}
	public void setFl(Flight01 fl) {
		this.fl = fl;
	}
	public String getCabinClassName() {
		return cabinClassName;
	}
	public void setCabinClassName(String cabinClassName) {
		this.cabinClassName = cabinClassName;
	}
	public List<Passenger> getPsgAdult() {
		return psgAdult;
	}
	public void setPsgAdult(List<Passenger> psgAdult) {
		this.psgAdult = psgAdult;
	}
	public List<Passenger> getPsgChild() {
		return psgChild;
	}
	public void setPsgChild(List<Passenger> psgChild) {
		this.psgChild = psgChild;
	}
	public List<Passenger> getPsgInfant() {
		return psgInfant;
	}
	public void setPsgInfant(List<Passenger> psgInfant) {
		this.psgInfant = psgInfant;
	}
	
}
