package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.Information;

/**
 * 资讯信息操作的DAO组件
 * @ file_name InformationDAO.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 19, 20126:38:29 PM
 * @ description
 * @ reviewed_by 
 */
public interface InformationDAO {
	
	public void update(Information information) throws SQLException;
	
	public void save(Information information) throws SQLException;
	
	public void delete(Information information) throws SQLException;
	
	public Information findById(int id) throws SQLException;
	
	public List<Information> findAll() throws SQLException;
	
	/**
	 * 获取前n条最新资讯的方法
	 * @ List<Information> findNewInfo(InformationDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:42:43 PM
	 * @ description
	 * @param top 最新的top条资讯
	 * @ reviewed_by
	 */
	public List<Information> findNewInfo(int top);
}
