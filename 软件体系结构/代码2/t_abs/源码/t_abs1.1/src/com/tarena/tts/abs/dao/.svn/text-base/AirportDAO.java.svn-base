package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.Airport;

/**
 * 机场操作的DAO组件
 * @author baiyx
 *
 */
public interface AirportDAO {
	
	/**
	 * 更新机场信息
	 * @param airport 机场对象
	 * @throws SQLException
	 */
	public void update(Airport airport) throws SQLException;
	
	/**
	 * 保存机场信息
	 * @param airport 机场对象
	 * @throws SQLException
	 */
	public void save(Airport airport) throws SQLException;
	
	/**
	 * 删除机场信息
	 * @param airport 机场对象
	 * @throws SQLException
	 */
	public void delete(Airport airport) throws SQLException;
	
	/**
	 * 查找指定id的机场信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Airport findById(int id) throws SQLException;
	
	/**
	 * 查找全部机场信息
	 * @return List<Airport> 机场信息对象的List集合
	 * @throws SQLException
	 */
	public List<Airport> findAll() throws SQLException;
}
