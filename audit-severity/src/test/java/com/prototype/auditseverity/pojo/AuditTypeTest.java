package com.prototype.auditseverity.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
This POJO class is for AuditTypeTest
*/

@RunWith(SpringRunner.class)
@ContextConfiguration 
public class AuditTypeTest {

	AuditType auditType = new AuditType();
	

	/*
	 * Here this method used to test the parameterized constructor
	 */
	@Test
	public void testAuditTypeConstructor() {
		AuditType type = new AuditType("audittype");
		assertEquals(type.getAuditType(), "audittype");
	}
	
	/*
	 * Here this method used to test the type of audit by get and set method
	 */
	@Test
	public void testGetSetAuditType() {
		auditType.setAuditType("audittype");
		assertEquals(auditType.getAuditType(), "audittype");
	}
	
	/*
	 * Here this method used to test the toString method
	 */
	@Test
	public void testoString() {
		String string = auditType.toString();
		assertEquals(auditType.toString(), string);
	}

}
