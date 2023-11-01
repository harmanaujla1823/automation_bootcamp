package com.automation.bootcamp.TestCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.bootcamp.Pages.LandingPage;
import com.automation.bootcamp.Pages.ShoppingCartPage;
import com.automation.bootcamp.Pages.SuccessfullyAddedToCartPage;
import com.automation.bootcamp.TestBase.TestBase;

public class ProductInShoppingCartTest extends TestBase{

	public ProductInShoppingCartTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public LandingPage landingpage; 
	public ShoppingCartPage shoppingcartpage;
	public SuccessfullyAddedToCartPage successfullyaddedtocartpage;
	
	@BeforeMethod
	public void registerSetup(){
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		successfullyaddedtocartpage = landingpage.selectProduct();
		shoppingcartpage = successfullyaddedtocartpage.clickOnCartButton();
	}
	
	@Test 
	public void verifyProductDisplayOnShoppingCartPage() {
		Assert.assertTrue(shoppingcartpage.displayStatusOfSelectedProduct());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
 
}
