package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarena.tts.abs.biz.UserBiz;
import com.tarena.tts.abs.dao.UserDAO;
import com.tarena.tts.abs.dao.impl.UserDAOImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.ChangeTypeUtil;
import com.tarena.tts.abs.util.SecurityUtil;

/**
 * @ file_name UerBizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20124:09:05 PM
 * @ description
 * @ reviewed_by 
 */
public class UserBizImpl implements UserBiz{
	
	private UserDAO userDao = new UserDAOImpl();

	@Override
	public User login(String loginName , String password) 
	throws SQLException {
		
		User user = userDao.findByLoginName(loginName);
		
		if(user != null){
			if(user.getUserPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	@Override
	public User register01(String loginName, String password, 
			String userName, String email,String telephone) 
			throws SQLException {
		
		User u = new User();
		u.setUserLoginName(loginName);
		u.setUserPassword(SecurityUtil.md5(password));
		u.setUserName(userName);
		u.setUserState("D"); 	//默认值
		
		u.setUserEmail(email);
		u.setUserTelephone(telephone);
		u.setUserCreationDate(new Date());	//默认当前系统时间
		u.setUserLastLoginTime(new Date()); //默认当前系统时间
		u.setUserTotalLoginTimes(0); 		//默认为0
		u.setUserTotalLoginSeconds(0); 		//默认为0
		u.setUserPassengerType("A");		//默认为成年人
		u.setUserCertifType("ID");
		userDao.save(u);
		
		return u;
	}

	@Override
	public boolean checkUser(String loginName) throws SQLException {
		
		User user = userDao.findByLoginName(loginName);
		
		//如果查询到，表明数据库中存在同名用户
		if(user != null){
			return false;
		}
		
		return true;
	}
	
	@Override
	public User register02(String loginName, String password, String userName,
			String email, String telephone, String userCertifType,
			String userCertifNum) throws SQLException {
		
		User u = new User();
		u.setUserLoginName(loginName);					//1 用户名
		u.setUserPassword(SecurityUtil.md5(password));	//2 密码
		u.setUserName(userName);	//3 真实姓名
		u.setUserState("D"); 				//默认值
		
		u.setUserEmail(email);		//4 常用邮箱
		u.setUserTelephone(telephone);	//5 移动电话
		u.setUserCertifType(userCertifType);	//6 证件类型
		u.setUserCertifNum(userCertifNum);	//7 证件号码
		
		u.setUserCreationDate(new Date());	//默认当前系统时间
		u.setUserLastLoginTime(new Date()); //默认当前系统时间
		u.setUserTotalLoginTimes(0); 		//默认为0
		u.setUserTotalLoginSeconds(0); 		//默认为0
		u.setUserPassengerType("A"); 		//默认为成年人
		
		userDao.save(u);
	
		return u;
	}

	@Override
	public User getUserInfo(int userId) throws SQLException {
		
		User user = userDao.findById(userId);
		
		/* 根据数据库中取出字段user_passenger_type重新赋值
		 * A 成人
		 * C 儿童
		 * I 婴儿
		 */
		user.setUserPassengerType(
				ChangeTypeUtil.changePsgTypeToWord(
						user.getUserPassengerType()));
		
		/* 根据数据库中取出字段user_certify_type重新赋值
		 * NI 身份证
		 * PP 护照
		 *    其它
		 */
		user.setUserCertifType(
				ChangeTypeUtil.changeUserCertifTypeToWord(
						user.getUserCertifType()));
		
		return user;
	}

	
	@Override
	public boolean checkPassword(int userId , String password) throws SQLException {
		
		User u = userDao.findById(userId);
		
		if(u.getUserPassword().equals(SecurityUtil.md5(password))){
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean changePassword(User u,String oldPassword, String newPassword)
			throws SQLException {
		User user = userDao.findById(u.getUserId());
		String md5Password = SecurityUtil.md5(oldPassword);
		if(user != null && md5Password.equals(user.getUserPassword())){
			user.setUserPassword(SecurityUtil.md5(newPassword));
			userDao.updatePasswd(user);
			return true;
		}
		return false;
	}
	
	@Override
	public void updateUser(User u) throws SQLException {
		userDao.update(u);
	}

	@Override
	public List<Passenger> getPassengerList(User user) throws SQLException {
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers = userDao.findAllPassengers(user);
		return passengers;
	}
}




