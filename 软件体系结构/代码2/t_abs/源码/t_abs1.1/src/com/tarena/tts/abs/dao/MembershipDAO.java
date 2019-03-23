package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.List;
import com.tarena.tts.abs.entity.Membership;

/**
 * 会员信息操作的DAO组件
 * @author Administrator
 *
 */
public interface MembershipDAO {

	public void update(Membership membership) throws SQLException;
	

	public void save(Membership membership) throws SQLException;
	

	public void delete(Membership membership) throws SQLException;
	

	public Membership findById(int id) throws SQLException;
	

	public List<Membership> findAll() throws SQLException;
}
