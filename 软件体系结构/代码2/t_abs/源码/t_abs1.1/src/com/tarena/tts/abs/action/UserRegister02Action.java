package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.ChangeTypeUtil;

/**
 * @ file_name UserRegisterAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 15, 20122:56:46 PM
 * @ description
 * @ reviewed_by 
 */
public class UserRegister02Action extends BaseAction{
	
	//input
	private String regLoginName;
	private String regPassword;
	private String regUserName;
	private String regEmail;
	private String regTelephone;
	private String regUserCertifType;
	private String regUserCertifNum;
	
	//output
	private User user;
	
	@Override
	public String execute() throws Exception {
		
		UserBiz biz = new UserBizImpl();
		
		System.out.println("loginName:" + regLoginName);
		System.out.println("password:" + regPassword);
		System.out.println("userName:" + regUserName);
		System.out.println("email:" + regEmail);
		System.out.println("telephone:" + regTelephone);
		System.out.println("userCertifType:"+regUserCertifType);
		System.out.println("userCertifNum:" + regUserCertifNum);
		
		user = biz.register02(
				regLoginName , regPassword , regUserName , 
				regEmail , regTelephone , regUserCertifType , regUserCertifNum);
		
		
		user.setUserPassengerType(
				ChangeTypeUtil.changePsgTypeToWord(
						user.getUserPassengerType()));
		
		//注册成功后，放入session
		session.put("user", user);
		
		
		return "success";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRegLoginName() {
		return regLoginName;
	}

	public void setRegLoginName(String regLoginName) {
		this.regLoginName = regLoginName;
	}

	public String getRegPassword() {
		return regPassword;
	}

	public void setRegPassword(String regPassword) {
		this.regPassword = regPassword;
	}

	public String getRegUserName() {
		return regUserName;
	}

	public void setRegUserName(String regUserName) {
		this.regUserName = regUserName;
	}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getRegTelephone() {
		return regTelephone;
	}

	public void setRegTelephone(String regTelephone) {
		this.regTelephone = regTelephone;
	}

	public String getRegUserCertifType() {
		return regUserCertifType;
	}

	public void setRegUserCertifType(String regUserCertifType) {
		this.regUserCertifType = regUserCertifType;
	}

	public String getRegUserCertifNum() {
		return regUserCertifNum;
	}

	public void setRegUserCertifNum(String regUserCertifNum) {
		this.regUserCertifNum = regUserCertifNum;
	}
}
