package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tarena.tts.abs.dao.OrderdetailDAO;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.util.HibernateUtils;

public class OrderdetailDAOImpl implements OrderdetailDAO {

	public List<Object[]> findOrderdetail(Long orderId) throws SQLException {
		Session session = HibernateUtils.getSession();
		String hql = 
				"select  distinct " +
					" p.psgName, " +
					" p.psgCertifType, " +
					" p.psgCertifNum, " +
					" p.psgType, " +
					" t.flightNum, " +
					" date_format(t.departureDatetime ,'%Y-%m-%d'), " +
					" date_format(t.departureDatetime , '%H:%i'), " +
					" t.cabinClass, " + 
					" t.ticketId, " + 
					" f.fullPrice, " + 
					" t.ticketPrice, " +
					" t.tax1Price, " +
					" t.tax2Price, " +
					" t.totalPrice " +
				" from Ticket t, Passenger p, Flight f " +
				" where t.psgId=p.psgId and t.flightNum=f.flightNum " +
				" and t.orderId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, orderId);
		List<Object[]> orderList = query.list();
		HibernateUtils.closeSession();
		return orderList;
	}

	public List<TicketOrder> findTicketOrder(Long orderId) throws Exception {
		Session session = HibernateUtils.getSession();
		String hql = "from TicketOrder to where to.orderId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, orderId);
		List<TicketOrder> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}

}
