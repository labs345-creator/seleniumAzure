package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazonHomePage extends pageObjectBase {

	public amazonHomePage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']") WebElement searchBox;
	@FindBy(xpath = "//input[@type='submit']") WebElement searchItem;
	
	public void fillSearchBox(String item) {
		myWait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(item);
		//searchBox.sendKeys(item);
	}
	
	public void searchItem() {
		searchItem.click();
	}

}
