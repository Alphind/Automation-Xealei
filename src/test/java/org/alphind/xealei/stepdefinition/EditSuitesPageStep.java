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

public class EditSuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

// ***** BACKGROUND *****
	@Then("User must searched the created suite")
	public void user_must_searched_the_created_suite() throws Exception, AWTException {

		pom.getSuitesPage().lastCreatedSuite();

	}

	@Then("User must click the Edit button")
	public void user_must_click_the_edit_button() {

		pom.getSuitesPage().clickEditButton();
	}

	@Then("User must verify {string} popup should be displayed after click the Edit button")
	public void user_must_verify_popup_should_be_displayed_after_click_the_edit_button(String expText)
			throws Exception {

		String actText = getText(pom.getSuitesPage().getEditSuitePopup());

		if (actText.contains(expText)) {
			System.out.println("EditSuite Popup displayed as expected");
		} else {
			System.out.println("EditSuit popup not displayed Expected : " + expText + " but was : " + actText);
			throw new Exception("Assertion failed");
		}

	}

	// ***** To verify the field 'Suite Name *' and 'Location *' is mandatory *****

	@Then("User must delete the Suite Name and click Add button")
	public void user_must_delete_the_suite_name_and_click_add_button() throws Exception {

		pom.getSuitesPage().delSuiteName();
	}

	@Then("User must update all fields with empty Location")
	public void user_must_update_all_fields_with_empty_location() throws IOException {

		pom.getSuitesPage().delLocation();
	}

	// ***** To verify duplicate validation for 'Suite Name' *****

	@Then("User must delete all the fields and click update button")
	public void user_must_delete_all_the_fields_and_click_update_button() {

		pom.getSuitesPage().delAllFields();
	}

	@Then("User must close the Edit Suite popup")
	public void user_must_close_the_edit_suite_popup() {

		pom.getSuitesPage().closePopup();
	}

	@Then("User must verify the Edit Suite popup is closed successfully")
	public void user_must_verify_the_edit_suite_popup_is_closed_successfully() throws Exception {

		WebElement btnEditSuites = pom.getSuitesPage().getBtnEditSuite();

		if (btnEditSuites.isEnabled()) {
			System.out.println("Popup is closed");
		} else {
			throw new Exception("Assertion Failed : EditSuite Popup not closed");
		}

	}

// ****** To verify user able to Edit/Update Suites by updating only Non-Mandatory fields ******

	@Then("User must delete the suite name and select empty value in location and perform only non mandatory fields")
	public void user_must_delete_the_suite_name_and_select_empty_value_in_location_and_perform_only_non_mandatory_fields()
			throws Exception {

		pom.getSuitesPage().delMandatoryFields();
	}

// ****** To verify user able to Edit/Update Suites by updating only Mandatory fields and also verify the 'Bread Crums' link ******

	@Then("User must update only mandatory fields and verify the toast message after perform all fields {string}")
	public void user_must_update_only_mandatory_fields_and_verify_the_toast_message_after_perform_all_fields(
			String expToastMsg) throws Exception {

		pom.getSuitesPage().updateMandatoryFields(expToastMsg);
	}

	@Then("User must verify mandatory fields are updated in view screen successfully")
	public void user_must_verify_mandatory_fields_are_updated_in_view_screen_successfully() throws Exception {

		waitForPageLoad();

		pom.getSuitesPage().verifyMandatoryFieldsAreUpdatedSuccessfully();
	}

	@Then("User must verify the breadcrums link should be display with module suite name > updated suite name")
	public void user_must_verify_the_breadcrums_link_should_be_display_with_module_suite_name_updated_suite_name()
			throws Exception {

		waitForPageLoad();

		String txtBreadCrum = getText(pom.getSuitesPage().getBreadCrumLink());
		System.out.println("Breadcrums Suite text :" + txtBreadCrum);
		System.out.println("Breadcrums Suite>createdSN text :" + pom.getSuitesPage().BCLinkTextForCurrentSuite());

		if (txtBreadCrum.contains("Suites")
				&& pom.getSuitesPage().getBreadCrumLinkText().contains(pom.getSuitesPage().MFSuiteName)) {
			System.out.println("Breadcrums link is displayed with selected suiteName in EditSuite Page");
		} else {
			throw new Exception(
					"Assertion Failed : Breadcrums link is not displayed with selected suiteName in EditSuite page ");
		}
	}

// ****** To verify user able to Edit/Update Suites by updating all fields ******

	@Then("User must update all fields and verify the toast message after perform all fields {string}")
	public void user_must_update_all_fields_and_verify_the_toast_message_after_perform_all_fields(String expToastMsg)
			throws Exception {

		pom.getSuitesPage().updateAllFields(expToastMsg);

	}

	@Then("User must verify all fields are updated in view screen successsfully")
	public void user_must_verify_all_fields_are_updated_in_view_screen_successsfully() throws Exception, AWTException {

		pom.getSuitesPage().verifyAllFieldsAreUpdatedSuccessfully();
	}

	// ****** To verify duplicate validation for 'Suite Name' and to verify user
	// able to update exist suiteName with different 'Location' ******

	@Then("User must update only mandatory fields with existing datas and verify the toast message {string} and user change the different location")
	public void user_must_update_only_mandatory_fields_with_existing_datas_and_verify_the_toast_message_and_user_change_the_different_location(
			String expSNExistToastMessage) throws Exception {

		pom.getSuitesPage().updateDuplicateData(expSNExistToastMessage);

	}

	@Then("User must verify the toast message after perform existing suiteName and different location {string}")
	public void user_must_verify_the_toast_message_after_perform_existing_suite_name_and_different_location(
			String expSavedSuccessfullToastMsg) {

		waitForPageLoad();

		Assert.assertEquals("Toast Message is not displayed", expSavedSuccessfullToastMsg,
				getText(pom.getSuitesPage().getSavedSuccessfullToastMessage()));

		click(pom.getSuitesPage().getBtnToastMsgSuccessOk());
	}

	@Then("User must verify the existing suiteName and different location is updated successfully")
	public void user_must_verify_the_existing_suite_name_and_different_location_is_updated_successfully()
			throws Exception {

		pom.getSuitesPage().verifyExistSNWithDiffLocationIsUpdatedSuccessfully();

	}

}
