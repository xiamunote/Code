package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.ChangeTypeUtil;

public class UpdatePassengerAction extends BaseAction{
	
	private Passenger passenger;
	private boolean ok = false;

	public String execute(){
		PassengerBiz passengerBiz = new PassengerBizImpl();
		try {
			
			//设置关联的userId
			User u = (User)session.get("user");
			passenger.setRefUserId(u.getUserId());
			
			//处理psgCretifType汉字和字母的转换
			passenger.setPsgCertifType(
					ChangeTypeUtil.changeUserCertifTypeToLetter(
							passenger.getPsgCertifType()));
			
			
			passengerBiz.saveOrUpdatePassenger(passenger);
			
			ok = true;
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return "success";
	}
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}
