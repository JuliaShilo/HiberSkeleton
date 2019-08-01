package org.itstep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.entity.Profile;
import org.itstep.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UserDAOTest {
	
	static List<User> testUsers = new ArrayList<User>();

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		User user = new User(33, "test_login", "pass", "e-mail@ukr.com", "Julia", "Shilo", Profile.CLIENT);
		UserDAO.saveOrUpdate(user);
		testUsers.add(user);
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		for (User user : testUsers) {
			UserDAO.delete(user);
		}
	}

	@Test
	public void testSaveOrUpdateAndFindAndDelete() {
		
		User testUser = UserDAO.findOne(testUsers.get(0).getId());
//		assertNull(testUser);
			
		UserDAO.saveOrUpdate(testUsers.get(0));
		testUser = UserDAO.findOne(testUsers.get(0).getId());
		assertNotNull(testUser);
		assertEquals("e-mail@ukr.com", testUser.getEmail());
		
		UserDAO.delete(testUsers.get(0));
		
		testUser = UserDAO.findOne(testUsers.get(0).getId());
		assertNull(testUser);
	}

	@Test
	public void testFindAll() {

		User user1 = new User(45, "test_login", "pass", "e-mail@ukr.com", "Julia", "Shilo", Profile.CLIENT);
		User user2 = new User(46, "test_login", "pass", "e-mail@ukr.com", "Julia", "Shilo", Profile.CLIENT);
		User user3 = new User(47, "test_login", "pass", "e-mail@ukr.com", "Julia", "Shilo", Profile.CLIENT);
		
		testUsers.add(user1);
		testUsers.add(user2);
		testUsers.add(user3);
		
		UserDAO.saveOrUpdate(user1);
		UserDAO.saveOrUpdate(user2);
		UserDAO.saveOrUpdate(user3);
		
		List<User> users = UserDAO.findAll();
		assertNotNull(users);
		assertTrue(users.size() >= 3);
		
	}

}
