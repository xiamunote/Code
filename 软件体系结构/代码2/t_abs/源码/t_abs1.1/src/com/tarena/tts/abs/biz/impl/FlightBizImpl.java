package com.tarena.tts.abs.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.dao.FlightDAO;
import com.tarena.tts.abs.dao.impl.FlightDAOImpl;
import com.tarena.tts.abs.vo.Flight01;
import com.tarena.tts.abs.vo.Flight02;

/**
 * @ file_name Flight01BizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 27, 20126:04:55 PM
 * @ description
 * @ reviewed_by 
 */
public class FlightBizImpl implements FlightBiz{
	
	private FlightDAO fdao = new FlightDAOImpl();
	
	//折扣小于等于0.5的航线为推荐航线
	private double discount = 0.5;
	
	@Override
	public List<Flight01> findFlight01(
			String startAirport, String endAirport,
			Date startDate, Date arrivalDate) throws Exception{
		
		//1. 取出符合条件的航班对象List集合
		List<Object[]> list = 
			fdao.findFlightMore(
					startAirport, endAirport, startDate, arrivalDate);
		
		//2. 封装为List<Flight01>
		List<Flight01> list01 = new ArrayList<Flight01>();
		for(Object[] o : list){			
			Flight01 f01 = new Flight01();
			f01.setFid(o[0].toString());
			f01.setFlightNum(o[1].toString());
			f01.setFlDate(o[2].toString());
			f01.setFlDepartureTime(o[3].toString());
			f01.setFlArrivalTime(o[4].toString());
			f01.setPlaneModel(o[5].toString());
			f01.setRouteDistance(Integer.valueOf(o[6].toString()));
			f01.setFseatsRemain(Integer.valueOf(o[7].toString()));
			f01.setBseatsRemain(Integer.valueOf(o[8].toString()));
			f01.setEseatsRemain(Integer.valueOf(o[9].toString()));
			f01.setFullPrice(Double.valueOf(o[10].toString()));
			f01.setCurrentDiscount(Double.valueOf(o[11].toString()));
			f01.setTax1Price(Double.valueOf(o[12].toString()));
			f01.setTax2Price(Double.valueOf(o[13].toString()));
			f01.setFromAirportFullName(o[14].toString());
			f01.setToAirportFullName(o[15].toString());
			
			list01.add(f01);
		}
		
		return list01;
	}

	@Override
	public List<Flight02> findHotFlight() throws Exception {
		
		List<Object[]> list = fdao.findHotFlight(10);
		List<Flight02> list1 = new ArrayList<Flight02>();
		
		for(Object[] o : list){
			Flight02 fl = new Flight02();
			fl.setFid(o[0].toString());
			fl.setFlDate(o[1].toString());
			fl.setFromCity(o[2].toString());
			fl.setToCity(o[3].toString());
			fl.setCurrentDiscount(Double.parseDouble(o[4].toString()));
			fl.setCurrentPrice(Double.parseDouble(o[5].toString()));
			
			list1.add(fl);
		}
		return list1;
	}
	
	@Override
	public List<Flight01> findFlight01() throws Exception {
		
		List<Object[]> list = fdao.findFlight01();
		List<Flight01> list1 = new ArrayList<Flight01>();
		
		for(Object[] o : list){
			Flight01 fl = new Flight01();
			fl.setFid(o[10].toString());		//设置id为flightNum
			fl.setFlightNum(o[0].toString());
			fl.setFlDate(o[1].toString());
			fl.setFlDepartureTime(o[2].toString());
			fl.setFlArrivalTime(o[3].toString());
			fl.setPlaneModel(o[4].toString());
			fl.setRouteDistance(Integer.parseInt(o[5].toString()));
			fl.setFromAirportFullName(o[7].toString());
			fl.setToAirportFullName(o[8].toString());
			fl.setFullPrice(Double.valueOf(o[9].toString()));
			fl.setCurrentDiscount(Double.parseDouble(o[6].toString()));
			fl.setPrice(fl.getCurrentDiscount() * fl.getFullPrice());
			list1.add(fl);
		}
		
		return list1;
	}
	
	@Override
	public Flight01 findFlById(String flightId) throws Exception {
		
		Object[] oArr = fdao.findFlight01ById(flightId);
		Flight01 f = new Flight01();
		f.setFid(oArr[0].toString());
		f.setFlightNum(oArr[1].toString());
		f.setFlDate(oArr[2].toString());
		f.setFlDepartureTime(oArr[3].toString());
		f.setFlArrivalTime(oArr[4].toString());
		f.setPlaneModel(oArr[5].toString());
		f.setRouteDistance(Integer.parseInt(oArr[6].toString()));
		f.setFullPrice(Double.parseDouble(oArr[7].toString()));
		f.setCurrentDiscount(Double.parseDouble(oArr[8].toString()));
		f.setTax1Price(Double.parseDouble(oArr[9].toString()));
		f.setTax2Price(Double.parseDouble(oArr[10].toString()));
		f.setRouteId(Integer.parseInt(oArr[11].toString()));
		
		return f;
	}

	@Override
	public List<Flight01> findFlightDetail(String flightId) {
		List<Object[]> list = fdao.findFlightDetail(flightId);
		List<Flight01> flightList = new ArrayList<Flight01>();
		for(Object[] o : list){			
			Flight01 f01 = new Flight01();
			f01.setFid(o[0].toString());
			f01.setFlightNum(o[1].toString());
			f01.setFlDate(o[2].toString());
			f01.setFlDepartureTime(o[3].toString());
			f01.setFlArrivalTime(o[4].toString());
			f01.setPlaneModel(o[5].toString());
			f01.setRouteDistance(Integer.valueOf(o[6].toString()));
			f01.setFseatsRemain(Integer.valueOf(o[7].toString()));
			f01.setBseatsRemain(Integer.valueOf(o[8].toString()));
			f01.setEseatsRemain(Integer.valueOf(o[9].toString()));
			f01.setFullPrice(Double.valueOf(o[10].toString()));
			f01.setCurrentDiscount(Double.valueOf(o[11].toString()));
			f01.setTax1Price(Double.valueOf(o[12].toString()));
			f01.setTax2Price(Double.valueOf(o[13].toString()));
			f01.setRouteId(Integer.parseInt(o[14].toString()));
			f01.setFromAirportFullName(o[15].toString());
			f01.setToAirportFullName(o[16].toString());
			flightList.add(f01);
		}
		return flightList;
	}
}
