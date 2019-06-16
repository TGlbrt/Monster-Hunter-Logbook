package mhlogPOMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath=("/html/body/div[1]/p[1]"))
	WebElement loginPageUsernameParagraph;
	
	@FindBy(xpath=("//*[@id=\"usernameInput\"]"))
	WebElement loginPageUsernameTextBox;
	
	@FindBy(xpath=("//*[@id=\"passwordInput\"]"))
	WebElement loginPagePasswordTextBox;
	
	@FindBy(xpath=("//*[@id=\"login\"]"))
	WebElement loginPageLoginButton;
	
	@FindBy(xpath=("//*[@id=\"register\"]"))
	WebElement loginPageRegisterButton;
	
	@FindBy(xpath=("//*[@id=\"usernameInput\"]"))
	WebElement loginPageUpdateUserNameTextBox;
	
	@FindBy(xpath=("//*[@id=\"update\"]"))
	WebElement loginPageUpdateButton;
	
	@FindBy(xpath=("//*[@id=\"delete\"]"))
	WebElement loginPageDeleteButton;
	
	@FindBy(xpath=("//*[@id=\"logout\"]"))
	WebElement loginPageLogOutButton;
	
	@FindBy(xpath=("//*[@id=\"userLoginMessage\"]"))
	WebElement loginPageLoginMessage;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getUsernameParagraphText() {
		return loginPageUsernameParagraph.getText();
	}
	
	public void login(String username,String password) {
		loginPageUsernameTextBox.sendKeys(username);
		loginPagePasswordTextBox.sendKeys(password);
		loginPageLoginButton.click();
	}
	
	public void register(String username,String password) {
		loginPageUsernameTextBox.sendKeys(username);
		loginPagePasswordTextBox.sendKeys(password);
		loginPageRegisterButton.click();
		loginPageUsernameTextBox.clear();
		loginPagePasswordTextBox.clear();
	}
	
	public void updateUser(String username) {
		loginPageUsernameTextBox.sendKeys(username);
		loginPageUpdateButton.click();
	}
	
	public void deleteUser() {
		loginPageDeleteButton.click();
	}
	
	public void logoutUser() {
		loginPageLogOutButton.clear();
	}
	
	public String getLoginMessage() {
		loginPageLoginMessage = driver.findElement(By.xpath("//*[@id=\"userLoginMessage\"]"));
		return loginPageLoginMessage.getText();
	}
	
	
}