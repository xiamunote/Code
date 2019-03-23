package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.FlightDAO;
import com.tarena.tts.abs.dao.impl.FlightDAOImpl;
import com.tarena.tts.abs.entity.Flight;
import com.tarena.tts.abs.vo.Flight01;
import com.tarena.tts.abs.util.DateUtil;

public class TestFlightDAO {
	
//	@Test
	public void delete() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		Flight f = dao.findById("N201010251201");
		System.out.println(f.getFlightId());
		dao.delete(f);
		
	}
	
	@Test
	public void findAll() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		List<Flight> list =  dao.findAll();
		for(Flight f : list){
			System.out.println(f);
		}
	}
	
//	@Test
	public void save() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		Flight f = new Flight();
		f.setFlightId("A201010251201");
		f.setFlightNum("TL1212");
		f.setFlDepartureDate(new Date());
		f.setFlArrivalDate(new Date());
		f.setRouteId(3);
		f.setPlaneId(3);
		f.setFseatsRemain(4);
		f.setBseatsRemain(4);
		f.setEseatsRemain(4);
		f.setCurrentClasses("U.F.O");
		f.setFullPrice(1200);
		f.setCurrentDiscount(0.5);
		f.setCurrentPrice(f.getFullPrice()*f.getCurrentDiscount());
		f.setTax1Price(1111);
		f.setTax2Price(2222);
		f.setCurrentOrder(1);
		
		dao.save(f);
	}
	
//	@Test
	public void update() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		Flight f = dao.findById("A201010251201");
		f.setCurrentClasses("F.B.I");
		
		dao.update(f);
	}
	
	/**
	 * 查询从“北京-首都机场”起飞的航班编号
	 * @ void findFlight06(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:39:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight01() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				"北京-首都机场",
				null, 
				null,
				null); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询从“北京-首都机场”起飞，降落到“重庆-江北机场”的航班编号
	 * @ void findFlight02(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:47:13 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight02() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				"上海",
				"北京", 
				null,
				null); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询从“北京-首都机场”起飞，降落到“重庆-江北机场”，
	 * 起飞时间大于等于“2010-10-27 10:25:00”的航班编号
	 * @ void findFlight03(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:48:10 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight03() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				"北京-首都机场",
				"重庆-江北机场", 
				DateUtil.parse("2010-10-27 10:25:00"),
				null); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询从“北京-首都机场”起飞，降落到“重庆-江北机场”，
	 * 起飞时间大于等于“2010-10-27 10:25:00”，
	 * 降落时间小于等于“2010-10-27 12:15:00”的航班编号
	 * @ void findFlight04(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:53:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight04() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				"北京-首都机场",
				"重庆-江北机场", 
				DateUtil.parse("2010-10-27 10:25:00"),
				DateUtil.parse("2010-10-27 12:15:00")); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询降落到“北京-首都机场”的航班编号
	 * @ void findFlight05(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:54:41 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight05() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				"北京-首都机场", 
				null,
				null); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询降落到“北京-首都机场”，
	 * 降落时间小于等于“2010-10-27 12:15:00”的航班编号
	 * @ void findFlight06(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20123:55:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight06() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				"北京-首都机场", 
				null,
				DateUtil.parse("2010-10-27 12:15:00")); 
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询降落到“北京-首都机场”，
	 * 起飞时间大于等于“2010-10-25 13:00:00” ， 
	 * 降落时间小于等于“2010-10-27 12:15:00”的航班编号
	 * @ void findFlight07(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20124:00:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight07() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				"北京-首都机场", 
				DateUtil.parse("2010-10-25 13:00:00"),
				DateUtil.parse("2010-10-27 12:15:00"));
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询起飞时间大于等于“2010-10-29 10:25:00”的航班信息
	 * @ void findFlight08(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20124:36:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight08() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				null, 
				DateUtil.parse("2010-10-29 10:25:00"),
				null);
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询起飞时间大于等于“2010-10-29 10:25:00”，
	 * 降落时间小于等于“2010-10-29 12:15:00”的航班信息
	 * @ void findFlight09(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20124:53:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight09() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				null, 
				DateUtil.parse("2010-10-29 10:25:00"),
				DateUtil.parse("2010-10-29 12:15:00"));
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询降落时间小于等于“2010-10-25 15:05:00”的航班编号
	 * @ void findFlight10(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20124:54:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight10() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				null, 
				null,
				DateUtil.parse("2010-10-25 15:05:00"));
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询出全部航班编号
	 * @ void findFlight11(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20126:22:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight11() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				null,
				null, 
				null,
				null);
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 查询从“上海“起飞，降落到"北京"的航班编号
	 * @ void findFlight12(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 23, 20126:23:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlight12() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Flight> list = dao.findFlight(
				"上海",
				"北京", 
				null,
				null);
		for(Flight f : list){
			System.out.println(f.getFlightId());
		}
	}
	
	/**
	 * 测试查询航班信息（关联了其他表的字段，封装为Flight01对象）
	 * private String fid;				//01编号
	 * private String flightNum;		//02航班号
	 * private String flDate;			//03航班日期(yyyy-MM-dd)
	 * private String flDepartureTime;	//04起飞时间
	 * private String flArrivalTime;	//05到达时间
	 * private String planeModel;		//06机型
	 * private int routeDistance;		//07飞机里程
	 * private double currentPrice;		//08当前最低价格
	 * @ void findFlightMore01(TestFlightDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 2, 20123:39:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findFlightMore01() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Object[]> list = dao.findFlightMore(
				"北京",
				null , null ,null);
		
		for(Object[] o : list){
//			System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]
//			       +" "+o[4]+" "+o[5]+" "+o[6]+" "+o[7]);
			
			Flight01 f = new Flight01();
			f.setFid(o[0].toString());
			f.setFlightNum(o[1].toString());
			f.setFlDate(o[2].toString());
			f.setFlDepartureTime(o[3].toString());
			f.setFlArrivalTime(o[4].toString());
			f.setPlaneModel(o[5].toString());
			f.setRouteDistance(Integer.parseInt(o[6].toString()));
			f.setFullPrice(Double.parseDouble(o[7].toString()));
			
			System.out.println(f);
			
		}
	}
	
	@Test
	public void findHotFlight() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Object[]> list = dao.findHotFlight(5);
		
		
		for(Object[] o : list){
			System.out.println(o[0] + " " 
					+ o[1]+ " " 
					+ o[2]+ " " 
					+ o[3]+ " " 
					+ o[4]+ " "
					+ o[5]);
		}
	}
	
	@Test
	public void findFliht13() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		
		List<Object[]> list = dao.findFlight01();
		
		for(Object[] o : list){
			System.out.println(o[0] + " " 
					+ o[1]+ " " 
					+ o[2]+ " " 
					+ o[3]+ " " 
					+ o[4]+ " "
					+ o[5]+ " "
					+ o[6]);
		}
	}
	
	@Test
	public void findFlById() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		Object[] o = dao.findFlight01ById("N201010251201");
		System.out.println(o[10] + " ####");
		
	}
	
	@Test
	public void findFlight01_() throws Exception{
		FlightDAO dao = new FlightDAOImpl();
		List<Object[]> list = dao.findFlight01();
		System.out.println();
	}
}
