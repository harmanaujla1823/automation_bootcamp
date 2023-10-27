package com.automation.bootcamp.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.bootcamp.Pages.AccountSuccessPage;
import com.automation.bootcamp.Pages.LandingPage;
import com.automation.bootcamp.Pages.RegisterPage;
import com.automation.bootcamp.TestBase.TestBase;

import com.automation.boocamp.utilities.Util;

public class RegisterTest extends TestBase{
	public RegisterTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public RegisterPage registerpage; 
	public LandingPage landingpage; 
	public AccountSuccessPage accountsuccesspage;
	
	@BeforeMethod
	public void registerSetup(){
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		registerpage = landingpage.navigateToRegisterPage();
	}
	
	@Test(priority = 1)
	public void verifyRegisterWithMandatoryDetails() {
		
		accountsuccesspage = registerpage.registerPageMandatoryDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				Util.emailWithDateTimeStamp(), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertTrue(accountsuccesspage.accountCreatedSuccessMessageTeXt());	
	}
	
	@Test(priority = 2)
	public void verifyRegisterWithAllDetails() {
		accountsuccesspage = registerpage.registerPageAllDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				Util.emailWithDateTimeStamp(), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertTrue(registerpage.retreiveActualSuccessMessageText().contains(dataprop.getProperty("registerAccountSuccessMessage")));
	}
	
	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {
		
		registerpage.registerPageWithExistingEmail(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				prop.getProperty("validEmail"), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertTrue(registerpage.retreiveEmailAlreadyExistWarningMessageText().contains(dataprop.getProperty("emailExistWarningMessage")));
	}
	
	
	@Test(priority = 4)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.retreiveAllWarningMesseges(dataprop.getProperty("policyWarningMessage"), (dataprop.getProperty("firstNameWarningMessage")),
				(dataprop.getProperty("lastNameWarningMessage")), (dataprop.getProperty("emailWarningMessage")), (dataprop.getProperty("telephoneWarningMessage")), 
				(dataprop.getProperty("passwordWarningMessage"))));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}