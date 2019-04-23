package org.itstep.dao;

import org.hibernate.Session;

public abstract class EntityDAO<T> {
	
	public static Session getSession() {
		return HibernateFactory.getSessionFactory().openSession();
	}
	
	public abstract T save(T entity);
	
	public abstract T findOne(T entity);
	
	public abstract T update(T entity);
	
	public abstract void delete(T entity);
}
