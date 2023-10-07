/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import java.io.IOException;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

// ***** To verify the web url link *****

	@Then("User must verify the login page is displayed")
	public void user_must_verify_the_login_page_is_displayed() {

		Assert.assertEquals("Login Page is not displayed", "Powered by Alphind © 2023",
				getText(pom.getLoginPage().getValForLoginScreen()));
	}

	@Then("User must verify the tab url address for login screen")
	public void user_must_verify_the_tab_url_address_for_login_screen() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 1, 1) + "login",
					getCurrentUrl());
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 2, 1) + "login",
					getCurrentUrl());
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Login page url is wrong", readExcel("Test Datas", "Environments", 3, 1) + "login",
					getCurrentUrl());
		}
	}

// ***** To verify the login screen for fields, logo & button *****

	@Given("User is on Xealei login page")
	public void user_is_on_xealei_login_page() {

	}

	@Then("User must verify the Login text is displayed")
	public void user_must_verify_the_login_text_is_displayed() {

		Assert.assertEquals("Header Name (LOGIN) Text is Missing/Not displayed", "LOGIN",
				getText(pom.getLoginPage().getLoginTextVerification()));
		System.out.println(
				"verify_the_login_text_is_displayed :" + getText(pom.getLoginPage().getLoginTextVerification()));
	}

	@Then("User must verify the Email and password fields contains * symbol")
	public void user_must_verify_the_email_and_password_fields_contains_symbol() throws Exception {

		
		String email = getText(pom.getLoginPage().getUNMandatoryVerification());
		String password = getText(pom.getLoginPage().getPassMandatoryVerification());

		System.out.println(email);
		System.out.println(password);

		if (email.contains("Email *") && password.contains("Password *")) {
			System.out.println("UN and Password fields name contains * symbol");
		} else {
			System.out.println("* symbol is missing : Expected * but was :" + email + ", " + password);
			throw new Exception("Assertion Failed");
		}

	}

	@Then("User must verify the Email textbox contains {string} text")
	public void user_must_verify_the_email_textbox_contains_text(String expEmailText) {

		Assert.assertEquals("Email Textbox Name Mismatched", expEmailText,
				getAttribute(pom.getLoginPage().getUserName(), "placeholder"));
		System.out.println("verify_the_email_textbox_contains_text :"
				+ getAttribute(pom.getLoginPage().getUserName(), "placeholder"));
	}

	@Then("User must verify the Password textbox contains {string} text")
	public void user_must_verify_the_password_textbox_contains_text(String expPassText) {

		Assert.assertEquals("Email Textbox Name Mismatched", expPassText,
				getAttribute(pom.getLoginPage().getPassword(), "placeholder"));
		System.out.println("verify_the_password_textbox_contains_text :"
				+ getAttribute(pom.getLoginPage().getPassword(), "placeholder"));

	}

	@Then("User must verify the eye icon is displayed")
	public void user_must_verify_the_eye_icon_is_displayed() throws Exception {

		if (pom.getLoginPage().getEyeShow().isDisplayed()) {
			System.out.println("Pasword Textbox contains eye icon");
		} else {
			System.out.println("Pasword Textbox doesn't contains eye icon");
			throw new Exception("Assertion Failed");
		}
		
	}

	@Then("User must verify the {string} text is displayed in Login button")
	public void user_must_verify_the_text_is_displayed_in_login_button(String expLoginText) {

		Assert.assertEquals("Login button contain Invalid Text", expLoginText,
				getText(pom.getLoginPage().getLoginButton()));
		System.out.println(
				"verify_the_text_is_displayed_in_login_button :" + getText(pom.getLoginPage().getLoginButton()));
	}

	@Then("User must verify the Forget password link is displayed")
	public void user_must_verify_the_forget_password_link_is_displayed() throws IOException {

		getAttribute(pom.getLoginPage().getHyperLnkForgotPassword(), "href");
		System.out.println("verify_the_forget_password_link_is_displayed :"
				+ getAttribute(pom.getLoginPage().getHyperLnkForgotPassword(), "href"));
	}

	@Then("User must verify the copy rights {string} text is displayed")
	public void user_must_verify_the_copy_rights_text_is_displayed(String expBtmPageText) {

		scrollDownToBottomOfThePage();

		Assert.assertEquals("Copyrights text is mismatched", expBtmPageText,
				getText(pom.getLoginPage().getBottomText()));
		System.out.println("verify_the_text_is_displayed :"+getText(pom.getLoginPage().getBottomText()));
	}

//  ***** To verify the eye icon is working in Password field *****

	@When("User must enter password in password textbox")
	public void user_must_enter_password_in_password_textbox() throws Exception {

		pom.getLoginPage().enterPassword();
	}

	@Then("User must verify the entered password in password textbox is display as hidden")
	public void user_must_verify_the_entered_password_in_password_textbox_is_display_as_hidden() throws Exception {

		
		String passwordType = getAttribute(pom.getLoginPage().getPassword(), "type");
		boolean passwordField = "password".equalsIgnoreCase(passwordType);
		
		if (passwordField) {

			System.out.println("Password is hide");
		} else {
			System.out.println("Password is Unhide");

			throw new Exception("Assertion Failed");
		}
	}

	@Then("User must click the eye icon")
	public void user_must_click_the_eye_icon() {

		click(pom.getLoginPage().getEyeShow());
		waitForPageLoad();
	}

	@Then("User must verify the password is display as Unhidden")
	public void user_must_verify_the_password_is_display_as_unhidden() throws Exception {

		String passwordType = getAttribute(pom.getLoginPage().getPassword(), "type");
		boolean passwordField = "text".equalsIgnoreCase(passwordType);
		
		if (passwordField) {

			System.out.println("Password is Unhide");
		} else {
			System.out.println("Password is Hide");

			throw new Exception("Assertion Failed");
		}
	}

// ***** To verify the Privacy Policy link *****
	
	@When("User must click the Privacy Policy")
	public void user_must_click_the_privacy_policy() {

		click(pom.getLoginPage().getLnkPrivacyPolicy());
	}

	@Then("User must verify {string} popup should be displayed after click the Privacy Policy link")
	public void user_must_verify_popup_should_be_displayed_after_click_the_privacy_policy_link(String string) {

		Assert.assertEquals("Privacy policy content is not displayed", "PRIVACY POLICY",
				getText(pom.getLoginPage().getPrivacyPolicyContent()));

	}

// ***** To verify Xealei Login page with Invalid credentials *****
	
	@When("User must perform invalid email and password and click Login button")
	public void user_must_perform_invalid_email_and_password_and_click_login_button() throws Exception {

		pom.getLoginPage().LoginWithInvalidCredentials();
	}

	@Then("User must verify the error message after click the Login button {string}")
	public void user_must_verify_the_error_message_after_click_the_login_button(String expErrorMessage) {

		waitForPageLoad();
		Assert.assertEquals("User Not Found-Toastbar validation is Missing", expErrorMessage,
				getText(pom.getLoginPage().getUserNotFoundErrorMessage()));

	}

// ***** To verify Xealei Login Page by enter only valid Email/Username *****
	
	@When("User must enter valid email in email textbox and click Login button without enter password")
	public void user_must_enter_valid_email_in_email_textbox_and_click_login_button_without_enter_password()
			throws Exception {

		pom.getLoginPage().LoginWithValidEmail();
	}

	@Then("User must verify the error message contains for password after click the Login button {string}")
	public void user_must_verify_the_error_message_contains_for_password_after_click_the_login_button(
			String expErrorMessage) {

		Assert.assertEquals("Please enter password-validation is Missing", expErrorMessage,
				getText(pom.getLoginPage().getErrorMessageForPassword()));
	}

// ***** To verify Xealei Login Page by enter only valid Password *****
	
	@When("User must enter valid password in password textbox and click Login button without enter email")
	public void user_must_enter_valid_password_in_password_textbox_and_click_login_button_without_enter_email()
			throws Exception {

		pom.getLoginPage().LoginWithValidPassword();
	}

	@Then("User must verify the error message contains for email after click the Login button {string}")
	public void user_must_verify_the_error_message_contains_for_email_after_click_the_login_button(
			String expErrorMessage) {

		Assert.assertEquals("Please enter email ID-validation is Missing", expErrorMessage,
				getText(pom.getLoginPage().getErrorMessageForEmail()));
	}

// ***** To verify Xealei Login Page by enter only valid Email/Username and Invalid Password *****
	
	@When("User must enter valid email and invalid password and click Login button")
	public void user_must_enter_valid_email_and_invalid_password_and_click_login_button() throws Exception {

		pom.getLoginPage().LoginWithValidEmailAndInvalidPassword();
	}

	@Then("User must verify the error message after enter valid email, invalid password and click the Login button {string}")
	public void user_must_verify_the_error_message_after_enter_valid_email_invalid_password_and_click_the_login_button(
			String expErrorMessage) {

		waitForPageLoad();
		Assert.assertEquals("Incorrect Password-validation is Missing", expErrorMessage,
				getText(pom.getLoginPage().getIncorrectPasswordErrorMessage()));
	}

// ***** To verify Xealei Login Page without enter Email/Username and Password *****
	
	@When("User click Login button without enter username and password")
	public void user_click_login_button_without_enter_username_and_password() {

		pom.getLoginPage().clickLoginButtonWithoutEnterCredentials();
	}

	@Then("User must verify the error message contains for both email and password after click the Login button {string} and {string}")
	public void user_must_verify_the_error_message_contains_for_both_email_and_password_after_click_the_login_button_and(
			String expEmailErrorMessage, String expPasswordErrorMessage) {

		Assert.assertEquals("Please enter email ID-validation is Missing", expEmailErrorMessage,
				getText(pom.getLoginPage().getErrorMessageForEmail()));

		Assert.assertEquals("Please enter password-validation is Missing", expPasswordErrorMessage,
				getText(pom.getLoginPage().getErrorMessageForPassword()));

	}

// ***** To verify Xealei login page with valid credentials *****
	
	@When("User must perform login with valid email and password")
	public void user_must_perform_login_with_valid_email_and_password() throws Exception {

		pom.getLoginPage().LoginWithValidCredentials();
	}

// ***** To verify Xealei login page by click the ENTER key with valid credentials *****
	
	@When("User must perform login with valid email and password by click the Enter key")
	public void user_must_perform_login_with_valid_email_and_password_by_click_the_enter_key() throws Exception {

		pom.getLoginPage().LoginUsingEnterKey();
	}

}