package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name UpdateUserAction.java @ author baiyx (baiyx@tarena.com.cn) @ date
 * May 22, 20124:48:07 PM @ description @ reviewed_by
 */
public class UpdateUserAction extends BaseAction {

	// input
	public User user; // 从页面拿到的对象

	@Override
	public String execute() throws Exception {

		UserBiz biz = new UserBizImpl();
		
		// 将页面拿到的User对象的数据更新到数据库中
		biz.updateUser(user);
		
		//更新session中的user对象
		session.put("user", user);

		return "success";
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
