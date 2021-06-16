package com.prototype.auditseverity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
 * This is a model test class auditResponseTest
 * which is used to store the data as a relational model
 * the response given is stored in this model class
 */

public class AuditResponseTest {

	private AuditResponse auditResponse;
	
	/*
	 * Here this method used to instantiate AuditResponse before test method calls
	 */
	@Before
	public void setup() {
		auditResponse = new AuditResponse();
	}
	
	/*
	 * Here this method used to test the project Execution by get and set method
	 */
	@Test
	public void testGetSetProjectExecutionStatus() {
		auditResponse.setExecutionStatus("GREEN");
		assertEquals("GREEN", auditResponse.getExecutionStatus());
	}
	
	/*
	 * Here this method used to test the remedial action duration by get and set method
	 */
	@Test
	public void testGetSetRemedialActionDuration() {
		auditResponse.setDuration("None");
		assertEquals("None", auditResponse.getDuration());
	}
	
	/*
	 * Here this method used to test the response id by get and set method
	 */
	@Test
	public void testGetResponseId() {
		assertEquals(0, auditResponse.getResponseId());
	}
}
