package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuitesPage extends BaseClass {

	/*
	 * Description - All the Suites Module/Page locators are stored here.
	 * 
	 */

	public SuitesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Suites']/parent::a")
	private WebElement btnSuitesPage;

	@FindBy(xpath = "//span[text()='Add Suites']/parent::span/parent::button")
	private WebElement btnAddSuites;

	@FindBy(xpath = "//input[@placeholder='Enter Suite Name']")
	private WebElement txtSuiteName;

	// @FindBy(xpath = "//div[@class='mat-select-value']")
	@FindBy(xpath = "//mat-select[@placeholder='Select Location']")

	// @FindBy(xpath = "//span[text()='Select
	// location']/parent::div/parent::div/parent::mat-select")
	private WebElement dropDownLocation;

	@FindBy(xpath = "//input[@ng-reflect-name='length']")
	private WebElement txtLength;

	@FindBy(xpath = "//input[@ng-reflect-name='breadth']")
	private WebElement txtBreadth;

	@FindBy(xpath = "//input[@ng-reflect-name='height']")
	private WebElement txtHeight;

	@FindBy(xpath = "//span[text()='Add']/parent::button")
	private WebElement btnAdd;

	String locationDD = "//span[text()='locationName']/parent::mat-option";

	@FindBy(xpath = "//div[@class='row col-12']//span[@class='btn-txt']")
	private WebElement actualText;

	@FindBy(xpath = "//div[@class='row col-12']//span[@class='btn-txt']")
	private WebElement allSuites;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBoxSuites;

	@FindBy(xpath = "//span[@class='btn-txt']")
	private WebElement txtCreatedSuiteName;

	@FindBy(xpath = "//span[text()='Available']")
	private WebElement txtSuiteAvailability;

	public String getAvailabilityDD() {
		return availabilityDD;
	}

	@FindBy(xpath = "//span[text()='updatedLocation']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement dropDownUpdatedLocation;

	@FindBy(xpath = "//mat-select[@placeholder='Select location']")
	private WebElement dropDownAvailability;

	String upDatedLocationDD = "//span[text()='updatedLocation']/parent::mat-option";

	String availabilityDD = "//span[text()='availability']/parent::mat-option";

	@FindBy(xpath = "//span[text()='Edit']/parent::button")
	private WebElement btnEditSuite;

	@FindBy(xpath = "//span[text()='Update']/parent::button")
	private WebElement btnUpdateSuite;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement txtVerifySuiteUpdatedSuccessfully;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement txtVerifyLocationUpdatedSuccessfully;

	@FindBy(xpath = "(//span[@class='d-block'])[3]")
	private WebElement txtVerifyLengthUpdatedSuccessfully;

	@FindBy(xpath = "(//span[@class='d-block'])[4]")
	private WebElement txtVerifyBreadthUpdatedSuccessfully;

	@FindBy(xpath = "(//span[@class='d-block'])[5]")
	private WebElement txtVerifyHeighUpdatedSuccessfully;

	public WebElement getAllSuites() {
		return allSuites;
	}

	public WebElement getBtnSuitesPage() {
		return btnSuitesPage;
	}

	public WebElement getBtnAddSuites() {
		return btnAddSuites;
	}

	public WebElement getTxtSuiteName() {
		return txtSuiteName;
	}

	public WebElement getDropDownLocation() {
		return dropDownLocation;
	}

	public WebElement getTxtLength() {
		return txtLength;
	}

	public WebElement getTxtBreadth() {
		return txtBreadth;
	}

	public WebElement getTxtHeight() {
		return txtHeight;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getActualText() {
		return actualText;
	}

	public WebElement getSearchBoxSuites() {
		return searchBoxSuites;
	}

	public WebElement getTxtCreatedSuiteName() {
		return txtCreatedSuiteName;
	}

	public WebElement getDropDownAvailability() {
		return dropDownAvailability;
	}

	public WebElement getBtnEditSuite() {
		return btnEditSuite;
	}

	public WebElement getBtnUpdateSuite() {
		return btnUpdateSuite;
	}

	public WebElement getDropDownUpdatedLocation() {
		return dropDownUpdatedLocation;
	}

	public WebElement getTxtVerifySuiteUpdatedSuccessfully() {
		return txtVerifySuiteUpdatedSuccessfully;
	}

	public WebElement getTxtVerifyLocationUpdatedSuccessfully() {
		return txtVerifyLocationUpdatedSuccessfully;
	}

	public WebElement getTxtVerifyLengthUpdatedSuccessfully() {
		return txtVerifyLengthUpdatedSuccessfully;
	}

	public WebElement getTxtVerifyBreadthUpdatedSuccessfully() {
		return txtVerifyBreadthUpdatedSuccessfully;
	}

	public WebElement getTxtVerifyHeightUpdatedSuccessfully() {
		return txtVerifyHeighUpdatedSuccessfully;
	}

	public WebElement getTxtSuiteAvailability() {
		return txtSuiteAvailability;
	}

	/*
	 * Description - Below methods helps to perform the Testcase actions for Suites page..
	 * 
	 */

	String createdSuitesdata;

	public void addSuite(String SuiteName, String Location, String Length, String Breadth, String Height)
			throws Exception {

		waitForPageLoad();
		click(getBtnSuitesPage());
		waitForPageLoad();
		sleep(5000);
		click(getBtnAddSuites());
		createdSuitesdata = (readData("TestDatas", "Suites", 1, 0) + dateAndTime());
		sendKeys(getTxtSuiteName(), createdSuitesdata);
		writeData("TestDatas", "Suites", 1, 5, createdSuitesdata);
		waitForPageLoad();
		click(getDropDownLocation());
		locationDD = locationDD.replaceAll("locationName", readData("TestDatas", "Suites", 1, 1));
		clickXpath(locationDD);
		sendKeys(getTxtLength(), readData("TestDatas", "Suites", 1, 2));
		sendKeys(getTxtBreadth(), readData("TestDatas", "Suites", 1, 3));
		sendKeys(getTxtHeight(), readData("TestDatas", "Suites", 1, 4));
		waitForElementToBeClickable(getBtnAdd(), 10);
		click(getBtnAdd());
		waitForPageLoad();
		sendKeyWithEnter(getSearchBoxSuites(), createdSuitesdata);
		waitForPageLoad();
		click(getTxtCreatedSuiteName());
	}

	public void editSuite(String SuiteName, String Location, String Availability, String Length, String Breadth,
			String Height) throws Exception {

		click(getBtnEditSuite());
		getTxtSuiteName().clear();
		waitForPageLoad();
		String updatedSuite = readData("TestDatas", "EditSuite", 1, 0) + dateAndTime();
		sendKeys(getTxtSuiteName(), updatedSuite + dateAndTime());
		writeData("TestDatas", "EditSuite", 1, 5, updatedSuite);
		click(getDropDownLocation());
		upDatedLocationDD = upDatedLocationDD.replaceAll("updatedLocation", readData("TestDatas", "EditSuite", 1, 1));
		clickXpath(upDatedLocationDD);
//		click(getDropDownAvailability());
//		availabilityDD = availabilityDD.replaceAll("availability", readData("TestDatas", "EditSuite", 1, 6));
//		clickXpath(availabilityDD);
		getTxtLength().clear();
		sendKeys(getTxtLength(), readData("TestDatas", "EditSuite", 1, 2));
		getTxtBreadth().clear();
		sendKeys(getTxtBreadth(), readData("TestDatas", "EditSuite", 1, 3));
		getTxtHeight().clear();
		sendKeys(getTxtHeight(), readData("TestDatas", "EditSuite", 1, 4));
		click(getBtnUpdateSuite());
	}
}
