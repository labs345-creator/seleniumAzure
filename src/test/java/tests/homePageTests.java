package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.resultsPage;

public class homePageTests extends testBaseClass {
	@Test
	void HomepageTests() {
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
		
		Assert.assertEquals(result.returnResults(), "Results");
		
	}
//   //div[@class='a-section a-spacing-small _Zmx1a_gridRowOne_1t0zL']//img[@alt='ACs']
}
