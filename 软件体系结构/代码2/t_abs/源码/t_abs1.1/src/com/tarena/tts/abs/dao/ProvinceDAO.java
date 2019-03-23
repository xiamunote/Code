package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Province;

/**
 * 省份信息操作的DAO组件
 * @author Administrator
 *
 */
public interface ProvinceDAO {

	public void update(Province province) throws SQLException;

	public void save(Province province) throws SQLException;
	
	public void delete(Province province) throws SQLException;
	
	public Province findById(int id) throws SQLException;
	
	public List<Province> findAll() throws SQLException;
}
