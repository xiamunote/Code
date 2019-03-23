package com.tarena.tts.abs.test.tdao;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.CityDAO;
import com.tarena.tts.abs.dao.impl.CityDAOImpl;
import com.tarena.tts.abs.entity.City;

public class TestCityDAO {

//	@Test
	public void delete() throws Exception{
		CityDAO dao = new CityDAOImpl();
		
		City c = dao.findById(1);
		System.out.println(c.getCityName());
		dao.delete(c);
	}
	
//	@Test
	public void findAll() throws Exception{
		CityDAO dao = new CityDAOImpl();
		List<City> list = dao.findAll();
		for(City c : list){
			System.out.println(c.getCityName());
		}
	}
	
//	@Test
	public void save() throws Exception{
		CityDAO dao = new CityDAOImpl();
		
		City c = new City();
		c.setCityName("你的家");
		c.setCitySpellName("HOME");
		c.setProvinceId(1);
		
		dao.save(c);
	}
	
	@Test
	public void update() throws Exception{
		CityDAO dao = new CityDAOImpl();
		City c = dao.findById(118);
		c.setCityName("YOUR_HOME:)");
		
		dao.update(c);
	}
	
	/**
	 * 
	 * @ void findByPage(TestCityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 2, 20125:14:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findByPage() throws Exception{
		CityDAO dao = new CityDAOImpl();
		List<City> list = dao.findByPage(2, 5);
		for(City c : list){
			System.out.println(c.getCityName());
		}
	}
}
