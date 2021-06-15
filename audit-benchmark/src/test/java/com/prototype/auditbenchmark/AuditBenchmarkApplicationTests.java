package com.prototype.auditbenchmark;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuditBenchmarkApplicationTests {

	@Mock
	AuditBenchmarkApplication auditBenchmarkApplication;
	
	@Test
	void contextLoads() {
		assertNotNull(auditBenchmarkApplication);

	}

}
