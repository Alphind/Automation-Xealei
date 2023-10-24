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
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class AddSuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

// ****** Common Steps for All Scenario ******

	@Then("User must navigate to Suite Module")
	public void user_must_navigate_to_suite_module() {

		pom.getSuitesPage().navToSuiteModule();
	}

	@Then("User must verify suite page is displayed {string}")
	public void user_must_verify_suite_page_is_displayed(String expText) throws Exception {

		waitForPageLoad();
		Assert.assertEquals("Suites Page is Not Displayed", expText, getText(pom.getSuitesPage().getSuitesPage()));

	}

// ****** To verify the web url link for suite page ******

	@Then("User must verify the tab url address for suites screen")
	public void user_must_verify_the_tab_url_address_for_suites_screen() throws Exception {

		if (getConfigureProperty("Environment_QA").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Suite page tab url is wrong",
					readExcel("Test Datas", "Environments", 1, 1) + "main/suites", getCurrentUrl());
		} else if (getConfigureProperty("Environment_PREPOD").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Suite page tab url is wrong",
					readExcel("Test Datas", "Environments", 2, 1) + "main/suites", getCurrentUrl());
		} else if (getConfigureProperty("Environment_PRODUCTION").equalsIgnoreCase("Yes")) {
			Assert.assertEquals("Suite page tab url is wrong",
					readExcel("Test Datas", "Environments", 3, 1) + "main/suites", getCurrentUrl());
		}

	}

// ***** To verify the field 'Suite Name *' and Location * is mandatory *****

	@Then("User must click Add Suite button")
	public void user_must_click_add_suite_button() {

		pom.getSuitesPage().addSuiteButton();

	}

	@Then("User must verify {string} popup should be displayed after click the Add Suites button")
	public void user_must_verify_popup_should_be_displayed_after_click_the_add_suites_button(String expText)
			throws Exception {

		waitForPageLoad();

		String actualtext = getText(pom.getSuitesPage().getAddSuitePopupText());

		if (actualtext.contains(expText)) {
			System.out.println("Popup displayed as expected");
		} else {
			System.out.println("Popup Not displayed Expected : " + expText + " but was : " + actualtext);
			throw new Exception("Assertion failed");
		}
	}

	@Then("User must perform all fields except Suite Name")
	public void user_must_perform_all_fields_except_suite_name() throws IOException {

		pom.getSuitesPage().allFieldsExceptSuiteName();

	}

	@Then("User must verify the error message under Suite Name field {string}")
	public void user_must_verify_the_error_message_under_suite_name_field(String valMsgForSuiteName) {

		Assert.assertEquals("Validation message for suiteName not displayed", valMsgForSuiteName,
				getText(pom.getSuitesPage().getActValMsgForSuiteName()));

	}

	@Then("User must perform all fields except Location")
	public void user_must_perform_all_fields_except_location() throws IOException {

		pom.getSuitesPage().allFieldsExceptLocation();
	}

	@Then("User must verify the error message under Location field {string}")
	public void user_must_verify_the_error_message_under_location_field(String expValMsgForLocation) {

		Assert.assertEquals("Validation message for location not displayed", expValMsgForLocation,
				getText(pom.getSuitesPage().getActValMsgForLocation()));
	}

// ****** To verify duplicate validation for 'Suite Name' ******

	@Then("User must perform only mandatory fields with existing suiteName and location")
	public void user_must_perform_only_mandatory_fields_with_existing_suite_name_and_location() throws Exception {

		pom.getSuitesPage().duplicateDatas();

	}

	@Then("User must verify the toast message {string}")
	public void user_must_verify_the_toast_message(String expSuiteExistToastMessage) {

		waitForPageLoad();
		Assert.assertEquals("Suite Name already exists  toast message is not displayed", expSuiteExistToastMessage,
				getText(pom.getSuitesPage().getSNExitsToastMsg()));
		click(pom.getSuitesPage().getBtnToastMsgAlreadyExistOk());
	}

// ****** To verify duplicate Suite name with different 'Location' ******

	@Then("User must perform only mandatory fields with existing suiteName and different location and then verify the toast message after perform existing suiteName and different location {string}")
	public void user_must_perform_only_mandatory_fields_with_existing_suite_name_and_different_location_and_then__verify_the_toast_message_after_perform_existing_suite_name_and_different_location(
			String expSavedSuccessfullToastMsg) throws Exception {

		pom.getSuitesPage().exitSuiteNameWithDiffLocation(expSavedSuccessfullToastMsg);

	}

//	@Then("User must verify the toast message after perform existing suiteName and different location {string}")
//	public void user_must_verify_the_toast_message_after_perform_existing_suite_name_and_different_location(
//			String expToastMsg) {
//
//		waitForPageLoad();
//		Assert.assertEquals("Toast Message is not displayed", expToastMsg,
//				getText(pom.getAddSuitesPage().getActToastMessage()));
//		pom.getAddSuitesPage().getBtnToastMsgSuccessOk();
//	}

// ****** To verify validation message is displayed under mandatory fields also verify the user able to close the Add Suite popup ******

	@Then("User must click Add button")
	public void user_must_click_add_button() {

		pom.getSuitesPage().add();
	}

	@Then("User must verify the error message contains for Mandatory fields {string} and {string}")
	public void user_must_verify_the_error_message_contains_for_mandatory_fields_and(String expValMsgForSuiteName,
			String expValMsgForLocation) {

		waitForPageLoad();

		Assert.assertEquals("Validation message for suites Name is not displayed", expValMsgForSuiteName,
				getText(pom.getSuitesPage().getActValMsgForSuiteName()));

		Assert.assertEquals("Validation message for location is not displayed", expValMsgForLocation,
				getText(pom.getSuitesPage().getActValMsgForLocation()));

	}

	@Then("User must close the Add Suite popup")
	public void user_must_close_the_add_suite_popup() {

		pom.getSuitesPage().closePopup();
	}

	@Then("User must verify the Add Suite popup is closed successfully")
	public void user_must_verify_the_add_suite_popup_is_closed_successfully() throws Exception {

		WebElement btnAddSuites = pom.getSuitesPage().getBtnAddSuites();

		if (btnAddSuites.isEnabled()) {
			System.out.println("Popup is closed");
		} else {
			throw new Exception("Assertion Failed : AddSuite Popup not closed");
		}

	}

// ****** To verify user able to Add/Create Suites by entering only Non-Mandatory fields ******

	@Then("User must perform only non-mandatory fields")
	public void user_must_perform_only_non_mandatory_fields() throws IOException {

		pom.getSuitesPage().nonMandatoryFields();
	}

// ****** To verify user able to Add/Create Suites by entering only Mandatory fields	******	

	@Then("User must perform only mandatory fields")
	public void user_must_perform_only_mandatory_fields() throws Exception {

		pom.getSuitesPage().mandatoryFields();

	}

	@Then("User must verify the toast message after perform only mandatory fields {string}")
	public void user_must_verify_the_toast_message_after_perform_only_mandatory_fields(String expToastMsg) {

		waitForPageLoad();
		Assert.assertEquals("Saved Successfull Toast Message is not displayed", expToastMsg,
				getText(pom.getSuitesPage().getSavedSuccessfullToastMessage()));

		click(pom.getSuitesPage().getBtnToastMsgSuccessOk());
	}

	@Then("User must verify mandatory fields are created successsfully")
	public void user_must_verify_mandatory_fields_are_created_successsfully() throws Exception {

		pom.getSuitesPage().getCreatedSuitePerformedMandatoryField();

		waitForPageLoad();

		sleep(1000);
		waitForFullPageElementLoad();
		Assert.assertEquals("Created SuiteName Mismatched", pom.getSuitesPage().createSuiteName,
				getText(pom.getSuitesPage().getCreatedSN()));
		Assert.assertEquals("Created Location  Mismatched", readExcel("Test Datas", "AddSuites", 1, 1),
				getText(pom.getSuitesPage().getCreatedLocation()));

	}

// ****** To verify user able to Add/Create Suites by entering all fields ******						

	@Then("User must perform all fields and verify the toast message after perform all fields {string}")
	public void user_must_perform_all_fields_and_verify_the_toast_message_after_perform_all_fields(
			String expToastMessage) throws Exception {

		pom.getSuitesPage().createSuitePerformedAllFields(expToastMessage);
	}

	@Then("User must verify all fields are created successsfully")
	public void user_must_verify_all_fields_are_created_successsfully() throws IOException, AWTException {

		pom.getSuitesPage().getCreatedSuitePerformedAllFields();
	}

// ****** To verify 'Bread Crums' button in Suites view screen ******					

	@Then("User must search the existing suiteName and click the image in suites screen")
	public void user_must_search_the_existing_suite_name_and_click_the_image_in_suites_screen() throws IOException {

		pom.getSuitesPage().searchCreatedSuiteName();

	}

	@Then("User must verify the breadcrums link should be display with module suite name > selected suite name")
	public void user_must_verify_the_breadcrums_link_should_be_display_with_module_suite_name_selected_suite_name()
			throws Exception {

		waitForPageLoad();

		String txtBreadCrum = getText(pom.getSuitesPage().getBreadCrumLink());
		System.out.println("Breadcrums Suite text :" + txtBreadCrum);
		System.out.println("Breadcrums Suite>createdSN text :" + pom.getSuitesPage().getBreadCrumLinkText());

		if (txtBreadCrum.contains("Suites")
				&& pom.getSuitesPage().getBreadCrumLinkText().contains(pom.getSuitesPage().existingSN)) {
			System.out.println("Breadcrums link is displayed with selected suiteName");
		} else {
			throw new Exception("Assertion Failed : Breadcrums link is not displayed with selected suiteName ");
		}
	}

	@Then("User must verify after click the breadcrums link it should be return to Suite searched page")
	public void user_must_verify_after_click_the_breadcrums_link_it_should_be_return_to_suite_searched_page()
			throws Exception {

		pom.getSuitesPage().clickBreadCrumSuiteLink();

		waitForPageLoad();

		WebElement clickViewBtn = pom.getSuitesPage().getClickViewBtn();

		if (clickViewBtn.isDisplayed()) {
			System.out.println("Breadcrums link is successfully returned to suite searched page");
		} else {
			throw new Exception("Assertion Failed : Breadcrums link is not returned to suite searched page");
		}
	}
}
