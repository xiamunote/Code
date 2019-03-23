package dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pojo.Userinfo;

import factory.HibernateSessionFactory;

public class LoginDao {
	public boolean checkLogin(Userinfo user){
		boolean flag=false;
		Session session=HibernateSessionFactory.getSession();
		String hql="from Userinfo a where a.username=:b and a.password=:c and a.ismanager=:d";
		Query query=session.createQuery(hql);
		
		query.setString("b",user.getUsername());
		query.setString("c",user.getPassword());
		query.setString("d",user.getIsmanager());
		
		List list=query.list();
		if(list.size()>0){
			flag=true;
		}
		session.close();
		return flag;
		
	}
	
	public Userinfo selectidinfo(Userinfo user){
		Session session=HibernateSessionFactory.getSession();
		String hql="from Userinfo u where u.username=:a and u.password=:b";
		Query query=session.createQuery(hql);
		
		query.setString("a", user.getUsername());
		query.setString("b", user.getPassword());
		
		return (Userinfo)query.uniqueResult();
	}
}
