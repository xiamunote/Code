package dao;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import factory.HibernateSessionFactory;

import pojo.Userinfo;


public class UserinfoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UserinfoDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String REALNAME = "realname";
	public static final String PASSWORD = "password";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String EMAIL = "email";
	public static final String ISMANAGER = "ismanager";

	public void save(Userinfo transientInstance) {
		log.debug("saving Userinfo instance");
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

	public void delete(Userinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			getSession().delete(persistentInstance);
			getSession().beginTransaction().commit();
			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(Userinfo user){
		getSession().update(user);
		getSession().beginTransaction().commit();
		getSession().close();
	}
	public Userinfo findById(java.lang.Long id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			Userinfo instance = (Userinfo) getSession()
					.get("pojo.Userinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findAll() {
		log.debug("finding all Userinfo instances");
		try {
			String queryString = "from Userinfo";
			Query queryObject = getSession().createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}