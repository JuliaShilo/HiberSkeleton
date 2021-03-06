package org.itstep.dao;

import java.util.Properties;

import lombok.Value;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.itstep.entity.Cart;
import org.itstep.entity.Item;
import org.itstep.entity.Order;
import org.itstep.entity.User;

public class HibernateFactory {

	private static SessionFactory sessionFactory;


	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
            try {
            	Configuration configuration = new Configuration();

        		Properties properties = new Properties();

//        		properties.setProperty("hibernate.connection.driverClassName", "org.h2.Driver");
//        		properties.setProperty("hibernate.connection.url", "jdbc:h2:~/step_qa_2");
//        		properties.setProperty("hibernate.connection.username", "julia");
//        		properties.setProperty("hibernate.connection.password", "123456");
//        		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        		properties.setProperty("hibernate.show_sql", "true");
////        		properties.setProperty("hibernate.format_sql", "true");


				properties.setProperty("hibernate.connection.driverClassName", "org.postgresql.Driver");
				properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/step-qa-2");
				properties.setProperty("hibernate.connection.username", "postgres");
				properties.setProperty("hibernate.connection.password", "feeder456");
				properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
				properties.setProperty("hibernate.hbm2ddl.auto", "update");
				properties.setProperty("hibernate.show_sql", "true");
				properties.setProperty("hibernate.format_sql", "true");


				configuration.addProperties(properties);

        		configuration.addAnnotatedClass(Item.class);
        		configuration.addAnnotatedClass(User.class);
        		configuration.addAnnotatedClass(Order.class);
        		configuration.addAnnotatedClass(Cart.class);
        		
        		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        				.applySettings(configuration.getProperties()).build();
        		
        		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e) {
            	e.printStackTrace();
            }
		}
		return sessionFactory;
	}
}
