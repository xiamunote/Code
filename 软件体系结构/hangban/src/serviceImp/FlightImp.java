package serviceImp;

import org.hibernate.Session;

import factory.HibernateSessionFactory;

import pojo.Flight;
import service.FlightInterface;

public class FlightImp implements FlightInterface{

	public void save(Flight flight) {
		Session session=HibernateSessionFactory.getSession();
		session.save(flight);
		session.beginTransaction().commit();
		
	}

}
