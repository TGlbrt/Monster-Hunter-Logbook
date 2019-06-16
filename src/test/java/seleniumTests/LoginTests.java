package seleniumTests;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTests {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/tom/Desktop/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testIndexLocation() {
		
	}
}
