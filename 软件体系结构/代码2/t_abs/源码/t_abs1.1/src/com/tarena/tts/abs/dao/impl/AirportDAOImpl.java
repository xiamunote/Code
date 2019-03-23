package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.AirportDAO;
import com.tarena.tts.abs.entity.Airport;
import com.tarena.tts.abs.util.HibernateUtils;

public class AirportDAOImpl implements AirportDAO {
	
	@Override
	public void delete(Airport airport) throws SQLException{
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(airport);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
	@Override
	public List<Airport> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Airport");
		List<Airport> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Airport findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Airport where airportId = ?");
		query.setParameter(0, id);
		
		List<Airport> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Airport airport) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(airport);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Airport airport) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(airport);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
}
