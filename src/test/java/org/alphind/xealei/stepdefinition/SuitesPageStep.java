package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.alphind.xealei.pom.PageObjectManager;
import org.junit.Assert;

import io.cucumber.java.en.Then;

public class SuitesPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User must navigate to Suites page and perform all fields <{string}>, <{string}>, <{string}>, <{string}> , <{string}>")
	public void user_must_navigate_to_suites_page_and_perform_all_fields(String SuiteName, String Location,
			String Length, String Breadth, String Height) throws Exception {

		pom.getSuitesPage().addSuite(SuiteName, Location, Length, Breadth, Height);

	}

	@Then("User must verify once the Suite is created successfully")
	public void user_must_verify_once_the_suite_is_created_successfully() throws Exception {

		waitForPageLoad();

		Assert.assertEquals("Created SuiteName Mismatched", readData("TestDatas", "Suites", 1, 5),
				getText(pom.getSuitesPage().getTxtVerifySuiteUpdatedSuccessfully()));

		Assert.assertEquals("Created SuiteLocation Mismatched", readData("TestDatas", "Suites", 1, 1),
				getText(pom.getSuitesPage().getTxtVerifyLocationUpdatedSuccessfully()));

		Assert.assertEquals("Created SuiteLength Mismatched", readData("TestDatas", "Suites", 1, 2),
				getText(pom.getSuitesPage().getTxtVerifyLengthUpdatedSuccessfully()));

		Assert.assertEquals("Created SuiteBreadth Mismatched", readData("TestDatas", "Suites", 1, 3),
				getText(pom.getSuitesPage().getTxtVerifyBreadthUpdatedSuccessfully()));

		Assert.assertEquals("Created SuiteHeigth Mismatched", readData("TestDatas", "Suites", 1, 4),
				getText(pom.getSuitesPage().getTxtVerifyHeightUpdatedSuccessfully()));

	}

	@Then("User must navigate to created Suite page and edit the required fields <{string}>, <{string}>, <{string}>, <{string}>, <{string}> , <{string}>")
	public void user_must_navigate_to_created_suite_page_and_edit_the_required_fields(String SuiteName, String Location,
			String Availability, String Length, String Breadth, String Height) throws Exception {

		pom.getSuitesPage().editSuite(SuiteName, Location, Availability, Length, Breadth, Height);

	}

	@Then("User must verify once the Suite is updated successfully")
	public void user_must_verify_once_the_suite_is_updated_successfully() throws Exception {

		waitForPageLoad();

		Assert.assertEquals("Updated SuiteName Mismatched", readData("TestDatas", "EditSuite", 1, 5),
				getText(pom.getSuitesPage().getTxtVerifySuiteUpdatedSuccessfully()));

		Assert.assertEquals("Updated SuiteLocation Mismatched", readData("TestDatas", "EditSuite", 1, 1),
				getText(pom.getSuitesPage().getTxtVerifyLocationUpdatedSuccessfully()));

		Assert.assertEquals("Updated SuiteLength Mismatched", readData("TestDatas", "EditSuite", 1, 2),
				getText(pom.getSuitesPage().getTxtVerifyLengthUpdatedSuccessfully()));

		Assert.assertEquals("Updated SuiteBreadth Mismatched", readData("TestDatas", "EditSuite", 1, 3),
				getText(pom.getSuitesPage().getTxtVerifyBreadthUpdatedSuccessfully()));

		Assert.assertEquals("Updated SuiteHeigth Mismatched", readData("TestDatas", "EditSuite", 1, 4),
				getText(pom.getSuitesPage().getTxtVerifyHeightUpdatedSuccessfully()));

	}

}