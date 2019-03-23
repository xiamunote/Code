package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.biz.CityBiz;
import com.tarena.tts.abs.dao.CityDAO;
import com.tarena.tts.abs.dao.impl.CityDAOImpl;
import com.tarena.tts.abs.entity.City;

public class CityBizImpl implements CityBiz {
	
	CityDAO cityDAO = new CityDAOImpl();
	
	@Override
	public List<City> getCityList(int page , int rowsPerPage) 
	throws SQLException{
		
		
		List<City> cityList = cityDAO.findByPage(page, rowsPerPage);
		return cityList;
	}
	
	@Override
	public List<City> getCityList() throws SQLException{
		return cityDAO.findAll();
	}

}
