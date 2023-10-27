package com.automation.bootcamp.Pages;

import org.openqa.selenium.WebDriver;       
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//input[@name = 'agree'  and @value='1']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	private WebElement successMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailExistWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningsMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningsMessage;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningsMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningsMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningsMessage;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);		
	}
	
	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);		
	}
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);		
	}
	
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);		
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);		
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);		
	}
	
	public void clickOnPrivacyPolicyChechbox() {
		privacyPolicyCheckBox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public String retreiveActualSuccessMessageText() {
		String successMessageText = successMessage.getText();
		return successMessageText;
	}
	
	public String retreiveEmailAlreadyExistWarningMessageText() {
		String EmailAlreadyExistWarningMessageText = emailExistWarningMessage.getText();
		return EmailAlreadyExistWarningMessageText;
	}
	
	public String retreivePrivacyPolicyWarningMessageText() {
		String privacyPolicyWarningMessageText = privacyPolicyWarningMessage.getText();
		return privacyPolicyWarningMessageText;
	}
	
	public String retreiveFirstNameWarningsMessageText() {
		String firstNameWarningsMessageText = firstNameWarningsMessage.getText();
		return firstNameWarningsMessageText;
	}
	
	public String retreiveLastNameWarningsMessageText() {
		String lastNameWarningsMessageText = lastNameWarningsMessage.getText();
		return lastNameWarningsMessageText;
	}
	
	public String retreiveEmailWarningsMessageText() {
		String emailWarningsMessageText = emailWarningsMessage.getText();
		return emailWarningsMessageText;
	}
	
	public String retreiveTelephoneWarningsMessageText() {
		String telephoneWarningsMessageText = telephoneWarningsMessage.getText();
		return telephoneWarningsMessageText;
	}
	
	public String retreivePasswordWarningsMessageText() {
		String passwordWarningsMessageText = passwordWarningsMessage.getText();
		return passwordWarningsMessageText;
	}
	
	public AccountSuccessPage registerPageMandatoryDetails(String firstNameText, String lastNameText, String emailText, 
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);	
		emailTextBox.sendKeys(emailText);	
		telephoneTextBox.sendKeys(telephoneText);	
		passwordTextBox.sendKeys(passwordText);	
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerPageAllDetails(String firstNameText, String lastNameText, String emailText, 
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);	
		emailTextBox.sendKeys(emailText);	
		telephoneTextBox.sendKeys(telephoneText);	
		passwordTextBox.sendKeys(passwordText);	
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerPageWithExistingEmail(String firstNameText, String lastNameText, String emailText, 
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);	
		emailTextBox.sendKeys(emailText);	
		telephoneTextBox.sendKeys(telephoneText);	
		passwordTextBox.sendKeys(passwordText);	
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean retreiveAllWarningMesseges(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, 
			String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, 
			String expectedPasswordWarning) {
		boolean privacypolicyWarningStatus = privacyPolicyWarningMessage.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarningsMessage.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarningsMessage.getText().contains(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarningsMessage.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarningsMessage.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarningsMessage.getText().contains(expectedPasswordWarning);
		
		return privacypolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus &&
				telephoneWarningStatus && passwordWarningStatus;
		
	}
}
