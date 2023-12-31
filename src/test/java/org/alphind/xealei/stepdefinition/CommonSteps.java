/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User must verify once the page is navigate to HOME_DASHBOARD successfully {string}")
	public void user_must_verify_once_the_page_is_navigate_to_home_dashboard_successfully(String expMessage) throws Exception {

		waitForPageLoad();
		
		try {
	    	Assert.assertFalse("Assert Fail", pom.getLoginPage().getUnknownErrorToastMsg().isDisplayed());
			System.err.println("[ERROR] - Unknown Toast Msg is Diplayed [Toast Message] >>>  Unknown Error.Please contact administrator for more information.");
		} catch (AssertionError e) {
			e.getMessage();
		} catch(NoSuchElementException e1) {
			e1.getMessage();
		}
		
		System.out.println("exp Text :" + expMessage);
		System.out.println("Actual Text :" + getText(pom.getLoginPage().getNavToHomePageSuccessfully()));

		Assert.assertEquals("Unable to navigate HOME Dashboard", expMessage,
				getText(pom.getLoginPage().getNavToHomePageSuccessfully()));
	}
}
