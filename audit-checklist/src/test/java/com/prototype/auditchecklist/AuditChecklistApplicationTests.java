package com.prototype.auditchecklist;
/**
 * 
 * Test class for AuditManagementAuthenticationApplication
 *
 */

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditChecklistApplicationTests {

	@Mock
	AuditChecklistApplication auditChecklistApplication=new AuditChecklistApplication();
	
	@Test
	public void contextLoads() {
		assertNotNull(auditChecklistApplication);
	}
}
