package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name UpdateUserAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 22, 20124:48:07 PM
 * @ description
 * @ reviewed_by 
 */
public class UpdateUserFormAction extends BaseAction{
	
	//output
	private User user;
	
	@Override
	public String execute() throws Exception {
		
		user = (User)session.get("user");
		return "success";
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
