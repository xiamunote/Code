package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.City;

/**
 * 城市操作的DAO组件
 * @author Administrator
 *
 */
public interface CityDAO {
	
	/**
	 * 更新
	 * @ void update(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:05:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void update(City city) throws SQLException;
	
	/**
	 * 保存
	 * @ void save(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:05:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void save(City city) throws SQLException;
	
	/**
	 * 删除
	 * @ void delete(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:05:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void delete(City city) throws SQLException;
	
	/**
	 * 通过id查找
	 * @ City findById(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:05:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public City findById(int id) throws SQLException;
	
	/**
	 * 查找全部
	 * @ List<City> findAll(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:05:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<City> findAll() throws SQLException;
	
	/**
	 * 分页查询
	 * @ List<City> findByPage(CityDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 2, 20124:05:08 PM
	 * @ description 
	 *  page 从第page页开始取数据
	 *  rowsPerPage  每页最多显示rowsPerPage条数据
	 * @ reviewed_by
	 */
	public List<City> findByPage(int page , int rowsPerPage) throws SQLException;
}
