package org.itstep.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	private static SessionFactory createSessionFactory() {
      Configuration configuration = new Configuration().configure();
//      Configuration configuration = new Configuration();
      
//      configuration.addAnnotatedClass(EntityClass.class);
     
		return configuration.buildSessionFactory();
  }
}
