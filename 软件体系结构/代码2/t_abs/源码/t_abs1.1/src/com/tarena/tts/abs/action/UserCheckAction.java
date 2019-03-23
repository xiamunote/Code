package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;

/**
 * @ file_name UserCheckAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 16, 20125:16:03 PM
 * @ description
 * @ reviewed_by 
 */
public class UserCheckAction extends BaseAction{
	
	//input
	private String loginName;
	//output
	private boolean ok = false;
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public String execute() throws Exception {
		UserBiz biz = new UserBizImpl();
		ok = biz.checkUser(loginName);
		
		return "success";
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
