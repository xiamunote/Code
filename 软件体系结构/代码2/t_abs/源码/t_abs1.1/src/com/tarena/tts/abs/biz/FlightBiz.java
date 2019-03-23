package com.tarena.tts.abs.biz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.dao.FlightDAO;
import com.tarena.tts.abs.dao.PlaneDAO;
import com.tarena.tts.abs.dao.RouteDAO;
import com.tarena.tts.abs.dao.impl.FlightDAOImpl;
import com.tarena.tts.abs.dao.impl.PlaneDAOImpl;
import com.tarena.tts.abs.dao.impl.RouteDAOImpl;
import com.tarena.tts.abs.entity.Flight;
import com.tarena.tts.abs.entity.Plane;
import com.tarena.tts.abs.entity.Route;
import com.tarena.tts.abs.vo.Flight01;
import com.tarena.tts.abs.vo.Flight02;
import com.tarena.tts.abs.util.NumberUtil;

/**
 * @ file_name FindFlightBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 26, 20125:23:37 PM
 * @ description
 * @ reviewed_by 
 */
public interface FlightBiz {
	
	/**
	 * 查询航班
	 * @ List<Flight01> findFlight01(Flight01Biz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 3, 201211:04:01 AM
	 * @ description
	 *  当用户点击"查询航班"按钮，
	 *  根据"起飞机场"、"降落机场"、"起飞时间"、"到达时间" 查询出航班
	 * @ reviewed_by
	 */
	public List<Flight01> findFlight01(
			String startAirport, String endAirport,
			Date startDate, Date arrivalDate) throws Exception;
	
	/**
	 * 查询航班信息，用于index.jsp页面"推荐航线"模块
	 * @ List<Flight02> findHotFlight(Flight01Biz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 14, 20121:30:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Flight02> findHotFlight() throws Exception;
	
	/**
	 * 查询出所有航班信息，封装为Flight01
	 * @ List<Flight01> findFlight01(FlightBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 23, 201211:36:47 AM
	 * @ description 
	 * @ reviewed_by 
	 */
	public List<Flight01> findFlight01() throws Exception; 
	
	/**
	 * 通过flightId查找航班信息
	 * @ Flight01 findFlById(FlightBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 29, 201211:25:31 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public Flight01 findFlById(String flightId) throws Exception;

	public List<Flight01> findFlightDetail(String flightId);
}
