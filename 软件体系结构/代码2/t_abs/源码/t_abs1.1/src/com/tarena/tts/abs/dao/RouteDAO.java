package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Route;

/**
 * 航线信息操作的DAO组件
 * @author Administrator
 *
 */
public interface RouteDAO {

	public void update(Route route) throws SQLException;

	public void save(Route route) throws SQLException;
	
	public void delete(Route route) throws SQLException;
	
	public Route findById(int id) throws SQLException;
	
	public List<Route> findAll() throws SQLException;
	
	/**
	 * 通过航线出发机场ID和航线到达机场ID查询航线信息
	 * @ List<Route> findRoute(RouteDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20124:28:00 PM
	 * @ description
	 * @param fromAirportId 航线出发机场
	 * @param toAirportId 航线到达机场
	 * @ reviewed_by
	 */
	public List<Route > findRoute(int fromAirportId,int toAirportId)  throws SQLException;
}
