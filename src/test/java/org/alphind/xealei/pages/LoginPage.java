/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	/*
	 * Description - All the Login Module/Page locators are stored here..
	 */

	public LoginPage() {
		// this.driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Powered by Alphind © 2023')]")
	private WebElement valForLoginScreen;

	@FindBy(xpath = "//h3[text()='LOGIN']")
	private WebElement loginTextVerification;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[1]")
	private WebElement UNMandatoryVerification;

	@FindBy(xpath = "(//span[@class='text-danger']/parent::mat-label)[2]")
	private WebElement PassMandatoryVerification;

	@FindBy(xpath = "//img[@class='show-hide-pwd1']")
	private WebElement eyeShow;

	@FindBy(xpath = "//a[text()='Forgot password?']")
	private WebElement hyperLnkForgotPassword;

	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement lnkPrivacyPolicy;

	@FindBy(xpath = "//h1[text()='PRIVACY POLICY']")
	private WebElement privacyPolicyContent;

	@FindBy(xpath = "//p[@class='text-muted text-center mt-6']")
	private WebElement bottomText;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement loginButton;

	@FindBy(xpath = "//h5[@x-page='home']")
	private WebElement navToHomePageSuccessfully;

	@FindBy(xpath = "//span[text()='User not found']")
	private WebElement userNotFoundErrorMessage;

	@FindBy(xpath = "//span[text()='Incorrect password']")
	private WebElement incorrectPasswordErrorMessage;

	@FindBy(xpath = "//mat-error[text()=' Please enter email ID ']")
	private WebElement errorMessageForEmail;

	@FindBy(xpath = "//mat-error[text()=' Please enter password ']")
	private WebElement errorMessageForPassword;

	public WebElement getValForLoginScreen() {
		return valForLoginScreen;
	}

	public WebElement getLoginTextVerification() {
		return loginTextVerification;
	}

	public WebElement getUNMandatoryVerification() {
		return UNMandatoryVerification;
	}

	public WebElement getPassMandatoryVerification() {
		return PassMandatoryVerification;
	}

	public WebElement getEyeShow() {
		return eyeShow;
	}

	public WebElement getHyperLnkForgotPassword() {
		return hyperLnkForgotPassword;
	}

	public WebElement getLnkPrivacyPolicy() {
		return lnkPrivacyPolicy;
	}

	public WebElement getBottomText() {
		return bottomText;
	}

	public WebElement getPrivacyPolicyContent() {
		return privacyPolicyContent;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getNavToHomePageSuccessfully() {
		return navToHomePageSuccessfully;
	}

	public WebElement getUserNotFoundErrorMessage() {
		return userNotFoundErrorMessage;
	}

	public WebElement getIncorrectPasswordErrorMessage() {
		return incorrectPasswordErrorMessage;
	}

	public WebElement getErrorMessageForEmail() {
		return errorMessageForEmail;
	}

	public WebElement getErrorMessageForPassword() {
		return errorMessageForPassword;
	}

	/*
	 * Description - Below method helps to perform the Testcase actions for Login
	 * Page..
	 */

	public void enterPassword() throws Exception {

		sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 4));
	}

	public void LoginWithInvalidCredentials() throws Exception {

		sendKeys(getUserName(), readExcel("Test Datas", "Login", 1, 3));
		sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 4));
		click(getLoginButton());
	}

	public void LoginWithValidEmail() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 1, 1));
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
		}
		click(getLoginButton());
	}

	public void LoginWithValidPassword() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 2));
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		}
		click(getLoginButton());
	}

	public void LoginWithValidEmailAndInvalidPassword() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 1, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 4));
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 4));
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 4));
		}
		click(getLoginButton());
	}

	public void clickLoginButtonWithoutEnterCredentials() {

		waitForPageLoad();
		click(getLoginButton());

	}

	public void LoginWithValidCredentials() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 1, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 1, 2));
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		}
		click(getLoginButton());
	}

	public void LoginUsingEnterKey() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 1, 1));
			sendKeyWithEnter(getPassword(), readExcel("Test Datas", "Login", 1, 2));
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			sendKeys(getUserName(), readExcel("Test Datas", "Login", 2, 1));
			sendKeys(getPassword(), readExcel("Test Datas", "Login", 2, 2));
		}

	}

}
