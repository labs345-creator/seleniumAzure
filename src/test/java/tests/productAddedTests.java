package tests;

import java.util.List;
import java.util.Set;

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
