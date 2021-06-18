package com.prototype.auditseverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
This POJO class is for AuditBenckmarkTest
*/

public class AuditBenchmarkTest {

	private AuditBenchmark auditBenchmark;
	
	/*
	 * Here this method used to instantiate AuditBenchMark before test method calls
	 */
	@Before
	public void testMethod() {
		auditBenchmark = new AuditBenchmark();
	}
	
	/*
	 * Here this method used to test the type of audit by get and set method
	 */
	@Test
	public void testGetSetAuditType() {
		auditBenchmark.setAuditType("Internal");
		assertEquals("Internal", auditBenchmark.getAuditType());
	}
	
	/*
	 * Here this method used to test the no of NO's by get and set method
	 */
	@Test
	public void testGetSetNoOfNos() {
		auditBenchmark.setNoOfnos(12);
		assertEquals(12, auditBenchmark.getNoOfnos());
	}
}
