package org.itstep.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.itstep.entity.User;

public class UserDAO{
	
	private static final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
	
	public static void saveOrUpdate(User user){
		Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();		
	}
	
	public static User findOne(Integer id){
		Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        User userFromDB = (User)session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return userFromDB;
	}

	public static List<User> findAll(){
		Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        
        String sql = "SELECT * FROM users";
              
        List<User> result = session.createNativeQuery(sql).getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
	}
	
	public static void delete(User user) {
		Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
	}
	
}
