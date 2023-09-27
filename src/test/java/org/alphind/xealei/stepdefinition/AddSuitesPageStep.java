/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import io.cucumber.java.en.Then;

public class AddSuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User must navigate to Suite Module")
	public void user_must_navigate_to_suite_module() {

		pom.getAddSuitesPage().navToSuiteModule();

	}

	@Then("User must verify suite page is displayed {string}")
	public void user_must_verify_suite_page_is_displayed(String expText) {

		waitForPageLoad();
		Assert.assertEquals("Suites Page is Not Displayed", expText, getText(pom.getAddSuitesPage().getSuitesPage()));

	}

	@Then("User must click Add Suite button")
	public void user_must_click_add_suite_button() {

		pom.getAddSuitesPage().addSuiteButton();
	}

	@Then("User must verify {string} popup should be displayed after click the Add Suites button")
	public void user_must_verify_popup_should_be_displayed_after_click_the_add_suites_button(String expText)
			throws Exception {

		waitForPageLoad();

		String actualtext = getText(pom.getAddSuitesPage().getAddSuitePopupText());

		if (actualtext.contains("Add Suite")) {
			System.out.println("Popup displayed as expected");
		} else {
			System.out.println("Popup Not displayed Expected : " + expText + " but was : " + actualtext);
			throw new Exception("Assertion failed");
		}

	}

	@Then("User must perform only non-mandatory fields")
	public void user_must_perform_only_non_mandatory_fields() {

		try {
			pom.getAddSuitesPage().createSuitePerformedOnlyNonMandatoryFields();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Then("User must verify the error message contains for Mandatory fields {string} and {string}")
	public void user_must_verify_the_error_message_contains_for_mandatory_fields_and(String validationMsgForSuiteName,
			String validationMsgForLocation) {

		waitForPageLoad();

		Assert.assertEquals("Validation message for suites and suites is not displayed", validationMsgForSuiteName,
				getText(pom.getAddSuitesPage().getValidationMessageForSuiteName()));
		Assert.assertEquals("Validation message for location and location is not displayed", validationMsgForLocation,
				getText(pom.getAddSuitesPage().getValidationMessageForLocation()));

	}

	@Then("User must perform only mandatory fields")
	public void user_must_perform_only_mandatory_fields() throws Exception {

		pom.getAddSuitesPage().createSuitePerformedOnlyMandatoryFields();
	}

	@Then("User must verify the toast message after perform only mandatory fields {string}")
	public void user_must_verify_the_toast_message_after_perform_only_mandatory_fields(String expToastMessage) {

		waitForPageLoad();
		Assert.assertEquals("Toast Message is not displayed", expToastMessage,
				getText(pom.getAddSuitesPage().getToastMessage()));

	}

	@Then("User must verify mandatory fields are created successsfully")
	public void user_must_verify_mandatory_fields_are_created_successsfully() throws IOException, Exception {

		pom.getAddSuitesPage().getCreatedSuitePerformedMandatoryField();

		waitForPageLoad();
		
		sleep(1000);
		
		Assert.assertEquals("Created SuiteName is Mismatched", pom.getAddSuitesPage().createdSuite,
				getText(pom.getAddSuitesPage().getCreatedSuiteName()));

		Assert.assertEquals("Created Location is Mismatched", pom.getAddSuitesPage().getLocationDataFromExcel,
				getText(pom.getAddSuitesPage().getCreatedLocation()));

	}

	@Then("User must perform all fields and verify the toast message after perform all fields {string}")
	public void user_must_perform_all_fields_and_verify_the_toast_message_after_perform_all_fields(String expToastMessage) throws Exception {
	   
		pom.getAddSuitesPage().createSuitePerformedAllFields(expToastMessage);
		
	}
	
	@Then("User must verify all fields are created successsfully")
	public void user_must_verify_all_fields_are_created_successsfully() throws IOException, AWTException {

		pom.getAddSuitesPage().getCreatedSuitePerformedAllFields();
		
	}

//		pom.getSuitesPage().addSuite(SuiteName, Location, Length, Breadth, Height);
//
//	}
//
//
//
//		waitForPageLoad();
//
//		Assert.assertEquals("Created SuiteName Mismatched", readDatafromExcel("TestDatas", "Suites", 1, 5),
//				getText(pom.getSuitesPage().getTxtVerifySuiteUpdatedSuccessfully()));
//
//		Assert.assertEquals("Created SuiteLocation Mismatched", readDatafromExcel("TestDatas", "Suites", 1, 1),
//				getText(pom.getSuitesPage().getTxtVerifyLocationUpdatedSuccessfully()));
//
//		Assert.assertEquals("Created SuiteLength Mismatched", readDatafromExcel("TestDatas", "Suites", 1, 2),
//				getText(pom.getSuitesPage().getTxtVerifyLengthUpdatedSuccessfully()));
//
//		Assert.assertEquals("Created SuiteBreadth Mismatched", readDatafromExcel("TestDatas", "Suites", 1, 3),
//				getText(pom.getSuitesPage().getTxtVerifyBreadthUpdatedSuccessfully()));
//
//		Assert.assertEquals("Created SuiteHeigth Mismatched", readDatafromExcel("TestDatas", "Suites", 1, 4),
//				getText(pom.getSuitesPage().getTxtVerifyHeightUpdatedSuccessfully()));
//
//	}
//
//
//
//		pom.getSuitesPage().editSuite(SuiteName, Location, Availability, Length, Breadth, Height);
//
//	}
//
//
//
//		waitForPageLoad();
//
//		Assert.assertEquals("Updated SuiteName Mismatched", readDatafromExcel("TestDatas", "EditSuite", 1, 5),
//				getText(pom.getSuitesPage().getTxtVerifySuiteUpdatedSuccessfully()));
//
//		Assert.assertEquals("Updated SuiteLocation Mismatched", readDatafromExcel("TestDatas", "EditSuite", 1, 1),
//				getText(pom.getSuitesPage().getTxtVerifyLocationUpdatedSuccessfully()));
//
//		Assert.assertEquals("Updated SuiteLength Mismatched", readDatafromExcel("TestDatas", "EditSuite", 1, 2),
//				getText(pom.getSuitesPage().getTxtVerifyLengthUpdatedSuccessfully()));
//
//		Assert.assertEquals("Updated SuiteBreadth Mismatched", readDatafromExcel("TestDatas", "EditSuite", 1, 3),
//				getText(pom.getSuitesPage().getTxtVerifyBreadthUpdatedSuccessfully()));
//
//		Assert.assertEquals("Updated SuiteHeigth Mismatched", readDatafromExcel("TestDatas", "EditSuite", 1, 4),
//				getText(pom.getSuitesPage().getTxtVerifyHeightUpdatedSuccessfully()));
//
//	}

}