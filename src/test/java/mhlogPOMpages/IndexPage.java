package mhlogPOMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	@FindBy(xpath=("//*[@id=\"about-greeting\"]"))
	WebElement indexGreeting;
	
	@FindBy(xpath=("/html/body/nav/div/div/a"))
	WebElement navBarHome;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[2]/a"))
	WebElement navBarUser;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[1]/a"))
	WebElement navBarMonsters;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[3]/a"))
	WebElement navBarAbout;
	
	WebDriver driver;
	
	public IndexPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getGreetingText() {
		return indexGreeting.getText();
	}
	
	public void navigateToHome() {
		navBarHome.click();
	}
	
	public void navigateToMonsters() {
		navBarMonsters.click();
	}
	
	public void navigateToUser() {
		navBarUser.click();
	}
	
	public void navigateToAbout() {
		navBarAbout.click();
	}
	
}
