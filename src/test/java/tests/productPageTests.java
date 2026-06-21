package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.resultsPage;

public class productPageTests extends testBaseClass {
	@Test
void prodPage() throws InterruptedException {
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
		homePage.searchItem();
	result.selectProduct("100% Cotton");
	
}
}
