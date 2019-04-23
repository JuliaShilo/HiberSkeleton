package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.QueryHint;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.itstep.entity.User;

public class UserDAO{
	
	private static Session getSession() {
		return HibernateFactory.getSessionFactory().openSession();
	}
	
	public static void saveOrUpdate(User user){
		Session session = getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();		
	}
	
	public static User findOne(Integer id){
		Session session = getSession();
        session.getTransaction().begin();
        User userFromDB = (User)session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return userFromDB;
	}

	public static List<User> findAll(){
		Session session = getSession();
        session.getTransaction().begin();
        
        String sql = "SELECT * FROM users";
        List<User> result = session.createNativeQuery(sql).getResultList();
        return result;
	}
	
	public static void delete(User user) {
		Session session = getSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
	}
	
}
