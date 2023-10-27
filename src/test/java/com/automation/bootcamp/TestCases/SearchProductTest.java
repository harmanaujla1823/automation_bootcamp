package com.automation.bootcamp.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.bootcamp.Pages.LandingPage;
import com.automation.bootcamp.Pages.SearchPage;
import com.automation.bootcamp.TestBase.TestBase;

public class SearchProductTest extends TestBase {
	
	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void searchProductSetup() {
		
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browser"));		
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("validProduct"));
		Assert.assertTrue(searchpage.validProductDisplayStatus());
	}
	
	@Test(priority = 2)
	public void verifySearchWithInalidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("invalidProduct"));
		searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.invalidOrNoProductDisplayStatus());				
	}
	
	@Test(priority = 3, dependsOnMethods = "verifySearchWithInalidProduct")
	public void verifySearchWithNoProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.clickOnSearchBox();
		Assert.assertTrue(searchpage.invalidOrNoProductDisplayStatus());	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}