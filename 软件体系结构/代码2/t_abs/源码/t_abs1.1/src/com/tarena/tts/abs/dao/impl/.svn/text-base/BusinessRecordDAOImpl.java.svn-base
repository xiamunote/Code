package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.BusinessRecordDAO;
import com.tarena.tts.abs.entity.BusinessRecord;
import com.tarena.tts.abs.util.HibernateUtils;

public class BusinessRecordDAOImpl implements BusinessRecordDAO{

	@Override
	public void delete(BusinessRecord businessRecord) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(businessRecord);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<BusinessRecord> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from BusinessRecord");
		List<BusinessRecord> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public BusinessRecord findById(long id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from BusinessRecord where busRecId = ?");
		query.setParameter(0, id);
		
		List<BusinessRecord> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(BusinessRecord businessRecord) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(businessRecord);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(BusinessRecord businessRecord) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(businessRecord);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
}
