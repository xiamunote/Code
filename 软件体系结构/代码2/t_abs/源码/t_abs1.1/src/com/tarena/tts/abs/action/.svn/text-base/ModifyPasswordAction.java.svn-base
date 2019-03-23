package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

public class ModifyPasswordAction extends BaseAction{
	
	//input
	private String oldPassword;
	private String newPassword;	
	private boolean ok = false;

	public String execute() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		
		User u =(User)session.get("user");
		
		ok = userBiz.changePassword(
				u,oldPassword, newPassword);

		return "success";
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
