package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.CityDAO;
import com.tarena.tts.abs.entity.City;
import com.tarena.tts.abs.util.HibernateUtils;

public class CityDAOImpl implements CityDAO {

	@Override
	public void delete(City city) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(city);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<City> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from City");
		List<City> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public City findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from City where cityId = ?");
		query.setParameter(0, id);
		
		List<City> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(City city) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(city);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(City city) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(city);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
	@Override
	public List<City> findByPage(int page , int rowsPerPage) 
	throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from City");
		query.setFirstResult((page-1)*rowsPerPage);
		query.setMaxResults(rowsPerPage);
		
		List<City> list = query.list();

		HibernateUtils.closeSession();
		
		return list;
	}
}
