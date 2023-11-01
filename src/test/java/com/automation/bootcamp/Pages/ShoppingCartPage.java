package com.automation.bootcamp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public WebDriver driver;

	@FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	private WebElement productDisplayInCart;
	
	public ShoppingCartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfSelectedProduct(){
		boolean displayStatus = productDisplayInCart.isDisplayed();
		return displayStatus;
				
		
	}
	
	
}
