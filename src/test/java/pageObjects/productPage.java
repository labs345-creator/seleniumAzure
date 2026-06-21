package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productPage extends pageObjectBase {

	public productPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='productTitle']") WebElement addedProduct;
	
	public boolean productAdded(String str) {
	//	String text = addedProduct.getText();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String text =	myWait.until(ExpectedConditions.presenceOfElementLocated((By) addedProduct)).getText();
		if(text.contains(str)) {
			return true;
		}
		else {
			return false;
		}
	}

}
