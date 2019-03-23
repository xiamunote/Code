package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name UserRegisterAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 15, 20122:56:46 PM
 * @ description
 * @ reviewed_by 
 */
public class UserRegister01Action extends BaseAction{
	
	//input
	private String loginName;
	private String password;
	private String email;
	private String userName;
	private String telephone;
	
	@Override
	public String execute() throws Exception {
		
		UserBiz biz = new UserBizImpl();
		
		System.out.println("loginName:" + loginName);
		System.out.println("password:" + password);
		System.out.println("email:" + email);
		System.out.println("userName:" + userName);
		System.out.println("telephone:" + telephone);
		
		User user = biz.register01(
				loginName, password, email, userName, telephone);
		//注册成功后，放入session
		session.put("user", user);
		return "success";
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
