package com.prototype.auditauthentication.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;



@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class LoginFailedExceptionTest {


	@Mock
	Environment env;
	@Test
	public void testInvalidAuthorizationException() {

		LoginFailedException loginFailedException = new LoginFailedException("Invalid Credentials");
		assertNotNull(loginFailedException);


	}


}
