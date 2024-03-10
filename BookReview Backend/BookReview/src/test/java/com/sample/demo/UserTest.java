package com.sample.demo;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.User;
import com.service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userSevice;

	// successful addition
	@Test
	public void aAddUserTest() {
		User user = new User();
		user.setEmail("Sammy@gmail.com");
		user.setName("Sammy");
		user.setPassword("Sammy@2320");
		boolean isAdded = userSevice.addUser(user);
		assertTrue(isAdded);
	}

	// failed addition
	@Test
	public void bAddUserTest() {
		User user = new User();
		user.setEmail("Sammy@gmail.com");
		user.setName("Sammy");
		user.setPassword("Sammy@2320");
		boolean isAdded = userSevice.addUser(user);
		assertFalse(isAdded);
	}

	@Test
	public void cUpdateUserTest() {
		User user = new User();
		user.setEmail("Sammy@gmail.com");
		user.setName("Sammy");
		user.setPassword("Sammy@2320");
		boolean isAdded = userSevice.updateUser(user);
		assertTrue(isAdded);
	}

	// successful search
	@Test
	public void dGetUserByEmailTest() {
		Optional<User> user = userSevice.getUser("Sammy@gmail.com");
		assertNotNull(user);
	}

	// failed search
	@Test
	public void eGetUserByEmailTest() {
		Optional<User> user = userSevice.getUser("Sammydil@gmail.com");
		assertTrue(user.isEmpty());
	}

	// successful login
	@Test
	public void fValidUserLoginTest() {
		boolean isAuthenticated = userSevice.validateUser("Sammy@gmail.com", "Sammy@2320");
		assertTrue(isAuthenticated);
	}

	// failed login
	@Test
	public void gValidUserLoginTest() {
		boolean isAuthenticated = userSevice.validateUser("Sammy@gmail.com", "Sammy@230");
		assertFalse(isAuthenticated);
	}

	// successful delete
	@Test
	public void hDeleteUserByEmail() {
		boolean isDeleted = userSevice.deleteUser("Sammy@gmail.com");
		assertTrue(isDeleted);
	}

	// failed delete
	@Test
	public void iDeleteUserByEmail() {
		boolean isDeleted = userSevice.deleteUser("Sammy@gmail.com");
		assertFalse(isDeleted);
	}

}
