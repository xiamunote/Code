package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.MileageDetailDAO;
import com.tarena.tts.abs.dao.impl.MileageDetailDAOImpl;
import com.tarena.tts.abs.entity.MileageDetail;

public class TestMileageDetailDAO {
	
//	@Test
	public void delete() throws Exception{
		MileageDetailDAO dao = new MileageDetailDAOImpl();
		MileageDetail md = dao.findById(1);
		System.out.println(md.getMileageDescribe());
		dao.delete(md);
	}
	
//	@Test
	public void findAll() throws Exception{
		MileageDetailDAO dao = new MileageDetailDAOImpl();
		List<MileageDetail> list = dao.findAll();
		for(MileageDetail md : list){
			System.out.println(md.getMileageDescribe());
		}
	}
	
//	@Test
	public void save() throws Exception{
		MileageDetailDAO dao = new MileageDetailDAOImpl();
		MileageDetail md = new MileageDetail();
		md.setMileageId(1);
		md.setMembId(11);
		md.setMileageType("D");
		md.setMileageDescribe("世界和平");
		md.setStageDate(new Date());
		md.setAccountMileage(1111);
		
		dao.save(md);
	}
	
//	@Test
	public void update() throws Exception{
		MileageDetailDAO dao = new MileageDetailDAOImpl();
		MileageDetail md = dao.findById(1);
		md.setMileageDescribe("uptown girl");
		
		dao.update(md);
	}
	
	@Test
	public void findByMemb_id() throws Exception{
		MileageDetailDAO dao = new MileageDetailDAOImpl();
		List<MileageDetail> list = dao.findByMemb_id(1);
		for(MileageDetail m : list){
			System.out.println(m);
		}
	}
}
