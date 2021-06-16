package com.prototype.auditauthentication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class AuditAuthenticationApplicationTests {

	@Mock
	AuditAuthenticationApplication application;

	@Test
	void contextLoads() {
		assertNotNull(application);
	}

}


