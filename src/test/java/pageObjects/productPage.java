package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends pageObjectBase {

	public productPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='productTitle']") WebElement addedProduct;
	
	public boolean productAdded(String str) {
		String text = addedProduct.getText();
		
		if(text.contains(str)) {
			return true;
		}
		else {
			return false;
		}
	}

}
