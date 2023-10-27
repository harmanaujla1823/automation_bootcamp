package com.automation.bootcamp.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.bootcamp.Pages.AccountPage;
import com.automation.bootcamp.Pages.LandingPage;
import com.automation.bootcamp.Pages.LoginPage;
import com.automation.bootcamp.TestBase.TestBase;
import com.automation.bootcamp.TestData.ExcelCode;

import com.automation.boocamp.utilities.Util;

public class LoginTest extends TestBase {
	
	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver; 
	public LandingPage landingpage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	
	@BeforeMethod
	public void loginSetup() {
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccount();
		loginpage = landingpage.selectLoginOption();
	}
	
	@Test(priority=1, dataProvider = "TN", dataProviderClass = ExcelCode.class )
	public void verifyLoginWithValidLoginCredentials(String email,String password ) {
		
		accountpage = loginpage.navigateToAccountPage(email, password);
		Assert.assertTrue(accountpage.validateEditYourAccountInformationLinkDisplayStatus());
	}
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		
		loginpage.navigateToAccountPage(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
		
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), dataprop.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		
		loginpage.clickOnLoginButton();
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}