package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.MembershipDAO;
import com.tarena.tts.abs.entity.Membership;
import com.tarena.tts.abs.util.HibernateUtils;

public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public void delete(Membership membership) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(membership);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Membership> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Membership");
		List<Membership> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Membership findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Membership where membId = ?");
		query.setParameter(0, id);
		
		List<Membership> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Membership membership) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(membership);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Membership membership) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(membership);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
}
