package com.prototype.auditseverity.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/*
This POJO class is for AuthResponseTest
*/

public class AuthResponseTest {

	private AuthResponse authResponse;
	
	@Before
	public void setup() {
		authResponse = new AuthResponse();
	}
	
	/*
	 * Here this method used to test the user id by get and set method
	 */
	@Test
	public void testGetSetUid() {
		authResponse.setUid("uid");
		assertEquals("uid", authResponse.getUid());
	}
	
	/*
	 * Here this method used to test if it is valid or not by get and set method
	 */
	@Test
	public void testValid() {
		authResponse.setValid(false);
		assertFalse(authResponse.isValid());
	}
}
