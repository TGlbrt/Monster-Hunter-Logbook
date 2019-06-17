package beckendTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logger.Log;

public class LogEntityTests {
	Log testLog;
	
	@Before
	public void setup() {
		testLog = new Log();
		testLog.setId(406);
		testLog.setMonsterName("JUnitMonster");
		testLog.setUserName("JUnitUser");
		testLog.setTime("12:34:56");
		testLog.setNumberOfPlayers(0);
	}

	@Test
	public void instansiationTest() {
		assertEquals("log instanciaton error",testLog.getClass(),Log.class);
	}
	
	@Test
	public void getIdTest() {
		int expectedId = 406;
		assertEquals("get log id test error",expectedId,testLog.getId());
	}
	
	@Test
	public void getMonsterNameTest() {
		String expectedMonsterName = "JUnitMonster";
		assertEquals("get log monster name test error",expectedMonsterName,testLog.getMonsterName());
	}
	
	@Test
	public void getUserNameTest() {
		String expectedUserName = "JUnitUser";
		assertEquals("get log user name test error",expectedUserName,testLog.getUserName());
	}
	
	@Test
	public void getTimeTest() {
		String expectedTime = "12:34:56";
		assertEquals("get log time test error",expectedTime,testLog.getTime());
	}
	
	@Test
	public void getNumberOfPlayersTest() {
		int expectedNumberOfPlayers = 0;
		assertEquals("get log number of players error",expectedNumberOfPlayers,testLog.getNumberOfPlayers());
	}
	
	@Test
	public void setIdTest() {
		int expectedId = 407;
		testLog.setId(expectedId);
		assertEquals("get log id test error",expectedId,testLog.getId());
	}
	
	@Test
	public void setMonsterNameTest() {
		String expectedMonsterName = "MonsterJUnit";
		testLog.setMonsterName(expectedMonsterName);
		assertEquals("set log monster name test error",expectedMonsterName,testLog.getMonsterName());
	}
	
	@Test
	public void setUserNameTest() {
		String expectedUserName = "JUnitOfUser";
		testLog.setUserName(expectedUserName);
		assertEquals("set log user name test error",expectedUserName,testLog.getUserName());
	}
	
	@Test
	public void setTimeTest() {
		String expectedTime = "45:43:21";
		testLog.setTime(expectedTime);
		assertEquals("set log time test error",expectedTime,testLog.getTime());
	}
	
	@Test
	public void setNumberOfPlayersTest() {
		int expectedNumberOfPlayers = -1;
		testLog.setNumberOfPlayers(expectedNumberOfPlayers);
		assertEquals("set log number of players error",expectedNumberOfPlayers,testLog.getNumberOfPlayers());
	}
}

