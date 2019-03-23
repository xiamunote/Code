package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.TicketOrderDAO;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.util.HibernateUtils;

public class TicketOrderDAOImpl implements TicketOrderDAO{

	@Override
	public void delete(TicketOrder ticketOrder) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(ticketOrder);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<TicketOrder> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from TicketOrder");
		List<TicketOrder> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public TicketOrder findById(long id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from TicketOrder where orderId = ?");
		query.setParameter(0, id);
		
		List<TicketOrder> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(TicketOrder ticketOrder) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(ticketOrder);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(TicketOrder ticketOrder) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(ticketOrder);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<TicketOrder> findByPassenger(String passengerName)
			throws Exception {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from TicketOrder where passengerId = " +
				"(from Passenger " +
				" where psgName = ?)");
		query.setParameter(0, passengerName);
		
		List<TicketOrder> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}

	@Override
	public void updateOrderState(String orderState, long id) 
	throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(
				 "from TicketOrder where orderId = ?");
		query.setParameter(0, id);
		
		List<TicketOrder> list = query.list();
		
		TicketOrder to = list.get(0);
		to.setOrderState(orderState);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
	@Override
	public List<Object[]> findMyOrders(
			Long orderId, 
			Date orderDate1,
			Date orderDate2, 
			String orderState, 
			String fromCity,
			String toCity , 
			int userId)
			throws SQLException {
		Session session = HibernateUtils.getSession();
		
		String hql = 
				"select  distinct " +
					" o.orderId , " +
					" f.flightNum ," +
					" date_format(f.flDepartureDate ,'%Y-%m-%d') ," +
					" date_format(f.flDepartureDate , '%H:%i') ," +
					" o.orderMoney , " +
					" o.orderState ," +
					" o.orderDate " +
				" from TicketOrder o , Flight f , " +
				" Route r , Airport a1 , Airport a2 " +
				" where " +
					" o.flightId = f.flightId " +
					" and f.routeId = r.routeId " +
					" and o.userId = :expression00 ";
		
		//01
		if(orderId != null){
			hql = hql + " and o.orderId = :expression01 ";
		}	
		//02
		if(orderDate1 != null){
			hql = hql + " and o.orderDate >= :expression02 ";
		}	
		//03
		if(orderDate2 != null){
			hql = hql + " and o.orderDate <= :expression03 ";
		}	
		//04
		if(orderState != null){
			hql = hql + " and o.orderState = :expression04 ";
		}
		//05
		if(fromCity != null){
			hql = hql + 
					" and r.fromAirportId = a1.airportId" +
					" and a1.airportFullName like :expression05 ";
		}
		//06
		if(toCity != null){
			hql = hql + 
					" and r.toAirportId = a2.airportId" +
					" and a2.airportFullName like :expression06  ";
		}
		
		Query query = session.createQuery(hql);
		
		
		//00
		query.setParameter("expression00", userId);
		
		//01
		if(orderId != null){
			query.setParameter("expression01", orderId);
		}
		//02
		if(orderDate1 != null){
			query.setParameter("expression02", orderDate1);
		}
		//03
		if(orderDate2 != null){
			query.setParameter("expression03", orderDate2);
		}
		//04
		if(orderState != null){
			query.setParameter("expression04", orderState);
		}
		//05
		if(fromCity != null){
			query.setParameter("expression05", fromCity+"%");
		}
		//06
		if(toCity != null){
			query.setParameter("expression06", toCity+"%");
		}

		List<Object[]> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
}









