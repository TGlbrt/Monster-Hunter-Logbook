package seleniumTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mhlogPOMpages.IndexPage;
import mhlogPOMpages.LogPage;
import mhlogPOMpages.LoginPage;
import mhlogPOMpages.MonstersPage;

public class MonstersTests {
	WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	MonstersPage monstersPage;
	LogPage logPage;
	String username = "Auto-Test";
	String password = "Auto-Test";
	
	@Before
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "/home/tom/Desktop/chromedriver");//linux location
		System.setProperty("webdriver.chrome.driver", "D:\\SDev\\installLocation\\chromedriver.exe");
		driver = new ChromeDriver();
		indexPage = new IndexPage(driver);
		loginPage = new LoginPage(driver);
		monstersPage = new MonstersPage(driver);
		logPage = new LogPage(driver);
		driver.get("http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/");
		indexPage.navigateToUser();
		loginPage.register(username, password);
		loginPage.login(username, password);
		loginPage.goToMonsters();
	}
	
	@After
	public void teardown() {
		monstersPage.goToUserPage();
		loginPage.login(username, password);
		loginPage.deleteUser();
		driver.close();
	}
	
	/*
	 * @Test public void testAddMonster() { monstersPage.addMonster("test-monster",
	 * "12", "Fire:2");
	 * 
	 * }
	 */
	
	@Test
	public void testUpdateMonster() {
		monstersPage.updateMonster(monstersPage.firstEntryValue(), username, monstersPage.firstEntryRankValue(), "0", password);
		monstersPage.goToMonstersPage();
		assertEquals("test update monster error",username,monstersPage.firstEntryValue());
	}
	
}
