package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.BranchDAO;
import com.tarena.tts.abs.entity.Branch;
import com.tarena.tts.abs.util.HibernateUtils;

public class BranchDAOImpl implements BranchDAO{

	@Override
	public void delete(Branch branch) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(branch);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Branch> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Branch");
		List<Branch> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Branch findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Branch where branchId = ?");
		query.setParameter(0, id);
		
		List<Branch> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Branch branch) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(branch);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Branch branch) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(branch);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Branch> findByProvinceId(int provinceId) 
	throws SQLException {
		
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from Branch where provinceId = ?");
		query.setParameter(0, provinceId);
		
		List<Branch> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}

	@Override
	public List<Branch> findByCityId(int cityId) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from Branch where cityId = ?");
		query.setParameter(0, cityId);
		
		List<Branch> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}

	@Override
	public List<Branch> findByName(String name) {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from Branch where branchName = ?");
		query.setParameter(0, name);
		
		List<Branch> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}

	@Override
	public List<Object[]> findBranch() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"select b.branchId , " +
						" b.branchName , " +
						" c.cityName , " +
						" b.branchAddress , " +
						" b.branchTelephone1 " +
				" from Branch b , City c " +
				" where b.cityId = c.cityId ");
		
		List<Object[]> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
}
