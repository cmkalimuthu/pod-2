package com.prototype.auditseverity.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/*
 * This is a model test class auditDetailsTest
 * which is used to store the data as a relational model
 * the details given is stored in this model class
 */

public class AuditDetailsTest {

	private AuditDetails auditDetails;
	
	/*
	 * Here this method used to instantiate AuditDetails before test method calls
	 */
	@Before
	public void testMethod() {
		auditDetails = new AuditDetails();
	}
	
	/*
	 * Here this method used to test the type of audit by get and set method
	 */
	@Test
	public void testGetSetAuditType() {
		auditDetails.setAuditType("Internal");
		assertEquals("Internal", auditDetails.getAuditType());
	}
	
	/*
	 * Here this method used to test the date of audit by get and set method
	 */
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		auditDetails.setAuditDate(date);
		assertEquals(date, auditDetails.getAuditDate());
	}
	
	/*
	 * Here this method used to test the id of audit by get and set method
	 */
	@Test
	public void testGetAuditId() {
		assertEquals(0, auditDetails.getAuditId());
	}
}
