package com.prototype.auditauthentication.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditauthentication.exception.LoginFailedException;
import com.prototype.auditauthentication.model.AuthResponse;
import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.model.UserCredentials;
import com.prototype.auditauthentication.repository.ManagerRepo;
import com.prototype.auditauthentication.service.JwtUtil;
import com.prototype.auditauthentication.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	ManagerService managerdetailservice;

	@Mock
	ManagerRepo managerservice;
	
	@Test
	public void loginTest() throws Exception {
		
		UserCredentials user = new UserCredentials("admin", "admin");
		
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), user.getPassword(), new ArrayList<>());
		
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		
		ResponseEntity<?> login = authController.login(user);
		assertEquals( 200 , login.getStatusCodeValue() );
	}

	@Test(expected = LoginFailedException.class)
	public void invalidLoginTest() throws LoginFailedException, Exception {

		UserCredentials user = new UserCredentials("admin", "admin");
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), "admin11", new ArrayList<>());
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		when(authController.login(user)).thenThrow(new LoginFailedException());
	}

	@Test
	public void validateTestValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("admin");
		ProjectManager user1 = new ProjectManager("admin", "admin", "admin");
		Optional<ProjectManager> data = Optional.of(user1);
		when(managerservice.findById("admin")).thenReturn(data);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("true"), true);
		
	}

	@Test
	public void validateTestInValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals( true ,  validity.getBody().toString().contains("false") );
	}
}
