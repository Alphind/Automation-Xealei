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
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//h5[text()='Home']")
	private WebElement successFulMessage;
	

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public WebElement getSuccessFulMessage() {
		return successFulMessage;
	}
	
	/*
	 * Description - Below method helps to perform the Testcase actions for Login Page..
	 */
	public void Login(String email, String password) throws Exception {
		
		sendKeys(getTxtUserName(),readData("TestDatas", "Login", 1, 0));
		sendKeys(getTxtPassword(),readData("TestDatas", "Login", 1, 1));
		click(getBtnLogin());
		waitForPageLoad();
	}
	
}
