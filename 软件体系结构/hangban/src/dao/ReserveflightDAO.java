package dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import pojo.Flight;
import pojo.Reserveflight;


public class ReserveflightDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ReserveflightDAO.class);

	// property constants

	public void save(Reserveflight transientInstance) {
		log.debug("saving Reserveflight instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reserveflight persistentInstance) {
		log.debug("deleting Reserveflight instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	
	public List findAll() {
		log.debug("finding all Reserveflight instances");
		try {
			String queryString = "from Reserveflight";
			Query queryObject = getSession().createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll1(String username) {
		log.debug("finding all Reserveflight instances");
		try {
			String queryString = "from Reserveflight where userinfo.username='"+username+"'";
			Query queryObject = getSession().createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}	
	
	public void boucetine(Long softnumber,Long hardnumber,Long reservid){
		
		Reserveflight reserveflight=(Reserveflight)getSession().get(Reserveflight.class,reservid);
		
		Flight flight=reserveflight.getFlight();
		
		flight=(Flight)getSession().get(Flight.class,flight.getFlightid());
		
		flight.setSofttotal(flight.getSofttotal()+softnumber);
		
		flight.setHardtotal(flight.getHardtotal()+hardnumber);

		reserveflight=(Reserveflight)getSession().get(Reserveflight.class,reserveflight.getReservid());
		
		getSession().delete(reserveflight);
		
		getSession().beginTransaction().commit();
		
		getSession().close();
		
	}
	
}