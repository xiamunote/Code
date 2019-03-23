package com.tarena.tts.abs.test.tdao;

import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.PlaneDAO;
import com.tarena.tts.abs.dao.impl.PlaneDAOImpl;
import com.tarena.tts.abs.entity.Plane;

public class TestPlaneDAO {
	
//	@Test
	public void delete() throws Exception{
		PlaneDAO dao = new PlaneDAOImpl();
		Plane p = dao.findById(1);
		dao.delete(p);
		
	}
	
//	@Test
	public void findAll() throws Exception{
		PlaneDAO dao = new PlaneDAOImpl();
		List<Plane> list = dao.findAll();
		for(Plane p : list){
			System.out.println(p.getPlaneNum());
		}
	}
	
//	@Test
	public void save() throws Exception{
		Plane p = new Plane();
		p.setPlaneNum("B-1251");
		p.setPlaneModel("B737-800");
		p.setPlaneManufacturer("中国制造");
		p.setFcabinSeats(8);
		p.setCcabinSeats(0);
		p.setYcabinSeats(159);
		p.setSeatsImgUri("data/plane_pic/B737_800.gif");
		
		PlaneDAO dao = new PlaneDAOImpl();
		dao.save(p);
	}
	
//	@Test
	public void update() throws Exception{
		PlaneDAO dao = new PlaneDAOImpl();
		Plane p = dao.findById(105);
		p.setPlaneManufacturer("made in China");
		dao.update(p);
	}
	
	@Test
	public void findByPlaneModel(){
		PlaneDAO dao = new PlaneDAOImpl();
		List<Plane> list = dao.findByPlaneModel("B777-200");
		for(Plane p : list){
			System.out.println(p);
		}
	}
}
