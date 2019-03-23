package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.RouteDAO;
import com.tarena.tts.abs.entity.Route;
import com.tarena.tts.abs.util.HibernateUtils;

public class RouteDAOImpl implements RouteDAO{

	@Override
	public void delete(Route route) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(route);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Route> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Route");
		List<Route> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Route findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Route where routeId = ?");
		query.setParameter(0, id);
		
		List<Route> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Route route) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(route);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Route route) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(route);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Route> findRoute(int fromAirportId, int toAirportId)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from Route where " +
				"fromAirportId = ? and " +
				"toAirportId = ?");
		query.setParameter(0, fromAirportId);
		query.setParameter(1, toAirportId);
		
		List<Route> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
}
