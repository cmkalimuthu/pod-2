package com.prototype.auditbenchmark;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 
  * This class contains test cases for the AuditBenchmarkApplication application class.
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuditBenchmarkApplicationTests {

	@Mock
	AuditBenchmarkApplication auditBenchmarkApplication=new AuditBenchmarkApplication();
	
	@Test
	public void contextLoads() {
		assertNotNull(auditBenchmarkApplication);

	}

}
