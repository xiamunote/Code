package com.tarena.tts.abs.test.tdao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.UserDAO;
import com.tarena.tts.abs.dao.impl.UserDAOImpl;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.SecurityUtil;

public class TestUserDAO {
	
//	@Test
	public void delete(){
		UserDAO dao = new UserDAOImpl();
		try {
			User u = dao.findById(1);
			System.out.println(u);
			dao.delete(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAll(){
		UserDAO dao = new UserDAOImpl();
		try {
			List<User> list = dao.findAll();
			
			for(User u: list){
				System.out.println(u.getUserId() + u.getUserName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void findByLoginName(){
		UserDAO dao = new UserDAOImpl();
		try {
			User u = dao.findByLoginName("lili");
			System.out.println(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void save(){
		UserDAO dao = new UserDAOImpl();
		User u = new User();
		u.setUserLoginName("tangliang1");
		u.setUserPassword(SecurityUtil.md5("123"));
		u.setUserName("唐亮1");
		u.setUserState("E");
		u.setUserCreationDate(new Date());
		u.setUserLastLoginTime(new Date());
		u.setUserTotalLoginTimes(1);
		u.setUserTotalLoginSeconds(0);
		
		try {
			dao.save(u);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update(){
		UserDAO dao = new UserDAOImpl();
		User u = new User();
		u.setUserId(1);
		u.setUserLoginName("tangliang");
		u.setUserPassword("8d3661369177a7524c5b9128b5bc2c67");
		u.setUserName("唐亮");
		u.setUserState("A");
		u.setUserCreationDate(new Date());
		u.setUserLastLoginTime(new Date());
		u.setUserTotalLoginTimes(1);
		u.setUserTotalLoginSeconds(1212);
		
		try {
			dao.update(u);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tupdatePasswd() throws SQLException{
		UserDAO dao = new UserDAOImpl();
		User u = new User();
		u.setUserId(1);
		u.setUserLoginName("tangliang");
		u.setUserPassword(SecurityUtil.md5("123"));
		u.setUserName("唐亮");
		u.setUserState("A");
		u.setUserCreationDate(new Date());
		u.setUserLastLoginTime(new Date());
		u.setUserTotalLoginTimes(1);
		u.setUserTotalLoginSeconds(1212);
		System.out.println(u);
		
		dao.updatePasswd(u);
	}
}
