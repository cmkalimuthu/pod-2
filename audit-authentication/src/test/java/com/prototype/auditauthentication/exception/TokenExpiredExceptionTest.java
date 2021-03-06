package com.prototype.auditauthentication.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration 
@Slf4j
public class TokenExpiredExceptionTest {

	@Mock
	TokenExpiredException handler;
	
	@Test
	public void contextLoads() {
		log.info("start");
		assertNotNull(handler);
		log.info("end");
	}
	
	@Test 
	public void testConstructor() {
		log.info("start");
		assertNotNull(new TokenExpiredException("Exception"));
		log.info("end");
	}
}
