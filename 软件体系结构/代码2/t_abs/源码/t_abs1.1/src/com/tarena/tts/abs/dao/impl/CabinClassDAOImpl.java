package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.CabinClassDAO;
import com.tarena.tts.abs.entity.CabinClass;
import com.tarena.tts.abs.util.HibernateUtils;

public class CabinClassDAOImpl implements CabinClassDAO{

	@Override
	public void delete(CabinClass cabinClass) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(cabinClass);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<CabinClass> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from CabinClass");
		List<CabinClass> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public CabinClass findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from CabinClass where cabinClassId = ?");
		query.setParameter(0, id);
		
		List<CabinClass> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(CabinClass cabinClass) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(cabinClass);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(CabinClass cabinClass) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(cabinClass);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
}
