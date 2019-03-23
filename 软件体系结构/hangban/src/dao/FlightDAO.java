package dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import factory.HibernateSessionFactory;

import pojo.Flight;
import pojo.Reserveflight;
import pojo.Userinfo;

public class FlightDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(FlightDAO.class);
	// property constants
	public static final String FLIGHTNO = "flightno";
	public static final String FLIGHTTYPE = "flighttype";
	public static final String LEAVETIME = "leavetime";
	public static final String ARRIVETIME = "arrivetime";

	public void save(Flight transientInstance) {
		log.debug("saving Flight instance");
		try {
			getSession().save(transientInstance);
			getSession().beginTransaction().commit();
			getSession().close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Long id) {
		log.debug("deleting Flight instance");
		try {
			Flight persistentInstance = (Flight) getSession().get(Flight.class,
					id);
			getSession().delete(persistentInstance);
			getSession().beginTransaction().commit();
			getSession().close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void update(Flight f) {

		Flight flight = (Flight) getSession()
				.get(Flight.class, f.getFlightid());

		try {
			BeanUtils.copyProperties(flight, f);
		} catch (Exception e) {

			e.printStackTrace();
		}

		getSession().update(flight);
		getSession().beginTransaction().commit();

	}

	public void reserveflight(Long userid, Long flightid, Long softnumber,
			Long hardnumber) {
		Flight flight = (Flight) getSession().get(Flight.class, flightid);
		Userinfo userinfo = (Userinfo) getSession().get(Userinfo.class, userid);

		flight.setSofttotal(flight.getSofttotal() - softnumber);
		flight.setHardtotal(flight.getHardtotal() - hardnumber);

		Reserveflight r = new Reserveflight();
		r.setFlight(flight);
		r.setUserinfo(userinfo);
		r.setSoftnumber(softnumber);
		r.setHardnumber(hardnumber);

		long totalprices = softnumber * flight.getSoftprice() + hardnumber
				* flight.getHardprice();

		r.setTotalprices(totalprices);

		r.setReservtime(new Date());

		getSession().save(r);
		getSession().beginTransaction().commit();
		getSession().close();
		System.out.println("预定成功");
	}

	public List showDestine(String flightno, String username) {
		// 普通用户检索结果的方法
		Session session = HibernateSessionFactory.getSession();

		String hql = null;

		List list = null;

		if (flightno != null) {

			hql = "from Reserveflight where flight.flightno like '%" + flightno
					+ "%' and userinfo.username='" + username + "'";

			Query query = session.createQuery(hql);

			list = query.list();

		} else {
			// 如果航空号为空，则按姓名查询
			hql = "from Reserveflight where userinfo.username='" + username
					+ "'";

			Query query = session.createQuery(hql);

			list = query.list();

		}
		getSession().close();
		return list;
	}
	
	public List reserSelect(String qdzhan,String zhdzhan){
		Session session = HibernateSessionFactory.getSession();
		String hql = null;
		hql="from Flight f where f.qdzhan=:a and f.zhdzhan=:b";
		System.out.println("hql============"+hql);
		Query query=session.createQuery(hql);
		query.setString("a",qdzhan);
		query.setString("b",zhdzhan);
		List list=query.list();
		System.out.println("list============"+list.size());
		session.close();
		return list;
		
	}
	
	

	public List selectDestine(String flightno, String username) {
		// 管理员检索结果的方法
		List list = null;
		if (("").equals(flightno) && ("").equals(username)) {
			String hql = "from Reserveflight";
			list = getSession().createQuery(hql).list();

		} else if (!(("").equals(flightno)) && !(("").equals(username))) {
			String hql = "from Reserveflight where flight.flightno like '%"
					+ flightno + "%' and userinfo.username like '%" + username
					+ "%'";
			list = getSession().createQuery(hql).list();

		} else {
			if (!"".equals(username)) {
				String hql = "from Reserveflight where userinfo.username like '%"
						+ username + "%'";
				list = getSession().createQuery(hql).list();
			} else {
				String hql = "from Reserveflight where flight.flightno like '%"
						+ flightno + "%'";
				list = getSession().createQuery(hql).list();
			}
		}
System.out.println("list=========="+list.size());
		getSession().close();
		return list;
	}

	public Flight findById(java.lang.Long id) {
		log.debug("getting Flight instance with id: " + id);
		try {
			Flight instance = (Flight) getSession().get("pojo.Flight", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Flight";
			Query queryObject = getSession().createQuery(queryString);

			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
	final static Integer pageSize=4;
	
	public Integer pageSize(){
		
		Session session=HibernateSessionFactory.getSession();
		
		Query query=session.createQuery("select count(*) from Flight");
		
		List list=query.list();
		
		int i=new Integer(list.get(0).toString());
		
		if(i%pageSize==0){
			
			i=i/pageSize;
			
		}else{
			
			i=i/pageSize+1;
		}
		
		return i;
	}
	
	
	
	public List findAllFlight(int currentpage) {
		try {
			String queryString = "from Flight";
			Query queryObject = getSession().createQuery(queryString).setFirstResult((currentpage-1)*pageSize).setMaxResults(pageSize);
			List list=queryObject.list();
			System.out.println("list============="+list.size());
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}