package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name FindUserPasswordAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 22, 201211:05:39 AM
 * @ description
 * @ reviewed_by 
 */
public class CheckUserPasswordAction extends BaseAction{
	
	//input
	private String oldPassword;
	//output
	private boolean ok = false;
	
	@Override
	public String execute() throws Exception {
	
		UserBiz biz = new UserBizImpl();
		
		User u = (User)session.get("user");
		ok = biz.checkPassword(u.getUserId(), oldPassword);
		
		return "success";
	}

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
