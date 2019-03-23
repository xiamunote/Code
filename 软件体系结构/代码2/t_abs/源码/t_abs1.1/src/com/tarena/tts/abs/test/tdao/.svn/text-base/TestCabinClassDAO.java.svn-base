package com.tarena.tts.abs.test.tdao;

import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.CabinClassDAO;
import com.tarena.tts.abs.dao.impl.CabinClassDAOImpl;
import com.tarena.tts.abs.entity.CabinClass;

public class TestCabinClassDAO {

//	@Test
	public void delete() throws Exception{
		CabinClassDAO dao = new CabinClassDAOImpl();
		CabinClass cc = dao.findById(1);
		System.out.println(cc.getCabinClassName());
		dao.delete(cc);
		
	}
	
//	@Test
	public void findAll() throws Exception{
		CabinClassDAO dao = new CabinClassDAOImpl();
		List<CabinClass> list = dao.findAll();
		for(CabinClass c : list){
			System.out.println(c.getCabinClassName());
		}
	}
	
//	@Test
	public void save() throws Exception{
		CabinClassDAO dao = new CabinClassDAOImpl();
		
		CabinClass cc = new CabinClass();
		cc.setCabinClassName("站票");
		cc.setCabinClassChar("F");
		cc.setRefundCharge(1.05);
		cc.setLimitCondition("TGZ");
		cc.setCabinDiscount(1.5);
		cc.setPlaneCabinType("F");
		cc.setMileageFactor(1.5);
		
		dao.save(cc);
	}
	
	@Test
	public void update() throws Exception{
		CabinClassDAO dao = new CabinClassDAOImpl();
		
		CabinClass cc = dao.findById(28);
		cc.setCabinClassName("站着累的慌");
		dao.update(cc);
	}
}
