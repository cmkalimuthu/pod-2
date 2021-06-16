package com.prototype.auditchecklist.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
/**
 * 
 *  	   This class contains test cases for the AuditType class
 *         which are written using junit and mockito
 */
public class AuditTypeTest {

	@Mock
	AuditType auditType ;
	/**
	 * Test the AuditType Setter
	 */
	
	@Test
	public void testSetAuditType() {
		auditType=new AuditType();
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}
	/**
	 * Test the AuditType Getter
	 */
	@Test
	public void testGetAuditType() {
		auditType=new AuditType();
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}
	/**
	 * Test the AuditType All Args Constructor
	 */
	@Test
	public void testAuditTypeConstructor() {
		auditType=new AuditType();
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}
	/**
	 * Test the AuditType toString
	 */
	@Test
	public void testAuditTypeToString() {
		auditType=new AuditType();
		String s = new AuditType().toString();
		assertEquals(s,auditType.toString());
				
	}
	
	
}
