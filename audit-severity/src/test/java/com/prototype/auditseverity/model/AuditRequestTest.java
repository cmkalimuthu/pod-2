package com.prototype.auditseverity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/*
 * This is a model test class auditRequestTest
 * which is used to store the data as a relational model
 * the request given is stored in this model class
 */
public class AuditRequestTest {

	private AuditRequest auditRequest;
	
	/*
	 * Here this method used to instantiate AuditRequest before test method calls
	 */
	@Before
	public void setup() {
		auditRequest = new AuditRequest();
	}
	
	/*
	 * Here this method used to test the request Id by get and set method
	 */
	@Test
	public void testGetRequestId() {
		assertEquals(0, auditRequest.getRequestId());
	}
	
	/*
	 * Here this method used to test the name of the project by get and set method
	 */
	@Test
	public void testGetSetProjectName() {
		auditRequest.setProjectName("Name1");
		assertEquals("Name1", auditRequest.getProjectName());
	}
	
	/*
	 * Here this method used to test the name of the manager by get and set method
	 */
	@Test
	public void testGetSetProjectManagerName() {
		auditRequest.setManagerName("Name2");
		assertEquals("Name2", auditRequest.getManagerName());
	}
	
	/*
	 * Here this method used to test the name of the owner by get and set method
	 */
	@Test
	public void testGetSetOwnerName() {
		auditRequest.setOwnerName("Name3");
		assertEquals("Name3", auditRequest.getOwnerName());
	}
	
	
}
