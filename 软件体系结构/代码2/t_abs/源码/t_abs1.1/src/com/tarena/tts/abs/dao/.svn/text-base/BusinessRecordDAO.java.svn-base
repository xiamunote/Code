package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.BusinessRecord;

/**
 * 营业记录操作的DAO组件
 * @author Administrator
 *
 */
public interface BusinessRecordDAO {
	
	/**
	 * 更新营业记录
	 * @param businessRecord 营业记录对象
	 * @throws SQLException
	 */
	public void update(BusinessRecord businessRecord) throws SQLException;
	
	/**
	 * 保存营业记录信息
	 * @param businessRecord 营业记录对象
	 * @throws SQLException
	 */
	public void save(BusinessRecord businessRecord) throws SQLException;
	
	/**
	 * 删除营业记录
	 * @param businessRecord 营业记录对象
	 * @throws SQLException
	 */
	public void delete(BusinessRecord businessRecord) throws SQLException;
	
	/**
	 * 通过id查找营业记录
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public BusinessRecord findById(long id) throws SQLException;
	
	/**
	 * 查找全部营业记录
	 * @return List<BusinessRecord> 营业记录对象集合
	 * @throws SQLException
	 */
	public List<BusinessRecord> findAll() throws SQLException;
}
