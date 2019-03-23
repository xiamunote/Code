package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.CabinClass;

/**
 * 舱位等级操作的DAO组件
 * @author Administrator
 *
 */
public interface CabinClassDAO {
	
	/**
	 * 更新舱位等级信息
	 * @ void update(CabinClassDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20122:59:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void update(CabinClass cabinClass) throws SQLException;
	
	/**
	 * 保存舱位等级信息
	 * @ void save(CabinClassDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20122:59:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void save(CabinClass cabinClass) throws SQLException;
	
	/**
	 * 删除舱位等级信息
	 * @ void delete(CabinClassDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20122:59:40 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void delete(CabinClass cabinClass) throws SQLException;
	
	/**
	 * 通过id查找舱位等级信息
	 * @ CabinClass findById(CabinClassDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20122:59:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public CabinClass findById(int id) throws SQLException;
	
	/**
	 * 查找全部舱位等级信息
	 * @ List<CabinClass> findAll(CabinClassDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20123:00:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<CabinClass> findAll() throws SQLException;
}
