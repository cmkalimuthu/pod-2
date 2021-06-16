package com.prototype.auditseverity;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Test class for AuditSeverityApplication
 */

@SpringBootTest
class AuditChecklistApplicationTests {

	@Mock
	AuditSeverityApplication auditSeverityApplication;
	
	@Test
	void contextLoads() {
		assertNotNull(auditSeverityApplication);
	}
}
