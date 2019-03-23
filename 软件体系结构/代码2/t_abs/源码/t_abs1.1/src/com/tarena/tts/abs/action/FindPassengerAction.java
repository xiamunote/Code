package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;
import com.tarena.tts.abs.entity.Passenger;

public class FindPassengerAction extends BaseAction {
	
	private static final long serialVersionUID = -1504857634395238036L;
	
	//input
	private int passengerId;
	
	//output
	private Passenger passenger;
	
	@Override
	public String execute() throws Exception {
		
		PassengerBiz pBiz = new PassengerBizImpl();
		
		passenger = pBiz.getPassengerById(passengerId);
		
		return "success";
	}

	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
}
