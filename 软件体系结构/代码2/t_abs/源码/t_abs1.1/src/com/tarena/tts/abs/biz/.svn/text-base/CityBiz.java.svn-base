package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.City;

public interface CityBiz {
	
	/**
	 * 通过分页方式获取City的list集合
	 * @ List<City> getCityList(CityBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 2, 20124:11:09 PM
	 * @ description 
	 * 	page 从第page页开始取数据
	 *  rowsPerPage  每页最多显示rowsPerPage条数据
	 * @ reviewed_by
	 */
	public List<City> getCityList(int page , int rowsPerPage) throws SQLException;
	
	/**
	 * 获得所有的City
	 * @return
	 */
	public List<City> getCityList() throws SQLException;
}
