package com.tarena.tts.abs.test.tbiz;

import java.sql.SQLException;

import org.junit.Test;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.biz.impl.UserBizImpl;
import com.tarena.tts.abs.dao.UserDAO;
import com.tarena.tts.abs.dao.impl.UserDAOImpl;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.SecurityUtil;

/**
 * @ file_name TestUserBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20124:11:58 PM
 * @ description
 * @ reviewed_by 
 */
public class TestUserBiz {
	
	@Test
	public void tlogin() throws SQLException {
		UserBiz biz = new UserBizImpl();
		System.out.println(biz.login("tangliang" , SecurityUtil.md5("123")));
	}
	
	@Test
	public void tregister01() throws SQLException {
		UserBiz biz = new UserBizImpl();
		biz.register01("xhh", SecurityUtil.md5("123"), "ba@ta.com", "小黑黑", "123455");
	}
	
	@Test
	public void tregister02() throws SQLException {
		UserBiz biz = new UserBizImpl();
		biz.register02("狗狗", 
				SecurityUtil.md5("123"), 
				"userName", 
				"email", 
				"telephone", 
				"身份证", 
				"15292119881281281");
	}
	
	@Test
	public void checkPassword() throws SQLException {
		UserBiz biz = new UserBizImpl();
		boolean b = biz.checkPassword(1, "123");
		System.out.println(b);
	}
	
	@Test
	public void updateUser() throws Exception{
		UserBiz biz = new UserBizImpl();
		UserDAO dao = new UserDAOImpl();
		
		User u = dao.findById(1);
		
		u.setUserName("唐亮11");
		
		biz.updateUser(u);
	}
	
	@Test
	public void tcheckUser() throws SQLException{
		UserBiz biz = new UserBizImpl();
		System.out.println(biz.checkUser("tangliang"));
	}
	
	@Test
	public void tchangePasswd() throws SQLException{
		
		UserBiz biz = new UserBizImpl();
		
		User u = biz.getUserInfo(1);
		
		biz.changePassword(u, "111", "123");
		
	}
}











