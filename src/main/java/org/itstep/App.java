package org.itstep;

import org.itstep.dao.UserDAO;
import org.itstep.entity.Profile;
import org.itstep.entity.User;

public class App {
	public static void main(String[] args) {
		User user = new User("test_login", "pass", "e-mail@ukr.com", "Alex", "Ignatenko", Profile.CLIENT);
		UserDAO.saveOrUpdate(user);
	}
}
