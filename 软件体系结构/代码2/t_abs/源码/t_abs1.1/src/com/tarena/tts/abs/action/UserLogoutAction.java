package com.tarena.tts.abs.action;

/**
 * @ file_name UserLogoutAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 25, 20123:00:56 PM
 * @ description
 * @ reviewed_by 
 */
public class UserLogoutAction extends BaseAction{
		
	@Override
	public String execute() throws Exception {
		
		session.remove("user");
		
		return "success";
	}
}
