package com.prototype.auditseverity.pojo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/*
This POJO class is for CustomErrorResponseTest
*/

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class CustomErrorResponseTest {

	
	private CustomErrorResponse customErrorResponse;
	
	/*
	 * Here this method used to instantiate CustomErrorResponse before test method calls
	 */
	@Before
	public void beforeTestMethod() {
		customErrorResponse = new CustomErrorResponse();
	}
	
	/*
	 * Here this method used to given messages after test method called
	 */
	@After
	public void afterTestMethod() {
		log.info("Test Done Successfuly !");
	}
	
	/*
	 * Here this method used to test assertNotNull
	 */
	@Test
	public void testCustomErrorResponse() {
		assertNotNull(customErrorResponse);
	}
	
	/*
	 * Here this method used to test the parameterized constructor
	 */
	@Test
	public void testParameterizedConstructor() {
	      CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK,
				"Message","reason");
		assertNotNull(customErrorResponse);
	}

	/*
	 * Here this method used to test the status by get and set method
	 */
	@Test
	public void testGetStatus() {
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());
    }

	/*
	 * Here this method used to test the message by get and set method
	 */
	@Test
	public void testGetMessage() {
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());
	}
	
	/*
	 * Here this method used to test the localDateTime by set method
	 */
	@Test
	public void testSetLocalDateTime() {
        customErrorResponse.setTimestamp(LocalDateTime.now());
    }
	  
	
	
	

}
