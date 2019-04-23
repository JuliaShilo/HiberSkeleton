package org.itstep.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.entity.Cart;
import org.itstep.entity.Item;
import org.itstep.entity.Order;
import org.itstep.entity.User;

public class HibernateFactory {

	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
//      Configuration configuration = new Configuration();

//		configuration.addAnnotatedClass(Item.class);
//		configuration.addAnnotatedClass(User.class);
//		configuration.addAnnotatedClass(Order.class);
//		configuration.addAnnotatedClass(Cart.class);

		return configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
