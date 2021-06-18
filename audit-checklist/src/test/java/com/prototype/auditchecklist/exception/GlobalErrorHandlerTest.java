package com.prototype.auditchecklist.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class GlobalErrorHandlerTest {

	@InjectMocks
	GlobalExceptionHandler handler;

	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}

	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(handler.handelFeignProxyException(new FeignProxyException()));
	}

}
