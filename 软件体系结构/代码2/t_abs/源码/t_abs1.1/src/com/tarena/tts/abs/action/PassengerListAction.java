package com.tarena.tts.abs.action;

import java.util.List;
import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;

public class PassengerListAction extends BaseAction {
	
	//output
	private List<Passenger> passengers;
	
	//input
	private int page = 1;
	private int size = 5;
	private int totalPage = 1;
	
	public String execute() throws Exception{
		PassengerBiz passengerBiz = new PassengerBizImpl();
		
		//从session中取得登录用户信息
		User u = (User)session.get("user");
		
		totalPage = passengerBiz.countTotalPage(
				u.getUserId(), size);
		passengers = passengerBiz.getPassengersByLoginUser(
				u.getUserId(),page,size);

		return "success";
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
