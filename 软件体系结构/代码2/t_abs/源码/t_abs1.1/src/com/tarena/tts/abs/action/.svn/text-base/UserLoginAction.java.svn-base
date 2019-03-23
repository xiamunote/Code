package com.tarena.tts.abs.action;

import java.util.List;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.SecurityUtil;

/**
 * @ file_name UserAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20125:18:05 PM
 * @ description
 * @ reviewed_by 
 */
public class UserLoginAction extends BaseAction{
	
	//input
	private String userName;
	private String password;
	private String userNumber;	//用户输入的验证码
	
	
	@Override
	public String execute() throws Exception {
		
		//校验验证码
		//保存在session中的验证码(由服务器生成)
		String number = session.get("number").toString();
		
		//如果验证码正确，则验证userName && password
		if(number.equalsIgnoreCase(userNumber)){
			//登录业务
			UserBiz biz = new UserBizImpl();
			User user = 
				biz.login(userName , SecurityUtil.md5(password));
				
			//如果从数据库中找到该用户，则返回登录成功页面
			if(user != null){
				//当用户登录成功后，将用户信息放入session中
				this.session.put("user", user);
				return "success";
			}
		}
		
		return "failure";
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
}
