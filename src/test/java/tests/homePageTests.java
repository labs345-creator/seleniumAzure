package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.resultsPage;

public class homePageTests extends testBaseClass {
	@Test
	void HomepageTests() {
		amazonHomePage homePage = new amazonHomePage(driver);
		resultsPage result = new resultsPage(driver);
		homePage.fillSearchBox("Kurta");
		homePage.searchItem();
		
		Assert.assertEquals(result.returnResults(), "Results");
		
	}
//   //div[@class='a-section a-spacing-small _Zmx1a_gridRowOne_1t0zL']//img[@alt='ACs']
}
