package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.Branch;

/**
 * 营业网点操作的DAO组件
 * @author baiyx
 *
 */
public interface BranchDAO {
	
	/**
	 * 更新营业网点信息
	 * @param branch 营业网点对象
	 * @throws SQLException
	 */
	public void update(Branch branch) throws SQLException;
	
	/**
	 * 保存营业网点信息
	 * @param branch 营业网点对象
	 * @throws SQLException
	 */
	public void save(Branch branch) throws SQLException;
	
	/**
	 * 删除营业网点对象
	 * @param branch 营业网点对象
	 * @throws SQLException
	 */
	public void delete(Branch branch) throws SQLException;
	
	/**
	 * 通过id查找营业网点
	 * @param id 
	 * @return
	 * @throws SQLException
	 */
	public Branch findById(int id) throws SQLException;
	
	/**
	 * 查找全部营业网点
	 * @return
	 * @throws SQLException
	 */
	public List<Branch> findAll() throws SQLException;
	
	/**
	 * 通过省会ID查找营业网点
	 * @ List<Branch> findByProvinceId(BranchDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20124:54:19 PM
	 * @ description 
	 * @param provinceId 省会ID
	 * @ reviewed_by
	 */
	public List< Branch> findByProvinceId(int provinceId) throws SQLException;
	
	/**
	 * 通过城市ID查找营业网点
	 * @ List<Branch> findByCityId(BranchDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20125:27:11 PM
	 * @ description
	 * @param cityId 城市ID 
	 * @ reviewed_by
	 */
	public List<Branch> findByCityId(int cityId) throws SQLException;
	
	/**
	 * 通过营业网点名称查找网点信息
	 * @ List<Branch> findByName(BranchDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 18, 20125:35:43 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Branch> findByName(String name) throws SQLException;
	
	/**
	 * 查询出网点名称、所属地区、详细地址、联系电话
	 * @ List<Object[]> findBranch(BranchDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 14, 20123:23:14 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<Object[]> findBranch() throws SQLException;

}
