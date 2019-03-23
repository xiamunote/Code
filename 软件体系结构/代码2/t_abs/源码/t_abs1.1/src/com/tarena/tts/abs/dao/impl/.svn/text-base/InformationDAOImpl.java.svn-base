package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.tts.abs.dao.InformationDAO;
import com.tarena.tts.abs.entity.Airport;
import com.tarena.tts.abs.entity.Information;
import com.tarena.tts.abs.util.HibernateUtils;

/**
 * @ file_name InformationDAOImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 20, 201210:07:05 AM
 * @ description
 * @ reviewed_by 
 */
public class InformationDAOImpl implements InformationDAO{

	@Override
	public void delete(Information information) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(information);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Information> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Information");
		List<Information> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Information findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Information where infoId = ?");
		query.setParameter(0, id);
		
		List<Information> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Information information) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(information);
		
		tx.commit();
		HibernateUtils.closeSession();
		
	}

	@Override
	public void update(Information information) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(information);
		
		tx.commit();
		HibernateUtils.closeSession();
		
	}
	
	@Override
	public List<Information> findNewInfo(int top) {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Information order by infoTop desc , infoTime desc");
		
		//我们只取前top条数据
		query.setFirstResult(0);
		query.setMaxResults(top);
		
		List<Information> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
}
