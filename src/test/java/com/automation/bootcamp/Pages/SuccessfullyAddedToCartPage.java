package com.automation.bootcamp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfullyAddedToCartPage {
	
	WebDriver driver;
	@FindBy (xpath = "//span[normalize-space()='Shopping Cart']")
	private WebElement shoppingCartButton;
	//@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	//private WebElement shoppingCartButton;
	
	public SuccessfullyAddedToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public ShoppingCartPage clickOnCartButton() {
		shoppingCartButton.click();
		return new ShoppingCartPage(driver);
	}
	
	

}
