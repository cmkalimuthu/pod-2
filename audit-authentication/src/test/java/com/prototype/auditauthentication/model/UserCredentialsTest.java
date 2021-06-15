package com.prototype.auditauthentication.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author POD5
 * @version 1.8
 * @apiNote This class is used to hold the login credentials which will be sent
 *          by the user in the request body for getting the token
 *
 */
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();

	@Mock
	Environment env;
	@Test
	public void testUserLoginCredentialAllConstructor() {
		UserCredentials credential = new UserCredentials("audit1", "password1");
		assertEquals(credential.getUserId(), "audit1");
	}

	@Test
	public void testGetUid() {

		loginCredential.setUserId("audit1");
		assertEquals(loginCredential.getUserId(), "audit1");
	}

	@Test
	public void testUserPassword() {
		loginCredential.setPassword("audit1");
		assertEquals(loginCredential.getPassword(), "audit1");

	}

	@Test
	public void testoString() {

		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);

	}

}
