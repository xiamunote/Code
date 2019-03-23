package com.tarena.tts.abs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tarena.tts.abs.dao.UserDAO;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.HibernateUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public void delete(User user) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(user);
		
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<User> findAll() throws SQLException {
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("from User");
		List<User> userList = query.list();
		
		HibernateUtils.closeSession();
		
		return userList;
	}

	@Override
	public User findById(int id) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from User where userId = ?");
		query.setParameter(0, id);
		
		List<User> empList = query.list();

		HibernateUtils.closeSession();
		if(!empList.isEmpty()){
			return empList.get(0);
		}
		return null;
	}

	@Override
	public User findByLoginName(String loginName) throws SQLException {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from User where userLoginName = ?");
		query.setParameter(0, loginName);
		
		List<User> empList = query.list();
		
		HibernateUtils.closeSession();
		if(empList.size() != 0){
			return empList.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		
		tx.commit();
		HibernateUtils.closeSession();
	}
	
	/**
	 * 更新User对象如下几个字段:
	 * private String userName;
	 * private String userState;
	 * private String userPassengerType;
	 * private String userTelephone;
	 * private String userCertifType;
	 * private String userCertifNum;
	 * private String userEmail;
	 * private Date userCreationDate;
	 * private Integer userTotalLoginSeconds;
	 * 
	 * 注意：此处不能使用session.update()方法
	 */
	@Override
	public void update(User user) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql="update User u set " +
					" u.userName = :userName ,  " +
					" u.userState = :userState , " +
					" u.userPassengerType = :userPassengerType , " +
					" u.userTelephone = :userTelephone , " +
					" u.userCertifType = :userCertifType , " +
					" u.userCertifNum = :userCertifNum , " +
					" u.userEmail = :userEmail , " +
					" u.userCreationDate = :userCreationDate , " +
					" u.userTotalLoginSeconds = :userTotalLoginSeconds " +
				" where u.userId = :userId ";
	    
		Query query =session.createQuery(hql);
		
		query.setParameter("userName", user.getUserName());
		query.setParameter("userState", user.getUserState());
		query.setParameter("userPassengerType", user.getUserPassengerType());
		query.setParameter("userTelephone", user.getUserTelephone());
		query.setParameter("userCertifType", user.getUserCertifType());
		query.setParameter("userCertifNum", user.getUserCertifNum());
		query.setParameter("userEmail", user.getUserEmail());
		query.setParameter("userCreationDate", user.getUserCreationDate());
		query.setParameter("userTotalLoginSeconds", user.getUserTotalLoginSeconds());
		query.setParameter("userId", user.getUserId());
		
		query.executeUpdate();
		tx.commit();
		HibernateUtils.closeSession();
	}

	@Override
	public List<Passenger> findAllPassengers(User user) {
		Session session = HibernateUtils.getSession();
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		
		//TODO 因为登录时总报null异常，此处先处理一下
		if(user != null){
			passengers = 
				session.createQuery(
						"from Passenger p where p.refUserId=" + 
							user.getUserId()).list();
		}

		HibernateUtils.closeSession();
		
		return passengers;
	}

	@Override
	public void updatePasswd(User user) throws SQLException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "update User u set " +
					" u.userPassword = :userPassword " +
					" where u.userId = :userId ";
		
		Query query = session.createQuery(hql);
		query.setString("userPassword", user.getUserPassword());
		query.setInteger("userId", user.getUserId());
		
		query.executeUpdate();
		
		tx.commit();
		
		HibernateUtils.closeSession();
		
	}
}
