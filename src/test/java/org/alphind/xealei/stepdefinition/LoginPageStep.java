package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.pom.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageStep {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on Xealei login page")
	public void user_is_on_xealei_login_page() {

	}

	@When("User must perform <{string}>,<{string}>")
	public void user_must_perform(String email, String password) throws Exception {

		pom.getLoginPage().Login(email, password);

	}

}