package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name UserBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20123:56:38 PM
 * @ description
 * @ reviewed_by 
 */
public interface UserBiz {
	
	/**
	 * 登录
	 * @ boolean login(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 14, 20124:05:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public User login(String loginName , String password) throws SQLException;
	
	/**
	 * 快速注册
	 * @ void register(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 15, 20124:06:18 PM
	 * @ description
	 * 用户只需要提供登录名、密码、Email、真实姓名、电话即可实现快速注册
	 * @ reviewed_by
	 */
	public User register01(String loginName , 
						String password ,
						String email , 
						String userName ,
						String telephone) throws SQLException;
	
	/**
	 * 完整注册
	 * @ void register02(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 18, 201211:04:19 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public User register02(String loginName , 
			String password , 
			String userName , 
			String email , 
			String telephone , 
			String userCertifType , 
			String userCertifNum) throws SQLException;
	
	/**
	 * 检查是否存在此用户
	 * @ boolean checkUser(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 16, 20125:12:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public boolean checkUser(String loginName) throws SQLException;
	
	/**
	 * 通过userId获得用户信息
	 * @ User getUserInfo(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 22, 20124:57:33 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public User getUserInfo(int userId)throws SQLException;
	
	/**
	 * 修改密码
	 * @ boolean changePassword(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 22, 20124:58:07 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public boolean changePassword(
			User u,String oldPassword,String newPassword) throws SQLException;
	
	/**
	 * 通过用户id，检查密码是否正确
	 * @ boolean checkPassword(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 22, 20124:58:15 PM
	 * @ description 
	 * 	userId 用户id
	 *  password 页面输入的密码
	 * @ reviewed_by
	 */
	public boolean checkPassword(int userId , String password)throws SQLException;
	
	/**
	 * 更新用户信息
	 * @ void updateUser(UserBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 22, 20125:01:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void updateUser(User u) throws SQLException;
	
	/**
	 * 查找登录用户常用乘机人
	 * @param user
	 * @return
	 */
	public List<Passenger> getPassengerList(User user) throws SQLException;
	
}



