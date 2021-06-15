package com.prototype.auditauthentication.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditauthentication.repository.ManagerRepo;

import lombok.extern.slf4j.Slf4j;

/**

 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JwtUtilTest {

	UserDetails userdetails;
	@Mock
	Environment env;

	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	ManagerRepo managerrepositary;

	@Test
	public void generateTokenTest() {

		when("$(expire.token)").thenReturn("30");
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);

	}

	@Test
	public void validateTokenTest() {

		userdetails = new User("admin", "admin", new ArrayList<>());
		when("$(expire.token)").thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);

	}

	@Test
	public void validateTokenWithNameTest() {

		userdetails = new User("admin", "admin", new ArrayList<>());
		when("$(expire.token)").thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken, userdetails);
		assertEquals(true, validateToken);

	}

	@Test
	public void validateTokenWithNameFalseTest() {

		userdetails = new User("admin", "admin", new ArrayList<>());
		UserDetails user1 = new User("admin1", "admin1", new ArrayList<>());
		when("$(expire.token)").thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken, user1);
		assertEquals(false, validateToken);

	}

}
