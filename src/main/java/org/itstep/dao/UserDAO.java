package org.itstep.dao;

import java.util.List;

import org.hibernate.Session;
import org.itstep.entity.User;

public class UserDAO extends EntityDAO<User>{

	@Override
	public void save(User entity) {
		Session session = super.getSession();
        session.getTransaction().begin();
        session.save(entity);
//        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();		
	}

	@Override
	public User findOne(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

}
