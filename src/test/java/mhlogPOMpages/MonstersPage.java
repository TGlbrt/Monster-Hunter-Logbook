package mhlogPOMpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonstersPage {
	@FindBy(xpath=("//*[@id=\"monsters-table\"]"))
	WebElement monstersPageTable;
	
	@FindBy(xpath=("//*[@id=\"monsterName-input\"]"))
	WebElement monstersPageAddNameInput;
	
	@FindBy(xpath=("//*[@id=\"monsterRank-input\"]"))
	WebElement monstersPageAddRankInput;
	
	@FindBy(xpath=("//*[@id=\"monsterWeaknesses-input\"]"))
	WebElement monstersPageAddWeaknessesInput;
	
	@FindBy(xpath=("//*[@id=\"monster-add-button\"]"))
	WebElement monstersPageAddMonsterButton;
	
	@FindBy(xpath=("//*[@id=\"monster-update-name-input\"]"))
	WebElement monstersPageUpdateMonstersNameInput;
	
	@FindBy(xpath=("//*[@id=\"monster-update-rank-input\"]"))
	WebElement monstersPageUpdateMonstersRankInput;
	
	@FindBy(xpath=("//*[@id=\"monster-update-button\"]"))
	WebElement monstersPageUpdateMonsterButton;
	
	@FindBy(xpath=("//*[@id=\"monster-name-button\"]"))
	WebElement monstersPageMonsterLogsButton;
	
	@FindBy(xpath=("//*[@id=\"monster-delete-button\"]"))
	WebElement monstersPageDeleteMonsterButton;
	
	WebDriver driver;
	
	public MonstersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addMonster(String name,String rank,String weaknesses) {
		monstersPageAddNameInput.sendKeys(name);
		monstersPageAddRankInput.sendKeys(rank);
		monstersPageAddWeaknessesInput.sendKeys(weaknesses);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageAddMonsterButton.click();
	}
	
	public void updateMonster(String nameToUpdateBy,String name,String rankToUpdateBy,String rank,String weaknesses) {
		monstersPageUpdateMonstersNameInput.sendKeys(nameToUpdateBy);
		monstersPageUpdateMonstersRankInput.sendKeys(rankToUpdateBy);
		monstersPageAddNameInput.sendKeys(name);
		monstersPageAddRankInput.sendKeys(rank);
		monstersPageAddWeaknessesInput.sendKeys(weaknesses);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageUpdateMonsterButton.click();
	}
	
	public void goToLog() {
		monstersPageMonsterLogsButton.click();
	}
	
	public void deleteLog() {
		monstersPageDeleteMonsterButton.click();
	}
	
	public String firstEntryValue() {
		return monstersPageMonsterLogsButton.getText();
	}

}
