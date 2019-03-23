package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.FlightPlanDAO;
import com.tarena.tts.abs.entity.FlightPlan;
import com.tarena.tts.abs.util.HibernateUtils;

public class FlightPlanDAOImpl implements FlightPlanDAO {

	@Override
	public void delete(FlightPlan flightPlan)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(flightPlan);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<FlightPlan> findAll()
			throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from FlightPlan");
		List<FlightPlan> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public FlightPlan findById(int id)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from FlightPlan where fpId = ?");
		query.setParameter(0, id);
		
		List<FlightPlan> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(FlightPlan flightPlan)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(flightPlan);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(FlightPlan flightPlan)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(flightPlan);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

}
