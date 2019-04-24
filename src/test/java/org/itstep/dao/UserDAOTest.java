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
		User user = new User(1, "test_login", "pass", "e-mail@ukr.com", "Alex", "Ignatenko", Profile.CLIENT);
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
		assertNull(testUser);
			
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
//		fail("Not yet implemented");
	}

}
