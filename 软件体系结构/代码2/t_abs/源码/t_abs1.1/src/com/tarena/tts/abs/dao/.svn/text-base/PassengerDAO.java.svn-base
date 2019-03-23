package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.Passenger;

/**
 * 乘客信息操作的DAO组件
 * @author Administrator
 *
 */
public interface PassengerDAO {

	public void update(Passenger passenger) throws SQLException;

	public void save(Passenger passenger) throws SQLException;
	

	public void delete(Passenger passenger) throws SQLException;
	
	public void deleteById(int id) throws SQLException;
	
	public Passenger findById(int id) throws SQLException;
	
	/**
	 * 通过登录用户ID(userId)查找乘客信息
	 * @ List<Passenger> findByUserId(PassengerDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:07:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Passenger> findByUserId(int userId,int begin,int size) throws SQLException;
	
	public int countByUserId(int userId) throws SQLException;
	
	/**
	 * 查询出所有的Passenger信息
	 * @ List<Passenger> findAll(PassengerDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Jun 1, 20123:23:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Passenger> findAll() throws SQLException;
	
	/**
	 * 通过userId查找出所有的关联的Passenger
	 * @ List<Passenger> findByUserId(PassengerDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Jun 1, 20123:24:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Passenger> findByUserId(Integer userId);

	public Passenger findPassengerByName(Passenger p);
}
