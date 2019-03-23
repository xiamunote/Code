package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.FlightDAO;
import com.tarena.tts.abs.entity.Flight;

import com.tarena.tts.abs.util.DateUtil;
import com.tarena.tts.abs.util.HibernateUtils;

public class FlightDAOImpl implements FlightDAO{

	@Override
	public void delete(Flight flight) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(flight);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Flight> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Flight");
		List<Flight> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Flight findById(String sid) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Flight where flightId = ?");
		query.setParameter(0, sid);
		
		List<Flight> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Flight flight) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(flight);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Flight flight) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(flight);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
	@Override
	public List<Flight> findFlight(String startAirport, String endAirport,
			Date startDate, Date arrivalDate) throws Exception {
		Session session = HibernateUtils.getSession();
		
		String hql = "from Flight " +
				" where flightId in ( " +
				" select distinct f.flightId " +
				" from Flight f , Route r , Airport a , Airport b " +
				" where f.routeId = r.routeId ";
		
		//01
		if(startAirport != null){
			hql = hql +
			" and a.airportId = r.fromAirportId " +
			" and a.airportFullName like :expression01 ";
		}	
		//02
		if(endAirport != null){
			hql = hql +
			" and b.airportId = r.toAirportId " +
			" and b.airportFullName like :expression02 ";
		}	
		//03
		if(startDate != null){
			hql = hql +
			" and f.flDepartureDate >= :expression03 ";
		}	
		//04
		if(arrivalDate != null){
			hql = hql +
			" and f.flArrivalDate <= :expression04 ";
		}
		
		hql = hql + ")";
		
		Query query = session.createQuery(hql);
		//01
		if(startAirport != null){
			query.setString("expression01", startAirport+"%");
		}
		//02
		if(endAirport != null){
			query.setString("expression02", endAirport+"%");
		}
		//03
		if(startDate != null){
			query.setString("expression03", DateUtil.format(startDate));
		}
		//04
		if(arrivalDate != null){
			query.setString("expression04", DateUtil.format(arrivalDate));
		}
				
		List<Flight> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}
	
	@Override
	public List<Object[]> findFlightMore(
			String startAirport, String endAirport,
			Date startDate, Date arrivalDate) throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		String hql = "select " +
				" distinct f.flightId , " +
				" f.flightNum , " +
				" date_format(f.flDepartureDate ,'%Y-%m-%d') ,  " +
				" date_format(f.flDepartureDate , '%H:%i') ," +
				" date_format(f.flArrivalDate , '%H:%i') , " +
				" p.planeModel , " +
				" r.routeDistance ,  " +
				" f.fseatsRemain , " +
				" f.bseatsRemain , " +
				" f.eseatsRemain , " +
				" f.fullPrice , " +
				" f.currentDiscount , " +
				" f.tax1Price , " +
				" f.tax2Price, " +
				" a1.airportFullName, " +
				" a2.airportFullName " +
				" from Flight f , Route r ," +
				"      Plane p , Airport a1 , Airport a2 " +
				" where f.routeId = r.routeId  " +
				" and f.planeId = p.planeId " + 
				" and r.fromAirportId = a1.airportId " + 
				" and r.toAirportId = a2.airportId";
		
		//01
		if(startAirport != null){
			hql = hql +
			//" and a1.airportId = r.fromAirportId " +
			" and a1.airportFullName like :startAirPortName ";
		}	
		//02
		if(endAirport != null){
			hql = hql +
			//" and a2.airportId = r.toAirportId " +
			" and a2.airportFullName like :endAirPortName ";
		}	
		//03
		if(startDate != null){
			hql = hql +
			" and f.flDepartureDate >= :startDate " ;
		}	
		//04
		if(arrivalDate != null){
			hql = hql +
			" and f.flArrivalDate <= :arrivalDate ";
		}
		
		Query query = session.createQuery(hql);
		
		//01
		if(startAirport != null){
			query.setString("startAirPortName", startAirport+"%");
		}
		//02
		if(endAirport != null){
			query.setString("endAirPortName", endAirport+"%");
		}
		//03
		if(startDate != null){
			query.setString("startDate", DateUtil.format(startDate));
		}
		//04
		if(arrivalDate != null){
			query.setString("arrivalDate", DateUtil.format(arrivalDate));
		}
		
		List<Object[]> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}
	
	@Override
	public List<Object[]> findHotFlight(int size) throws Exception {
		Session session = HibernateUtils.getSession();
		//出发日期，始发地，目的地，折扣，折扣价
		
		String hql = 
			"select f.flightId , " +
					" date_format(f.flDepartureDate ,'%m-%d') , " +
					" c1.cityName , " +
					" c2.cityName , " +
					" f.currentDiscount , " +
					" f.currentPrice " +
			" from Flight f , Route r , Airport a1 , Airport a2 , City c1 , City c2 " +
			" where f.routeId = r.routeId " +
			" and r.fromAirportId = a1.airportId " +
			" and r.toAirportId = a2.airportId " +
			" and a1.cityId = c1.cityId " +
			" and a2.cityId = c2.cityId " +
			" order by f.currentDiscount ";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(size);
		List<Object[]> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
	
	@Override
	public List<Object[]> findFlight01() throws SQLException {
		Session session = HibernateUtils.getSession();
		String beginDate = DateUtil.format1(new Date()) + "%";
		System.out.println("beginDate=" + beginDate);
		String hql = "select f.flightNum , " +
				" date_format(f.flDepartureDate ,'%Y-%m-%d') ,  " +
				" date_format(f.flDepartureDate , '%H:%i') ," +
				" date_format(f.flArrivalDate , '%H:%i') ," +
				" p.planeModel , " +
				" r.routeDistance , " +
				" f.currentDiscount, " +
				" a.airportFullName, " +
				" b.airportFullName, " + 
				" f.fullPrice," +
				" f.flightId" +
				" from Flight f , Route r , Plane p , Airport a, Airport b " +
				" where f.routeId = r.routeId   " +
				" and f.planeId = p.planeId " +
				" and a.airportId = r.fromAirportId " +
				" and b.airportId = r.toAirportId " + 
				" and f.flDepartureDate like '" + beginDate + "'";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		HibernateUtils.closeSession();
		return list;
	}
	
	@Override
	public Object[] findFlight01ById(String flightId) throws SQLException {

		Session session = HibernateUtils.getSession();

		String hql = "select f.flightId , " 
					+ " f.flightNum , "
					+ " date_format(f.flDepartureDate ,'%Y-%m-%d') ,  "
					+ " date_format(f.flDepartureDate , '%H:%i') ,"
					+ " date_format(f.flArrivalDate , '%H:%i') ,"
					+ " p.planeModel , " 
					+ " r.routeDistance , "
					+ " f.fullPrice , " 
					+ " f.currentDiscount ," 
					+ " f.tax1Price ,  "
					+ " f.tax2Price , "
					+ " f.routeId "
				+ " from Flight f , Route r , Plane p , Airport a "
				+ " where f.routeId = r.routeId   "
					+ " and f.planeId = p.planeId "
					+ " and a.airportId = r.fromAirportId "
					+ " and f.flightId = :exp ";

		Query query = session.createQuery(hql);
		query.setParameter("exp", flightId);
		
		List<Object[]> list = query.list();

		HibernateUtils.closeSession();

		return list.get(0);
	}

	@Override
	public List<Object[]> findFlightDetail(String flightId) {
		
		Session session = HibernateUtils.getSession();
		String hql = "select " +
			" distinct f.flightId , " +
				" f.flightNum , " +
				" date_format(f.flDepartureDate ,'%Y-%m-%d') ,  " +
				" date_format(f.flDepartureDate , '%H:%i') ," +
				" date_format(f.flArrivalDate , '%H:%i') , " +
				" p.planeModel , " +
				" r.routeDistance ,  " +
				" f.fseatsRemain , " +
				" f.bseatsRemain , " +
				" f.eseatsRemain , " +
				" f.fullPrice , " +
				" f.currentDiscount , " +
				" f.tax1Price , " +
				" f.tax2Price , " +
				" f.routeId, " +
				" a1.airportFullName, " +
				" a2.airportFullName " +
			" from Flight f , Route r ," +
				" Plane p , Airport a1 , Airport a2 " +
			" where f.routeId = r.routeId  " +
				" and f.planeId = p.planeId " + 
				" and r.fromAirportId = a1.airportId " +
				" and r.toAirportId = a2.airportId " +
				" and f.flightId = '" + flightId + "'";
		List<Object[]> flightList = session.createQuery(hql).list();
		

		HibernateUtils.closeSession();
		
		return flightList;
	}
}
