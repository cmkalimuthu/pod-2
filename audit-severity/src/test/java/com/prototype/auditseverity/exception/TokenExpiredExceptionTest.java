package com.prototype.auditseverity.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test class for TokenExpiredException
 */

@RunWith(SpringRunner.class)
@ContextConfiguration 
public class TokenExpiredExceptionTest {

	@Mock
	TokenExpiredException tokenExpiredException;
	
	/*
	 * to test assertNotNull TokenExpiredException
	 */
	
	@Test
	public void contextLoads() {
		assertNotNull(tokenExpiredException);
	}
	
	/*
	 * to test the constructor of TokenExpiredException
	 */
	
	@Test 
	public void testConstructor() {
		assertNotNull(new TokenExpiredException("Exception"));
	}

}
