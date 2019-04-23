package org.itstep.dao;

import java.util.List;

import org.hibernate.Session;

public abstract class EntityDAO<T> {
	
	public static Session getSession() {
		return HibernateFactory.getSessionFactory().openSession();
	}
	
	public abstract void save(T entity);
	
	public abstract T findOne(T entity);

	public abstract List<T> findAll();
	
	public abstract void update(T entity);
	
	public abstract void delete(T entity);
}
