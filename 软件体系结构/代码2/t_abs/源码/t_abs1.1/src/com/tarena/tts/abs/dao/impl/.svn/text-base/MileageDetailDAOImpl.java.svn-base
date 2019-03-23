package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.MileageDetailDAO;
import com.tarena.tts.abs.entity.MileageDetail;
import com.tarena.tts.abs.util.HibernateUtils;

public class MileageDetailDAOImpl implements MileageDetailDAO{

	@Override
	public void delete(MileageDetail mileageDetail) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(mileageDetail);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<MileageDetail> findAll() 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from MileageDetail");
		List<MileageDetail> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public MileageDetail findById(long id) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from MileageDetail where mileageId = ?");
		query.setParameter(0, id);
		
		List<MileageDetail> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(MileageDetail mileageDetail) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(mileageDetail);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(MileageDetail mileageDetail) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(mileageDetail);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<MileageDetail> findByMemb_id(int mid) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from MileageDetail where membId = ?");
		query.setParameter(0, mid);
		
		List<MileageDetail> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}
}
