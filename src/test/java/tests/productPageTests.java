package tests;

import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.resultsPage;

public class productPageTests extends testBaseClass {
	@Test
void prodPage() throws InterruptedException {
		amazonHomePage homePage = new amazonHomePage(driver);
		resultsPage result = new resultsPage(driver);
		homePage.fillSearchBox("Kurta");
		homePage.searchItem();
	result.selectProduct("100% Cotton");
	
}
}
