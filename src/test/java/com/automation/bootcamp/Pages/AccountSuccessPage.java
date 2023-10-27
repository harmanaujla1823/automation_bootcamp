package com.automation.bootcamp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	private WebElement accountCreatedSuccessMessage;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public boolean accountCreatedSuccessMessageTeXt() {
		boolean accountCreatedSuccessMessageTeXt = accountCreatedSuccessMessage.isDisplayed();
		return accountCreatedSuccessMessageTeXt;
	}
	
	

}