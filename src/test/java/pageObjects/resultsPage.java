package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultsPage extends pageObjectBase {

	public resultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//div[@class='s-no-outline']/h2)[1]") WebElement Results;
	@FindBy(xpath="//div[@class='sg-col-inner']//h2/span") List<WebElement> products;
	
	public String returnResults() {
		return Results.getText();
	}
	
	public void selectProduct(String prodItem) {
		for(WebElement prod: products) {
			String str = prod.getText();
			if(str.contains(prodItem)) {
				//System.out.print(str);
				prod.click();
				break;
			}
		}
	}
	
	

}
