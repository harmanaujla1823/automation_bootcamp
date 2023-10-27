package com.automation.bootcamp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria')]")
	private WebElement noProduct;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validProductDisplayStatus() {
		boolean validproductDisplayStatus = validProduct.isDisplayed();
		return validproductDisplayStatus;
	}
	
	public boolean invalidOrNoProductDisplayStatus() {
		boolean noProductDisplayStatus = noProduct.isDisplayed();
		return noProductDisplayStatus;
	}
	

}
