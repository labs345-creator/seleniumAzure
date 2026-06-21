package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.productPage;
import pageObjects.resultsPage;

public class productAddedTests extends testBaseClass {
	@Test
	void  validateAddedProduct() {
		amazonHomePage homePage = new amazonHomePage(driver);
		resultsPage result = new resultsPage(driver);
		
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement continueShopping = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//button[contains(text(),'Continue shopping')]")
		        )
		    );

		    continueShopping.click();

		} catch (Exception e) {
		    System.out.println("Continue Shopping page not displayed");
		}
		
		
		homePage.fillSearchBox("Kurta");
		String parentId = driver.getWindowHandle();
		homePage.searchItem();
	result.selectProduct("100% Cotton");
	Set<String> ids = driver.getWindowHandles();
	for(String id: ids) {
		if(id!=parentId) {
			driver.switchTo().window(id);
		}
	}
	productPage prod = new productPage(driver);
	Assert.assertTrue(prod.productAdded("100% Cotton"));
	}

}
