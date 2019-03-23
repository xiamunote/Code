package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.PlaneDAO;
import com.tarena.tts.abs.entity.Plane;
import com.tarena.tts.abs.util.HibernateUtils;

/**
 * 飞机信息操作的DAO组件
 * @author Administrator
 *
 */
public class PlaneDAOImpl implements PlaneDAO{

	@Override
	public void delete(Plane plane) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(plane);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Plane> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from Plane");
		List<Plane> list = query.list();
		
		HibernateUtils.closeSession();
		
		return list;
	}

	@Override
	public Plane findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				"from Plane where planeId = ?");
		query.setParameter(0, id);
		
		List<Plane> list = query.list();

		HibernateUtils.closeSession();
		
		return list.get(0);
	}

	@Override
	public void save(Plane plane) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(plane);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public void update(Plane plane) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(plane);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Plane> findByPlaneModel(String planeModel) {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery(
				"from Plane where planeModel = ?");
		query.setParameter(0, planeModel);
		
		List<Plane> list = query.list();
		
		HibernateUtils.closeSession();
		return list;
	}
}
