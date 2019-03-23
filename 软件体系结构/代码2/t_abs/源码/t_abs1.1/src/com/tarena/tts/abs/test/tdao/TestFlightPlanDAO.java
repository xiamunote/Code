package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.FlightPlanDAO;
import com.tarena.tts.abs.dao.impl.FlightPlanDAOImpl;
import com.tarena.tts.abs.entity.FlightPlan;

public class TestFlightPlanDAO {
	
//	@Test
	public void delete() throws Exception{
		FlightPlanDAO dao = new FlightPlanDAOImpl();
		FlightPlan fp = dao.findById(3);
		System.out.println(fp.getFlightNum());
		dao.delete(fp);
	}
	
//	@Test
	public void findAll() throws Exception{
		FlightPlanDAO dao = new FlightPlanDAOImpl();
		List<FlightPlan> list = dao.findAll();
		for(FlightPlan fp : list){
			System.out.println(fp.getFlightNum());
		}
	}
	
//	@Test
	public void save() throws Exception{
		FlightPlanDAO dao = new FlightPlanDAOImpl();
		FlightPlan fp = new FlightPlan();
		fp.setFlightNum("010");
		fp.setFpStartDate(new Date());
		fp.setFpEndDate(new Date());
		fp.setRouteId(2);
		fp.setFpDepartureTime("fine");
		fp.setFpArrivalTime("ok");
		fp.setFpScheduler(1);
		fp.setFpBasePrice(12.1);
		
		dao.save(fp);
	}
	
	@Test
	public void update() throws Exception{
		FlightPlanDAO dao = new FlightPlanDAOImpl();
		FlightPlan fp = dao.findById(2);
		fp.setFlightNum("0100000");
		
		dao.update(fp);
	}
}
