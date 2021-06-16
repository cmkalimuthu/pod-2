package com.prototype.auditseverity.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test class for FeignException
 */


@RunWith(SpringRunner.class)
@ContextConfiguration
public class FeignExceptionTest {

	/*
	 * to test for the invalid authorization exception
	 */
	
	@Test
	public void testInvalidAuthorizationException() {
		FeignProxyException feignException = new FeignProxyException();
		assertNotNull(feignException);
	}
}
