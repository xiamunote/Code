package com.tarena.tts.abs.test.tdao;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.ProvinceDAO;
import com.tarena.tts.abs.dao.impl.ProvinceDAOImpl;
import com.tarena.tts.abs.entity.Province;

public class TestProvinceDAO {
	
//	@Test
	public void delete() throws Exception{
		ProvinceDAO dao = new ProvinceDAOImpl();
		Province p = dao.findById(2);
		System.out.println(p.getProvinceName());
		dao.delete(p);
	}
	
//	@Test
	public void findAll() throws Exception{
		ProvinceDAO dao = new ProvinceDAOImpl();
		List<Province> list = dao.findAll();
		for(Province p : list){
			System.out.println(p.getProvinceName());
		}
	}
	
//	@Test
	public void save() throws Exception{
		ProvinceDAO dao = new ProvinceDAOImpl();
		
		Province p = new Province();
		p.setProvinceName("月本");
		p.setProvinceSimpleName("忍");
		p.setProvinceSpellName("yueben");
		
		dao.save(p);
	}
	
	@Test
	public void update() throws Exception{
		ProvinceDAO dao = new ProvinceDAOImpl();
		
		Province p = dao.findById(35);
		p.setProvinceName("忍者");
		p.setProvinceSimpleName("神龟");
		p.setProvinceSpellName("rzsg");
		
		dao.update(p);
	}
}
