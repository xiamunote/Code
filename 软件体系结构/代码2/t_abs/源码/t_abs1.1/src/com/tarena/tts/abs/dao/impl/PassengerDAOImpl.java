package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.tts.abs.dao.PassengerDAO;
import com.tarena.tts.abs.entity.Membership;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.util.HibernateUtils;

public class PassengerDAOImpl implements PassengerDAO{

	@Override
	public void delete(Passenger passenger) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(passenger);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Passenger> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Passenger");
		List<Passenger> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Passenger findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Passenger where psgId = ?");
		query.setParameter(0, id);
		
		List<Passenger> list = query.list();

		HibernateUtils.closeSession();
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(Passenger passenger) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(passenger);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Passenger passenger) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(passenger);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void deleteById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(
						"from Passenger where psgId = ?");
		query.setParameter(0, id);

		List<Passenger> list = query.list();
		Passenger p = list.get(0);
		
		session.delete(p);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Passenger> findByUserId(int userId,int begin,int size) 
	throws SQLException {
		
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
						"from Passenger where refUserId = ?");
		query.setParameter(0, userId);
		query.setFirstResult(begin);
		query.setMaxResults(size);
		List<Passenger> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}

	@Override
	public int countByUserId(int userId) throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
						"select count(*) from Passenger where refUserId = ?");
		query.setParameter(0, userId);
		List<Long> list = query.list();
		Long size = (Long)list.get(0);
		HibernateUtils.closeSession();
		return size.intValue();
	}
	
	@Override
	public List<Passenger> findByUserId(Integer userId) {
		Session session = HibernateUtils.getSession();
		String hql = "from Passenger p where p.refUserId=" + userId;
		List<Passenger> passengers = session.createQuery(hql).list();
		

		HibernateUtils.closeSession();
		return passengers;
	}

	@Override
	public Passenger findPassengerByName(Passenger p) {
		Passenger passenger = new Passenger();
		Session session = HibernateUtils.getSession();
		String hql = "from Passenger p where p.psgName=? and " +
				"p.psgCertifType=? and " +
				"p.psgCertifNum=? and " +
				"p.psgType=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, p.getPsgName());
		query.setParameter(1, p.getPsgCertifType());
		query.setParameter(2, p.getPsgCertifNum());
		query.setParameter(3, p.getPsgType());
		List<Passenger> passengers = query.list();
		passenger = passengers.get(0);
		

		HibernateUtils.closeSession();
		
		return passenger;
	}
}
