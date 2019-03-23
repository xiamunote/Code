package com.tarena.tts.abs.test.tdao;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.PassengerDAO;
import com.tarena.tts.abs.dao.impl.PassengerDAOImpl;
import com.tarena.tts.abs.entity.Passenger;

public class TestPassengerDAO {
	
//	@Test
	public void delete() throws Exception{
		PassengerDAO dao = new PassengerDAOImpl();
		Passenger p = dao.findById(1);
		dao.delete(p);
	}
	
//	@Test
	public void findAll()throws Exception{
		PassengerDAO dao = new PassengerDAOImpl();
		List<Passenger> list =  dao.findAll();
		for(Passenger p: list){
			System.out.println(p.getPsgName());
		}
	}
	
//	@Test
	public void save() throws Exception{
		Passenger p = new Passenger();
		p.setPsgName("李大嘴");
		p.setPsgCertifType("身份证");
		p.setPsgCertifNum("430324198504206087");
		p.setPsgType("B");
		p.setRefUserId(1);
		
		PassengerDAO dao = new PassengerDAOImpl();
		dao.save(p);
	}
	
//	@Test
	public void update() throws Exception{
		PassengerDAO dao = new PassengerDAOImpl();
		Passenger p = dao.findById(5);
		p.setPsgType("C");
		
		dao.update(p);
	}
	
//	@Test
	public void deleteById() throws Exception{
		PassengerDAO dao = new PassengerDAOImpl();
		dao.deleteById(1);
	}
	
	@Test
	public void findByUserId() throws Exception{
		PassengerDAO dao = new PassengerDAOImpl();
		List<Passenger> list = dao.findByUserId(2,1,3);
		
		for(Passenger p : list){
			System.out.println(p);
		}
	}
}
