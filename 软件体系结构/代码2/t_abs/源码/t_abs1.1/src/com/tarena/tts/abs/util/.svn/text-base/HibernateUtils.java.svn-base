package com.tarena.tts.abs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	private static Configuration conf;
	private static SessionFactory factory;
	static {
		conf = new Configuration();
		conf.configure();
		factory = conf.buildSessionFactory();
	}

	/**
	 * 
	 * @return
	 */
	public static Session getSession() {
		// factory.getCurrentSession();
		Session session = tl.get();
		if (session == null) {
			session = factory.openSession();
			tl.set(session);
		}
		return session;
	}

	/**
	 * 
	 */
	public static void closeSession() {
		Session session = tl.get();
		if (session != null) {
			session.close();
			tl.set(null);
		}
	}
}
