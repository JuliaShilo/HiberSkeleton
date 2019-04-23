package org.itstep.dao;

import java.util.Properties;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.entity.Cart;
import org.itstep.entity.Item;
import org.itstep.entity.Order;
import org.itstep.entity.User;


public class HibernateFactory {

	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
//		Configuration configuration = new Configuration().configure();
//
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
				
		properties.setProperty("hibernate.connection.driverClassName", "org.h2.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:h2:~/e-store2");
		properties.setProperty("hibernate.connection.username", "alex");
		properties.setProperty("hibernate.connection.password", "pass");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		configuration.addProperties(properties);

		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Cart.class);

		return configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
