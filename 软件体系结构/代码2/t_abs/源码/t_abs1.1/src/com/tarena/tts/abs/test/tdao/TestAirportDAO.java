package com.tarena.tts.abs.test.tdao;

import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.AirportDAO;
import com.tarena.tts.abs.dao.impl.AirportDAOImpl;
import com.tarena.tts.abs.entity.Airport;

public class TestAirportDAO {
	
//	@Test
	public void delete() throws Exception{
		AirportDAO dao = new AirportDAOImpl();
		Airport ap = dao.findById(1);
		
		dao.delete(ap);
	}
	
	@Test
	public void findAll() throws Exception{
		AirportDAO dao = new AirportDAOImpl();
		List<Airport> list = dao.findAll();
		System.out.println((Airport)list.get(0));
//		for(Airport ap : list){
//			System.out.println(ap.getAirportFullName());
//		}
	}
	
//	@Test
	public void save() throws Exception{
		AirportDAO dao = new AirportDAOImpl();
		
		Airport ap = new Airport();
		ap.setAirportName("虹桥2");
		ap.setProvinceId(2);
		ap.setCityId(2);
		ap.setAirportFullName("上海-虹桥机场2");
		ap.setAirportCode("LSB");
		ap.setDepartureRoutesNum(1);
		ap.setArrivalRoutesNum(1);
		ap.setDepartureFlightNumPerWeek(1);
		ap.setArrivalFlightNumPerWeek(1);
		
		dao.save(ap);
	}
	
//	@Test
	public void update() throws Exception{
		AirportDAO dao = new AirportDAOImpl();
		Airport ap = dao.findById(119);
		ap.setAirportName("虹桥2号机场");
		dao.update(ap);
	}
}
