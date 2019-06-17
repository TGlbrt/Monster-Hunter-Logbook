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
	
	@FindBy(xpath=("//*[@id=\"log-update-button\"]"))
	WebElement logsPageUpdateButton;
	
	@FindBy(xpath=("//*[@id=\"log-delete-button\"]"))
	WebElement logsPageDeleteButton;
	
	@FindBy(xpath=("//*[@id=\"logs-table-entry\"]"))
	WebElement logsTableTimeEntry;
	
	WebDriver driver;
	
	public LogPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addLog(String time,String players) {
		logsPageInputTime.sendKeys(time);
		logsPageNoOfPlayersInput.sendKeys(players);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		logsPageCreateLogButton.click();
	}
	
	public void updateLog(String time,String players) {
		logsPageUpdateButton.click();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		WebElement newUpdateButton = driver.findElement(By.xpath("//*[@id=\"update-log-button\"]"));
		logsPageInputTime.sendKeys(time);
		logsPageNoOfPlayersInput.sendKeys(players);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		newUpdateButton.click();
	}
	
	public void deleteLog() {
		logsPageDeleteButton.clear();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
	}
	
	public String timeEntryValue() {
		return logsTableTimeEntry.getText();
	}
	
}
