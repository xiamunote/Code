package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.entity.Flight;

/**
 * 航班操作的DAO组件
 * @author Administrator
 *
 */
public interface FlightDAO {
	
	public void update(Flight flight) throws SQLException;

	public void save(Flight flight) throws SQLException;
	
	public void delete(Flight flight) throws SQLException;
	
	public Flight findById(String sid) throws SQLException;
	
	public List<Flight> findAll() throws SQLException;
	
	/**
	 * 查询航班(组合查询)
	 * @ List<Flight> findFlight(FlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:42:56 PM
	 * @ description
	 * @param startAirport 航班出发机场全称 
	 * @param endAirport 航班到达机场全称
	 * @param startDate 航班出发日期
	 * @param arrivalDate 航班到达日期
	 * @ reviewed_by
	 */
	public List<Flight> findFlight(
			String startAirport,String endAirport,
			Date startDate,Date arrivalDate) throws Exception;
	
	/**
	 * 查询航班(组合查询)，包含更多字段
	 * @ List<Flight> findFlightMore(FlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 27, 20123:42:00 PM
	 * @ description
	 * 	List<Object[]> 返回值是一个Object[]组成的list集合，
	 * 每个Object[]元素都依次对应Flight01的属性 
	 * @ reviewed_by
	 */
	public List<Object[]> findFlightMore(
			String startAirport,String endAirport,
			Date startDate,Date arrivalDate) throws Exception;
	
	/**
	 * 查询折扣最低的前size条记录
	 * @ List<Object[]> findHotFlight(FlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 14, 201211:45:52 AM
	 * @ description 
	 * 	自定义了规则，
	 *  获取折扣最低的前size条记录
	 * @ reviewed_by
	 */
	public List<Object[]> findHotFlight(int size) throws Exception;
	
	/**
	 * 查找出所有航班信息，将来封装为Flight01对象
	 * @ List<Object[]> findFlight(FlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 23, 201211:27:34 AM
	 * @ description 
	 * @ reviewed_by 
	 */
	public List<Object[]> findFlight01() throws SQLException;
	
	/**
	 * 通过flight_num查找航班信息
	 * @ Object[] findFlight01ByNum(FlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 28, 20122:48:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Object[] findFlight01ById(String flightId) throws SQLException;
	
	
	public List<Object[]> findFlightDetail(String flightId);
	
}
