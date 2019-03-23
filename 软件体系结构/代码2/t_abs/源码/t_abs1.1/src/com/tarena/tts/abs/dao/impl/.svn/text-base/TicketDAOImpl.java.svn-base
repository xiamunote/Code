package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.TicketDAO;
import com.tarena.tts.abs.entity.Ticket;
import com.tarena.tts.abs.util.HibernateUtils;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public void delete(Ticket ticket) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(ticket);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Ticket> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Ticket");
		List<Ticket> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Ticket findById(long id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Ticket where ticketId = ?");
		query.setParameter(0, id);
		
		List<Ticket> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Ticket ticket) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(ticket);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Ticket ticket) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(ticket);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
}
