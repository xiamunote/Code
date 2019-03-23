package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.tts.abs.dao.ProvinceDAO;
import com.tarena.tts.abs.entity.Province;
import com.tarena.tts.abs.entity.Route;
import com.tarena.tts.abs.util.HibernateUtils;

public class ProvinceDAOImpl implements ProvinceDAO {

	@Override
	public void delete(Province province) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(province);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Province> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Province");
		List<Province> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Province findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Province where provinceId = ?");
		query.setParameter(0, id);
		
		List<Province> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Province province) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(province);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Province province) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(province);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

}
