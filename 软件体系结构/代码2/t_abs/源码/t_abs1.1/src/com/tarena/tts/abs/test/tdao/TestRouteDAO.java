package com.tarena.tts.abs.test.tdao;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.RouteDAO;
import com.tarena.tts.abs.dao.impl.RouteDAOImpl;
import com.tarena.tts.abs.entity.Route;

public class TestRouteDAO {
	
//	@Test
	public void delete() throws Exception{
		RouteDAO dao = new RouteDAOImpl();
		Route r = dao.findById(1);
		dao.delete(r);
	}
	
//	@Test
	public void findAll() throws Exception{
		RouteDAO dao = new RouteDAOImpl();
		List<Route> list = dao.findAll();
		for(Route r : list){
			System.out.println(r.getRouteDistance());
		}
	}
	
//	@Test
	public void save() throws Exception{
		RouteDAO dao = new RouteDAOImpl();
		
		Route r = new Route();
		r.setFromAirportId(2);
		r.setToAirportId(3);
		r.setRouteDistance(1888);
		r.setRouteBasePrice(10);
		
		dao.save(r);
	}
	
//	@Test
	public void update() throws Exception{
		RouteDAO dao = new RouteDAOImpl();
		
		Route r = dao.findById(47);
		r.setFromAirportId(2);
		r.setToAirportId(3);
		r.setRouteDistance(1888);
		r.setRouteBasePrice(10000000);
		
		dao.update(r);
	}
	
	@Test
	public void findRoute() throws Exception{
		RouteDAO dao = new RouteDAOImpl();
		List<Route> list = dao.findRoute(1, 2);
		for(Route r : list){
			System.out.println(r);
		}
	}
}
