package com.prototype.auditbenchmark.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * Test AuthResponse class
 */
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthResponseTest {

	AuthResponse authResponse = new AuthResponse();

	/**
	 * Testing constructor
	 */
	@Test
	public void testConstructor() {
		log.info("start");
		AuthResponse response = new AuthResponse("name", true);
		assertEquals("name", response.getUid());
		log.info("end");
	}

	/**
	 * Testing setter for uid
	 */
	@Test
	public void testUid() {
		log.info("start");
		authResponse.setUid("name1");
		assertEquals("name1", authResponse.getUid());
		log.info("end");
	}

	/**
	 * Testing isValid setter
	 */
	@Test
	public void testIsValid() {
		log.info("start");
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
		log.info("end");
	}

}
