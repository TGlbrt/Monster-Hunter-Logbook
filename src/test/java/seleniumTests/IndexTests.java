package seleniumTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mhlogPOMpages.IndexPage;
import mhlogPOMpages.LoginPage;
import mhlogPOMpages.MonstersPage;

import myCategories.NonCRUD;

@Category(NonCRUD.class)
public class IndexTests {
	WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	MonstersPage monstersPage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/tom/Desktop/chromedriver");
		driver = new ChromeDriver();
		indexPage = new IndexPage(driver);
		loginPage = new LoginPage(driver);
		monstersPage = new MonstersPage(driver);
		driver.get("http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/");
	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void testIndexLocation() {
		assertEquals("text index location error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/",driver.getCurrentUrl());
	}
	
	@Test
	public void testIndexPageText() {
		String foundText = driver.findElement(By.xpath("//*[@id=\"about-greeting\"]")).getText();
		assertEquals("text index page text error",indexPage.getGreetingText(),foundText);
	}
	
	@Test
	public void testIndexHome() {
		indexPage.navigateToHome();
		assertEquals("test index home error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/index.html",driver.getCurrentUrl());
	}
	
	//@Test
	//public void testMonstersLocation() {
	//	indexPage.navigateToMonsters();
	//	assertEquals("test monsters location error",,)
	//}
	
	@Test
	public void testIndexToLogin() {
		indexPage.navigateToUser();
		assertEquals("test index to login page error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/login.html",driver.getCurrentUrl());
	}
	
	@Test
	public void testIndexToAbout() {
		indexPage.navigateToAbout();
		assertEquals("test index to about(index) page error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/index.html",driver.getCurrentUrl());
	}
	
}
