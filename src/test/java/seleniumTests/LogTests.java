package seleniumTests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import mhlogPOMpages.IndexPage;
import mhlogPOMpages.LogPage;
import mhlogPOMpages.LoginPage;
import mhlogPOMpages.MonstersPage;

public class LogTests {
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
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
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
		monstersPage.goToLog();
	}
	
	@After
	public void teardown() {
		logPage.gotToUser();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		loginPage.deleteUser();
		driver.close();
	}
	
	@Test
	public void testLocation() {
		assertEquals("log page test location error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/log.html",driver.getCurrentUrl());
	}
	
	@Test
	public void testAddLog() {
		logPage.addLog(username, "1");
		assertEquals("log page test add log error",username,logPage.firstTimeEntryValue());
		logPage.deleteLog();
	}
	
	@Test
	public void testUpdateLog() throws InterruptedException {
		logPage.addLog(username, "1");
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String updatedTime = "12:34:56";
		String updatedPlayers = "2";
		Thread.sleep(1000);
		logPage.updateLog(updatedTime, updatedPlayers);
		assertEquals("log page test update log error",updatedTime,logPage.firstTimeEntryValue());
		logPage.deleteLog();
	}
	
}
