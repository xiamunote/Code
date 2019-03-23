package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.MileageDetail;

/**
 * 会员里程细节操作的DAO组件
 * @author Administrator
 *
 */
public interface MileageDetailDAO {

	public void update(MileageDetail mileageDetail) throws SQLException;

	public void save(MileageDetail mileageDetail) throws SQLException;
	
	public void delete(MileageDetail mileageDetail) throws SQLException;
	
	public MileageDetail findById(long id) throws SQLException;
	
	public List<MileageDetail> findAll() throws SQLException;
	
	/**
	 * 通过会员ID查找会员里程细节信息
	 * @ List<MileageDetail> findByMemb_id(MileageDetailDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20123:51:14 PM
	 * @ description
	 * @param mid 会员ID
	 * @ reviewed_by
	 */
	public List<MileageDetail> findByMemb_id(int mid) throws SQLException;
}
