package mhlogPOMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonstersPage {
	//@FindBy(xpath=("/html/body/div[1]/p[1]"))
	//WebElement loginPageUsernameParagraph;
	
	WebDriver driver;
	
	public MonstersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
