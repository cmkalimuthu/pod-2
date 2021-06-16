package com.prototype.auditchecklist.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 		   This class contains test cases for the AuthResponse model class
 *         which are written using junit and mockito
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

	@Mock
	AuthResponse authResponse=new AuthResponse();
	/**
	 * 
	 * test the allArgsConstructor of AuthResponse model class
	 */
	@Test
	public void testAuthResponseConstructor()
	{
		
		AuthResponse response=new AuthResponse("audit1", true);
		assertEquals( "audit1" ,  response.getUid() );
	}
	/**
	 * 
	 * test the AuthResponse model class getter
	 */
	@Test
	public void testUid()
	{
		
		authResponse.setUid("audit1");
		assertEquals("audit1" , authResponse.getUid() );
	}
	/**
	 * 
	 * test the AuthResponse model class getter
	 */

	@Test
	public void testIsValid()
	{
	
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
	}
	/**
	 * 
	 * test the AuthResponse model class toString
	 */
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
