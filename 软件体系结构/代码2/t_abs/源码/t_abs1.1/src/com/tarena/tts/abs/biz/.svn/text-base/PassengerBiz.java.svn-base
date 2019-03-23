package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Passenger;

public interface PassengerBiz {
	
	/**
	 * 通过登录用户User查找到Passenger
	 * @ List<Passenger> getPassengersByLoginUser(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 25, 20124:18:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Passenger> getPassengersByLoginUser(
			int userId,int page,int size) throws SQLException;
	
	/**
	 * 更新Passenger信息
	 * @ void saveOrUpdatePassenger(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 25, 20124:19:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void saveOrUpdatePassenger(
			Passenger passenger) throws SQLException;
	
	/**
	 * 删除
	 * @ void deletePassenger(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 25, 20124:19:36 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void deletePassenger(int id) throws SQLException;
	
	/**
	 * 通过id获得Passenger信息
	 * @ Passenger getPassengerById(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 25, 20124:19:41 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Passenger getPassengerById(int id) throws SQLException;
	
	/**
	 * 计算总页数
	 * @ int countTotalPage(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 25, 20124:19:52 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public int countTotalPage(
			int userId,int pageSize) throws SQLException;
	
	/**
	 * 通过登录用户Id获得关联的Passenger信息
	 * @ List<Passenger> getPassengersByLoginUser(PassengerBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Jun 1, 20123:22:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Passenger> getPassengersByLoginUser(Integer userId);

	public Passenger findPassengerByName(Passenger p);
}
