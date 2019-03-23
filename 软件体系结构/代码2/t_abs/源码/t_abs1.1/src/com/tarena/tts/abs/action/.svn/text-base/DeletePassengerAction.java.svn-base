package com.tarena.tts.abs.action;

import java.sql.SQLException;

import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;

public class DeletePassengerAction extends BaseAction{
	private int id;
	
	public String execute() throws Exception{
		PassengerBiz passengerBiz = new PassengerBizImpl();
		passengerBiz.deletePassenger(id);
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
