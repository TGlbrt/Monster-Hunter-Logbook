package seleniumTests;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mhlogPOMpages.IndexPage;
import mhlogPOMpages.LoginPage;
import myCategories.*;

public class LoginTests {
	WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	String username = "Auto-Test";
	String password = "Auto-Test";
	
	@Before
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "/home/tom/Desktop/chromedriver");//linux location
		System.setProperty("webdriver.chrome.driver", "D:\\SDev\\installLocation\\chromedriver.exe");
		driver = new ChromeDriver();
		indexPage = new IndexPage(driver);
		loginPage = new LoginPage(driver);
		driver.get("http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/");
		indexPage.navigateToUser();
	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
	@Category(NonCRUD.class)
	@Test
	public void testLoginLocation() {
		assertEquals("login location error","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/login.html",driver.getCurrentUrl());
	}
	
	@Category(Post.class)
	@Test
	public void testRegister() throws InterruptedException {
		loginPage.register(username, password);
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		assertEquals("login test register error","hello " + username,loginPage.getLoginMessage());
		loginPage.deleteUser();
	}
	
	/*
	 * @Category(Put.class)
	 * 
	 * @Test public void testUpdate() throws InterruptedException {
	 * loginPage.register(username, password);
	 * driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	 * loginPage.login(username, password);
	 * driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	 * Thread.sleep(1500); String updatedUsername = "Auto-Test-Updated";
	 * loginPage.updateUser(updatedUsername);
	 * driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	 * assertEquals("login test update user","hello " +
	 * updatedUsername,loginPage.getLoginMessage()); loginPage.deleteUser(); }
	 */
	
	@Category(Get.class)
	@Test
	public void testLogout() {
		loginPage.register(username, password);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		loginPage.logoutUser();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		assertEquals("login test update user","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/index.html" ,driver.getCurrentUrl());
		indexPage.navigateToUser();
		loginPage.login(username, password);
		loginPage.deleteUser();
	}
	
	@Category(Delete.class)
	@Test
	public void testDelete() throws InterruptedException {
		loginPage.register(username, password);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		loginPage.login(username, password);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		loginPage.deleteUser();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		Thread.sleep(1000);
		assertEquals("login test delete user","http://127.0.0.1:8080/TGlbrt.mhlogbook-0.1/index.html" ,driver.getCurrentUrl());
	}
}
