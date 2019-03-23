package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Plane;

/**
 * 飞机信息操作的DAO组件
 * @author Administrator
 *
 */
public interface PlaneDAO {

	public void update(Plane plane) throws SQLException;

	public void save(Plane plane) throws SQLException;
	
	public void delete(Plane plane) throws SQLException;
	
	public Plane findById(int id) throws SQLException;
	
	public List<Plane> findAll() throws SQLException;
	
	/**
	 * 通过飞机机型查找飞机信息
	 * @ List<Plane> findByPlaneModel(PlaneDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20124:16:38 PM
	 * @ description
	 * @param planeModel 飞机机型
	 * @ reviewed_by
	 */
	public List<Plane> findByPlaneModel(String planeModel);
}
