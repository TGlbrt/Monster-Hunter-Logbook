package mhlogPOMpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonstersPage {
	@FindBy(xpath=("//*[@id=\"monsters-table-body\"]"))
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
	
	@FindBy(xpath=("//*[@id=\"monster-name-button-rathalos\"]"))
	WebElement monstersPageMonsterLogsButton;
	
	@FindBy(xpath=("//*[@id=\"monster-delete-button-rathalos\"]"))
	WebElement monstersPageDeleteMonsterButton;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[2]/a"))
	WebElement monstersHeaderUser;
	
	@FindBy(xpath=("/html/body/nav/div/ul/li[1]/a"))
	WebElement monstersHeaderMonsters;
	
	@FindBy(xpath=("//*[@id=\"monster-name-button-rathalos\"]"))
	WebElement monstersFirstEntryRankValue;
	
	int counter = 1; 
	
	WebDriver driver;
	
	public MonstersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addMonster(String name,String rank,String weaknesses) throws InterruptedException {
		monstersPageAddNameInput.clear();
		monstersPageAddRankInput.clear();
		monstersPageAddWeaknessesInput.clear();
		Thread.sleep(1000);
		monstersPageAddNameInput.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageAddRankInput.sendKeys(rank);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageAddWeaknessesInput.sendKeys(weaknesses);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Thread.sleep(1000);
		monstersPageAddMonsterButton.click();
		Thread.sleep(1000);
		goToMonstersPage();
	}
	
	public void updateMonster(String nameToUpdateBy,String name,String rankToUpdateBy,String rank,String weaknesses) throws InterruptedException {
		monstersPageAddNameInput.clear();
		monstersPageAddRankInput.clear();
		monstersPageAddWeaknessesInput.clear();
		monstersPageUpdateMonstersNameInput.clear();
		monstersPageUpdateMonstersRankInput.clear();
		Thread.sleep(1000);
		monstersPageUpdateMonstersNameInput.sendKeys(nameToUpdateBy);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageUpdateMonstersRankInput.sendKeys(rankToUpdateBy);
		monstersPageAddNameInput.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageAddRankInput.sendKeys(rank);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		monstersPageAddWeaknessesInput.sendKeys(weaknesses);
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Thread.sleep(2000);
		monstersPageUpdateMonsterButton.click();
		goToMonstersPage();
	}
	
	public void goToLog() {
		monstersPageMonsterLogsButton.click();
	}
	
	public void deleteFirstEntry() {
		monstersPageDeleteMonsterButton.click();
	}
	
	public String firstEntryValue() {
		return monstersPageMonsterLogsButton.getAttribute("value");
	}
	
	public String firstEntryRankValue() {
		return monstersFirstEntryRankValue.getAttribute("value");
	}
	
	public void goToUserPage() {
		monstersHeaderUser.click();
	}
	
	public void goToMonstersPage() {
		monstersHeaderMonsters.click();
	}
	
	public String getTableEntryValue(String name) {
		String returnValue = "";
		WebElement foundElement = monstersPageTable.findElement(By.id("monster-name-button-" + name ));
		returnValue = foundElement.getAttribute("value");
		//returnValue = driver.findElement(By.xpath("//*[@id=\\\"monster-name-button-" + name + "\"]")).getAttribute("value");
		return returnValue;
	}

}
