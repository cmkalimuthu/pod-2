package com.prototype.auditseverity;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test class for AuditSeverityApplication
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuditSeverityApplicationTests {

	@Mock
	AuditSeverityApplication auditSeverityApplication=new AuditSeverityApplication();
	
	@Test
	public void contextLoads() {
		assertNotNull(auditSeverityApplication);
	}
}
