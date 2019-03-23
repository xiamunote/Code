package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;

/**
 * 用户操作的DAO组件
 * @author liangjq
 *
 */
public interface UserDAO {
	
	/**
	 * 根据登录名查询用户信息
	 * @param loginName 登录名
	 * @return User 用户信息
	 * @throws SQLException
	 */
	public User findByLoginName(String loginName) throws SQLException;
	
	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @throws SQLException
	 */
	public void update(User user) throws SQLException;
	
	/**
	 * 更新用户密码
	 * @param user
	 * @throws SQLException
	 */
	public void updatePasswd(User user) throws SQLException;
	
	
	/**
	 * 保存用户信息
	 * @param user 用户信息
	 * @throws SQLException
	 */
	public void save(User user) throws SQLException;
	
	/**
	 * 删除用户信息
	 * @param user 用户信息
	 * @throws SQLException
	 */
	public void delete(User user) throws SQLException;
	
	/**
	 * 通过id查找用户
	 * @param id 用户id
	 * @return User 用户信息
	 * @throws SQLException
	 */
	public User findById(int id) throws SQLException;
	
	/**
	 * 查找全部用户信息
	 * @return List<User> 用户信息的List集合
	 * @throws SQLException
	 */
	public List<User> findAll() throws SQLException;
	
	/**
	 * 查找所有常用乘机人
	 * @param user
	 * @return
	 */
	public List<Passenger> findAllPassengers(User user);
	
}
