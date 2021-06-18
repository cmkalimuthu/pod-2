package com.prototype.auditchecklist.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.8 This class we are using as a response of error handling message.
 *          In the {@link GlobalErrorHandler} class we are using this
 *          {@link CustomErrorResponse} class as a return type that will be
 *          shown to the client whenever any kind of exception occurs. The
 *          fields of this class will be used to show this kind of response.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration

public class CustomErrorResponseTest {
	/**
	 * to test the no param constructor of CustomErrorResponse
	 */

	@Test
	public void testCustomErrorResponse() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		assertNotNull(customErrorResponse);
	}

	/**
	 * to test the all param constructor of CustomErrorResponse
	 */
	@Test
	public void testCustomErrorResponseParameterized() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertNotNull(customErrorResponse);

	}

	/**
	 * to test the ToStringMethod
	 */
	@Test
	public void testToStringMethod() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertEquals(customErrorResponse.toString(), customErrorResponse.toString());

	}

	@Test
	public void testGetStatus() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());

	}

	/**
	 * to test the getter setter of message
	 */

	@Test
	public void testGetMessage() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());

	}

	/**
	 * to test the getter setter of LocalDateTime
	 */
	@Test
	public void testSetLocalDateTime() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setTimestamp(LocalDateTime.now());

	}

	/**
	 * to test the getter setter of Status
	 */
	@Test
	public void testSetStatus() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);

	}

	/**
	 * to test the getter setter of message
	 */
	@Test
	public void testSetMessage() {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");

	}

}
