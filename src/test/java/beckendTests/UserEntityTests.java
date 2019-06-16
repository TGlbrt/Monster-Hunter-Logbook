package beckendTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logger.User;

public class UserEntityTests {
	User testUser;
	
	@Before
	public void setup() {
		testUser = new User();
		testUser.setId(404);
		testUser.setUsername("testEntityUser");
		testUser.setPassword("JUnitTest");
	}
	
	@Test
	public void getIdTest() {
		int expectedId = 404;
		assertEquals("get id test error",expectedId,testUser.getId());
	}
	
	@Test
	public void getUsernameTest() {
		String expectedUsername = "testEntityUser";
		assertEquals("get username test error",expectedUsername,testUser.getUsername());
	}
	
	@Test
	public void getPasswordTest() {
		String expectedPassword = "JUnitTest";
		assertEquals("get password test error",expectedPassword,testUser.getPassword());
	}
	
	@Test
	public void setIdTest() {
		int setId = 1234;
		testUser.setId(setId);
		assertEquals("set id test error",setId,testUser.getId());
	}
	
	@Test
	public void setUsernameTest() {
		String setUsername = "setEntityUsername";
		testUser.setUsername(setUsername);
		assertEquals("set username test error",setUsername,testUser.getUsername());
	}
	
	@Test
	public void setPasswordTest() {
		String setPassword = "setEntityPassword";
		testUser.setPassword(setPassword);
		assertEquals("set password test error",setPassword,testUser.getPassword());
	}
}
