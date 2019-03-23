package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

public class UserInfoAction extends BaseAction {
	//output
	private User user;
		
	public String execute() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		
		//从session中取得登录用户对象
		User u = (User)session.get("user");
		
		user = userBiz.getUserInfo(u.getUserId());
		
		System.out.println(user + " #####UserInfoAction");
		
		return "success";
	}	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
