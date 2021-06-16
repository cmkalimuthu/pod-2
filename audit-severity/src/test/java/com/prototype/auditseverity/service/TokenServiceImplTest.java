package com.prototype.auditseverity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditseverity.feignclients.AuthClient;
import com.prototype.auditseverity.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class TokenServiceImplTest {
	
	@InjectMocks
	TokenServiceImpl tokenService;
	@Mock
	AuthClient authClient;
	
	@Mock
	AuthResponse authResponse;
	
	@Mock
	ResponseEntity<AuthResponse> authResponseentity;
	
	/*
	 * Here this method used to test token validity when token is valid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		log.info("start");
		authResponseentity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true),HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(authResponseentity);
        assertEquals(true, tokenService.checkTokenValidity("token"));
        log.info("end");

	}
	
	/*
	 * Here this method used to test NullPointerException
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {
        assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));

	}
	
	/*
	 * Here this method used to test token validity when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		log.info("start");
		authResponseentity = new ResponseEntity<AuthResponse>(new AuthResponse(null,false),HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(authResponseentity);
		assertEquals(false, tokenService.checkTokenValidity("token"));
		log.info("end");

	}


}
