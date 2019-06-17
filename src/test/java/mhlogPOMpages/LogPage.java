package mhlogPOMpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage {

	@FindBy(xpath=("//*[@id=\"logs-table\"]"))
	WebElement logsPageLogTable;
	
	@FindBy(xpath=("//*[@id=\"input-time\"]"))
	WebElement logsPageInputTime;
	
	@FindBy(xpath=("//*[@id=\"input-number_of_players\"]"))
	WebElement logsPageNoOfPlayersInput;
	
	@FindBy(xpath=("//*[@id=\"create-log-button\"]"))
	WebElement logsPageCreateLogButton;
	
	@FindBy(xpath=("//*[@id=\"log-update-button-1\"]"))
	WebElement logsPageFirstUpdateButton;
	
	@FindBy(xpath=("//*[@id=\"log-delete-button-1\"]"))
	WebElement logsPageFirstDeleteButton;
	
	@FindBy(xpath=("//*[@id=\"logs-table-entry-1\"]"))
	WebElement logsTableFirstTimeEntry;
	
	@FindBy(xpath=("/html/body/div[2]/table/tbody[2]/tr/td[1]"))
	WebElement logsTableNumberEntry;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[2]/a"))
	WebElement logsPageNavBarUser;
	
	@FindBy(xpath=("/html/body/nav/div/div/a"))
	WebElement logsPageNavBarHome;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[1]/a"))
	WebElement logsPageNavBarMonsters;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[3]/a"))
	WebElement logsPageNavBarAbout;
	
	WebDriver driver;
	
	public LogPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addLog(String time,String players) {
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageInputTime.clear();
		logsPageNoOfPlayersInput.clear();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageInputTime.sendKeys(time);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageNoOfPlayersInput.sendKeys(players);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageCreateLogButton.click();
	}
	
	public void updateLog(String time,String players) throws InterruptedException {
		logsPageFirstUpdateButton.click();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		Thread.sleep(1000);
		logsPageInputTime.clear();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		Thread.sleep(1000);
		logsPageNoOfPlayersInput.clear();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		Thread.sleep(1000);
		logsPageInputTime.sendKeys(time);
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		logsPageNoOfPlayersInput.sendKeys(players);
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		WebElement newUpdateButton = driver.findElement(By.xpath("//*[@id=\"update-log-button\"]"));
		Thread.sleep(1000);
		newUpdateButton.click();
	}
	
	public void deleteLog() {
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageFirstDeleteButton.click();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
	}
	
	public String firstTimeEntryValue() {
		return driver.findElement(By.xpath("//*[@id=\"logs-table-entry-1\"]")).getText();
	}
	
	public void gotToUser() {
		logsPageNavBarUser.click();
	}
	
	public void gotToMonsters() {
		logsPageNavBarMonsters.click();
	}
	
	public void gotToHome() {
		logsPageNavBarHome.click();
	}
	
	public void gotToAbout() {
		logsPageNavBarAbout.click();
	}
	
}
