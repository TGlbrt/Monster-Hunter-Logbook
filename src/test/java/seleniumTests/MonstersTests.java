package seleniumTests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import mhlogPOMpages.IndexPage;
import mhlogPOMpages.LogPage;
import mhlogPOMpages.LoginPage;
import mhlogPOMpages.MonstersPage;

import myCategories.*;

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
		//System.setProperty("webdriver.chrome.driver", "D:\\SDev\\installLocation\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		
		indexPage = new IndexPage(driver);
		loginPage = new LoginPage(driver);
		monstersPage = new MonstersPage(driver);
		logPage = new LogPage(driver);
		driver.get("http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/");
		indexPage.navigateToUser();
		loginPage.register(username, password);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.goToMonsters();
	}
	
	@After
	public void teardown() {
		monstersPage.goToUserPage();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.deleteUser();
		driver.close();
	}
	
	@Category(NonCRUD.class)
	@Test
	public void testLocation() {
		assertEquals("test location error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/monsters.html",driver.getCurrentUrl());
	}
	
	@Category(Put.class)
	@Test
	public void testUpdateMonster() throws InterruptedException {
		monstersPage.addMonster(username, "rank", "weaknesses");
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPage.goToMonstersPage();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String updatedName = "This is a test";
		monstersPage.updateMonster(username, updatedName, "rank", "0", password);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPage.goToMonstersPage();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		assertEquals("test update monster error",username,monstersPage.getTableEntryValue(username));
	}
	
	@Category(Post.class)
	@Test
	public void testAddMonster() throws InterruptedException {
		monstersPage.addMonster(username, "rank", "weaknesses");
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPage.goToMonstersPage();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		assertEquals("test add monster error",username,monstersPage.getTableEntryValue(username));
	}
	
}
