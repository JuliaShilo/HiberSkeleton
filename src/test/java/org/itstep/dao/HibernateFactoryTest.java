package org.itstep.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class HibernateFactoryTest {

	@Test
	public void testGetSessionFactory() {
		SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
		assertNotNull(sessionFactory);
		
		Session session = sessionFactory.openSession();
		assertNotNull(session);
		
		session.close();
	}

}
