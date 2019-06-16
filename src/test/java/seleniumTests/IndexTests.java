package seleniumTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mhlogPOMpages.IndexPage;

public class IndexTests {
	WebDriver driver;
	IndexPage indexPage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/tom/Desktop/chromedriver");
		driver = new ChromeDriver();
		indexPage = new IndexPage(driver);
		driver.get("http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/");
	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void testIndexLocation() {
		assertEquals("text index location error","Welcome to the monster hunter logbook",indexPage.getGreetingText());
	}
	
	@Test
	public void testIndexHome() {
		indexPage.navigateToHome();
		assertEquals("test index home error","Welcome to the monster hunter logbook",indexPage.getGreetingText());
	}
	
	
	
	
}
