package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.pom.PageObjectManager;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class CommonSteps {
	
	PageObjectManager pom= new PageObjectManager();
	
	@Then("User must verify once login is successfull {string}")
	public void user_must_verify_once_login_is_successfull(String actualMessage) {
	    
		String expMessage = pom.getLoginPage().getSuccessFulMessage().getText();

		Assert.assertEquals(actualMessage, expMessage);	
	}
}
