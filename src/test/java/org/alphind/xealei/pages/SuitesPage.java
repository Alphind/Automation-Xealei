/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.alphind.xealei.baseclass.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
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
	private WebElement suitesModule;

	@FindBy(xpath = "//h5[text()='Suites']")
	private WebElement suitesPage;

	@FindBy(xpath = "//span[text()='Add Suites']/parent::span/parent::button")
	private WebElement btnAddSuites;

	@FindBy(xpath = "//h2[contains(text(),'Add Suite')]")
	private WebElement addSuitePopupText;

	@FindBy(xpath = "//input[@placeholder='Enter Suite Name']")
	private WebElement suiteName;

	@FindBy(xpath = "//mat-select[@placeholder='Select Location']")
	private WebElement location;

	@FindBy(xpath = "//input[@placeholder='Enter Length']")
	private WebElement length;

	@FindBy(xpath = "//input[@placeholder='Enter Width ']")
	private WebElement width;

	@FindBy(xpath = "//input[@placeholder='Enter Height']")
	private WebElement height;

	@FindBy(xpath = "//button[@x-as-save-btn]")
	private WebElement btnAdd;

	@FindBy(xpath = "//span[text()='Please Enter Suite Name']")
	private WebElement actValMsgForSuiteName;

	@FindBy(xpath = "//span[text()='Please select facility location']")
	private WebElement actValMsgForLocation;

	String dropDownListForLocation = "//span[text()='locationName']/parent::mat-option";
	String dropDownListForDiffLocation = "//span[text()='location']/parent::mat-option";

	@FindBy(xpath = "//span[text()='Saved Successfully!!']")
	private WebElement savedSuccessfullToastMsg;

	@FindBy(xpath = "//span[contains(text(),'Suite Name already exists.')]")
	private WebElement SNExitsToastMsg;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement suitesSearchBox;

	@FindBy(xpath = "//span[@class='btn-txt']")
	private WebElement searchCreatedSN;

	@FindBy(xpath = "//span[text()=' View ']/parent::button")
	private WebElement clickViewBtn;

	@FindBy(xpath = "//img[@class='profile-thumb']")
	private WebElement clickImageInSearchedSN;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement createdLoc;

	@FindBy(xpath = "(//span[@class='d-block'])[3]")
	private WebElement createdLength;

	@FindBy(xpath = "(//span[@class='d-block'])[4]")
	private WebElement createdWidth;

	@FindBy(xpath = "(//span[@class='d-block'])[5]")
	private WebElement createdHeight;

	@FindBy(xpath = "//span[text()='Available']")
	private WebElement suiteAvailability;

	@FindBy(xpath = "//a[text()='Suites']")
	private WebElement rtnToSuitesPage;

	@FindBy(xpath = "//span[text()='ok']/parent::button")
	private WebElement btnToastMsgSuccessOk;

	@FindBy(xpath = "//span[text()='OK']/parent::button")
	private WebElement btnToastMsgAlreadyExistOk;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement btnPopupClose;

	@FindBy(xpath = "//ol[@class='breadcrumb']")
	private WebElement breadCrumLink;

	String BC = "//span[text()='createdSN']/parent::li/parent::ol";

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	private WebElement txtRtnToSuitesBreadCrum;

	@FindBy(xpath = "//mat-select[@placeholder='Select location']")
	private WebElement locationAvailability;

	String upDatedLocation = "//span[text()='updatedLocation']/parent::mat-option";

	String availability = "//span[text()='availability']/parent::mat-option";

	String emptyLocation = "(//mat-option[@role='option'])[1]";

	// ***** EDIT SUITE *****

	@FindBy(xpath = "//span[text()='Edit']/parent::button")
	private WebElement btnEditSuite;

	@FindBy(xpath = "//h2[text()=' Edit Suite ']")
	private WebElement editSuitePopup;

	@FindBy(xpath = "//span[text()=' Update ']/parent::button")
	private WebElement btnUpdateSuite;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdSN;

	@FindBy(xpath = "//button[@mat-raised-button]")
	private WebElement EditSuite;

	public WebElement getSuitesModule() {
		return suitesModule;
	}

	public WebElement getBtnAddSuites() {
		return btnAddSuites;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public String getDropDownListForLocation() {
		return dropDownListForLocation;
	}

	public WebElement getActToastMsg() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getSuitesSearchBox() {
		return suitesSearchBox;
	}

	public WebElement getSearchCreatedSN() {
		return searchCreatedSN;
	}

	public WebElement getCreatedSN() {
		return createdSN;
	}

	public WebElement getCreatedLoc() {
		return createdLoc;
	}

	public WebElement getSuiteAvailability() {
		return suiteAvailability;
	}

	public WebElement getRtnToSuitesPage() {
		return rtnToSuitesPage;
	}

	public WebElement getBtnToastMsgSuccessOk() {
		return btnToastMsgSuccessOk;
	}

	public WebElement getBtnToastMsgAlreadyExistOk() {
		return btnToastMsgAlreadyExistOk;
	}

	public WebElement getLocationAvailability() {
		return locationAvailability;
	}

	public String getUpDatedLocation() {
		return upDatedLocation;
	}

	public String getAvailability() {
		return availability;
	}

//	public WebElement getEditSuiteButton() {
//		return editSuiteButton;
//	}
//
//	public WebElement getSuiteUpdateButton() {
//		return suiteUpdateButton;
//	}
//
//	public WebElement getUpdatedSuiteName() {
//		return updatedSuiteName;
//	}
//
//	public WebElement getUpdatedLocation() {
//		return updatedLocation;
//	}
//
//	public WebElement getUpdatedLength() {
//		return updatedLength;
//	}
//
//	public WebElement getUpdatedWidth() {
//		return updatedWidth;
//	}
//
//	public WebElement getUpdatedHeight() {
//		return updatedHeight;
//	}

	public String getCreateSuiteName() {
		return createSuiteName;
	}

	public String getCreatedSuite() {
		return createdSuite;
	}

	public String getSuiteName() {
		return SuiteName;
	}

	public String getLocation() {
		return Location;
	}

	public String getLength() {
		return Length;
	}

	public String getWidth() {
		return Width;
	}

	public String getHeight() {
		return Height;
	}

//	@FindBy(xpath = "//span[text()='Edit']/parent::button")
//	private WebElement editSuiteButton;
//
//	@FindBy(xpath = "//span[text()='Update']/parent::button")
//	private WebElement suiteUpdateButton;
//
//	@FindBy(xpath = "(//span[@class='d-block'])[1]")
//	private WebElement updatedSuiteName;
//
//	@FindBy(xpath = "(//span[@class='d-block'])[2]")
//	private WebElement updatedLocation;
//
//	@FindBy(xpath = "(//span[@class='d-block'])[3]")
//	private WebElement updatedLength;
//
//	@FindBy(xpath = "(//span[@class='d-block'])[4]")
//	private WebElement updatedWidth;
//
//	@FindBy(xpath = "(//span[@class='d-block'])[5]")
//	private WebElement updatedHeight;

	public WebElement getSuitesPage() {
		return suitesPage;
	}

	public WebElement getAddSuitePopupText() {
		return addSuitePopupText;
	}

	public WebElement getActValMsgForSuiteName() {
		return actValMsgForSuiteName;
	}

	public WebElement getActValMsgForLocation() {
		return actValMsgForLocation;
	}

	public WebElement getSavedSuccessfullToastMessage() {
		return savedSuccessfullToastMsg;
	}

	public WebElement getSNExitsToastMsg() {
		return SNExitsToastMsg;
	}

	public WebElement getCreatedSuiteName() {
		return createdSN;
	}

	public WebElement getCreatedLocation() {
		return createdLoc;
	}

	public WebElement getCreatedLength() {
		return createdLength;
	}

	public WebElement getCreatedWidth() {
		return createdWidth;
	}

	public WebElement getCreatedHeight() {
		return createdHeight;
	}

	public WebElement getBreadCrumLink() {
		return breadCrumLink;
	}

	public WebElement getTxtRtnToSuitesBreadCrum() {
		return txtRtnToSuitesBreadCrum;
	}

	public WebElement getClickViewBtn() {
		return clickViewBtn;
	}

	// ***** Edit Suite *****
	public WebElement getEditSuitePopup() {
		return editSuitePopup;
	}

	public WebElement getBtnEditSuite() {
		return btnEditSuite;
	}

	/*
	 * Description - Below methods helps to perform the Testcase actions for Add
	 * Suites page..
	 * 
	 */

	public String createSuiteName;

	public String createdSuite;
	public String existingSN;

	String SuiteName;
	String Location;
	String Length;
	String Width;
	String Height;
	String createdSuiteName;

	String crSuiteName;

	int noOfTotalRows;

	public void navToSuiteModule() {

		waitForPageLoad();
		click(suitesModule);
	}

	public void addSuiteButton() {

		waitForPageLoad();
		click(btnAddSuites);
	}

	public void add() {

		click(btnAdd);
	}

	public void closePopup() {

		click(btnPopupClose);
	}

	public void clickBreadCrumSuiteLink() {

		click(getTxtRtnToSuitesBreadCrum());
	}

	public void allFieldsExceptSuiteName() throws IOException {

		click(location);
		String getLocationDataFromExcel = readExcel("Test Datas", "AddSuites", 1, 1);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);
		sendKeys(length, readExcel("Test Datas", "AddSuites", 1, 2));
		sendKeys(width, readExcel("Test Datas", "AddSuites", 1, 3));
		sendKeys(height, readExcel("Test Datas", "AddSuites", 1, 4));
		click(btnAdd);

	}

	public void allFieldsExceptLocation() throws IOException {

		createSuiteName = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);
		click(location);
		selectDropDown(emptyLocation);
		click(btnAdd);
	}

	public void duplicateDatas() throws Exception {

		createSuiteName = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);
		String crSuiteName = writeExcel("Test Datas", "CreatedSuites", 0, createSuiteName);
		click(location);
		String getLocationDataFromExcel = readExcel("Test Datas", "AddSuites", 1, 1);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);
		click(btnAdd);
		waitForPageLoad();
		Assert.assertEquals("Toast Message is not displayed", "Saved Successfully!!",
				getText(savedSuccessfullToastMsg));
		click(btnToastMsgSuccessOk);
		waitForPageLoad();

		waitForElementToBeClickable(btnAddSuites, 15);
		jsExecutorClick(btnAddSuites);
		waitForPageLoad();

		String actualtext = getText(getAddSuitePopupText());

		if (actualtext.contains("Add Suite")) {
			System.out.println("Popup displayed as expected");
		} else {
			throw new Exception("Assertion failed :Popup Not displayed Expected");
		}

		sendKeys(suiteName, crSuiteName);
		click(location);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);
		click(btnAdd);
	}

	public void exitSuiteNameWithDiffLocation(String expSavedSuccessfullToastMsg) throws Exception {

		createSuiteName = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);

		crSuiteName = writeExcel("Test Datas", "CreatedSuites", 0, createSuiteName);

		click(location);
		String getLocationDataFromExcel = readExcel("Test Datas", "AddSuites", 1, 1);
		System.out.println("create Loc :" + getLocationDataFromExcel);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);
		click(btnAdd);
		waitForPageLoad();

		Assert.assertEquals("Toast Message is not displayed", expSavedSuccessfullToastMsg,
				getText(getSavedSuccessfullToastMessage()));

		click(btnToastMsgSuccessOk);

		waitForPageLoad();

		jsExecutorClick(btnAddSuites);

		waitForPageLoad();
		waitForFullPageElementLoad();
		sendKeys(suiteName, crSuiteName);

		crSuiteName = writeExcel("Test Datas", "CreatedSuites", 0, createSuiteName);
		String diffLocationFromExcel = readExcel("Test Datas", "AddSuites", 2, 1);
		System.out.println("created Loc :" + diffLocationFromExcel);

		click(location);

		dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location", diffLocationFromExcel);
		selectDropDown(dropDownListForDiffLocation);

		click(btnAdd);

		waitForPageLoad();

		Assert.assertEquals("Toast Message is not displayed", expSavedSuccessfullToastMsg,
				getText(getSavedSuccessfullToastMessage()));

		click(btnToastMsgSuccessOk);
	}

	public void nonMandatoryFields() throws IOException {

		sendKeys(length, readExcel("Test Datas", "AddSuites", 1, 2));
		sendKeys(width, readExcel("Test Datas", "AddSuites", 1, 3));
		sendKeys(height, readExcel("Test Datas", "AddSuites", 1, 4));
		click(btnAdd);

	}

	public void mandatoryFields() throws Exception {

		createSuiteName = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("CreatedSuites");
		int lastRowNum = sheet.getLastRowNum();

		System.out.println(lastRowNum);

		click(location);
		String getLocationDataFromExcel = readExcel("Test Datas", "AddSuites", 1, 1);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);

		sheet.createRow(lastRowNum + 1).createCell(0).setCellValue(createSuiteName);

		FileOutputStream outputStream = new FileOutputStream(file);

		workbook.write(outputStream);
		workbook.close();
		click(btnAdd);
	}

	public void getCreatedSuitePerformedMandatoryField() throws IOException {

		waitForPageLoad();
		click(suitesModule);
		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, createSuiteName);
		waitForPageLoad();
		click(searchCreatedSN);
	}

	public void createSuitePerformedAllFields(String expToastMessage) throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("AddSuites");

		noOfTotalRows = sheet.getLastRowNum();
		System.out.println(noOfTotalRows);

		for (int i = 1; i <= noOfTotalRows; i++) {

			int lastRow = sheet.getLastRowNum();
			System.out.println("Total Rows :" + lastRow);

			SuiteName = sheet.getRow(i).getCell(0).getStringCellValue() + dateAndTime();
			System.out.println(SuiteName);
			Location = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(Location);
			Length = sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println(Length);
			Width = sheet.getRow(i).getCell(3).getStringCellValue();
			System.out.println(Width);
			Height = sheet.getRow(i).getCell(4).getStringCellValue();
			System.out.println(Height);

			waitForPageLoad();
			sendKeys(suiteName, SuiteName);
			waitForPageLoad();
			waitForVisiblityOfElement(location, 10);
			click(location);
			waitForPageLoad();
			String dropDownListForLocation = "//span[text()='locationName']/parent::mat-option";
			dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", Location);
			selectDropDown(dropDownListForLocation);

			System.out.println(dropDownListForLocation);

			waitForPageLoad();
			sendKeys(length, Length);
			System.out.println(Length);
			sendKeys(width, Width);
			System.out.println(Width);
			sendKeys(height, Height);
			System.out.println(Height);
			click(btnAdd);
			waitForPageLoad();
			Assert.assertEquals("Toast Message is not displayed", expToastMessage, getText(savedSuccessfullToastMsg));
			click(btnToastMsgSuccessOk);

			File writeFile = new File(".//Excel//Test Datas.xlsx");
			FileInputStream writeStream = new FileInputStream(writeFile);

			Workbook wb = new XSSFWorkbook(writeStream);
			Sheet s = wb.getSheet("CreatedSuites");

			int lastRows = s.getLastRowNum();
			System.out.println("Total Rows :" + lastRows);

			s.createRow(lastRows + 1).createCell(0).setCellValue(SuiteName);

			FileOutputStream outputStream = new FileOutputStream(file);

			wb.write(outputStream);

			if (i == noOfTotalRows) {
				System.out.println("Row is empty");
				break;
			} else {
				System.out.println("Row is !empty");

				waitForPageLoad();

				click(btnAddSuites);
				waitForPageLoad();
				click(btnAddSuites);

			}
			wb.close();
			workbook.close();
		}
	}

	String CrSuiteName;

	public void getCreatedSuitePerformedAllFields() throws IOException, AWTException {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet AddSuitesSheet = workbook.getSheet("AddSuites");
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int noOfRowsInCreatedSuite = createdSuiteSheet.getLastRowNum();
		int noOfRowsinAddSuite = AddSuitesSheet.getLastRowNum();

		System.out.println("Total Num Of Rows in Created Suite :" + noOfRowsInCreatedSuite);
		System.out.println("Total Num Of Rows in Add Suite :" + noOfRowsinAddSuite);

		for (int j = noOfRowsinAddSuite; j >= 1; j--) {

			System.out.println("Rows count :" + j);
			System.out.println(noOfTotalRows);
			CrSuiteName = readExcel("Test Datas", "CreatedSuites", noOfRowsInCreatedSuite, 0);
			String getCrlocation = readExcel("Test Datas", "AddSuites", j, 1);
			String getCrLength = readExcel("Test Datas", "AddSuites", j, 2);
			String getCrWidth = readExcel("Test Datas", "AddSuites", j, 3);
			String getCrHeight = readExcel("Test Datas", "AddSuites", j, 4);

			waitForPageLoad();
			sendKeyWithEnter(suitesSearchBox, CrSuiteName);
			waitForPageLoad();
			keyPress(KeyEvent.VK_ENTER);
			keyRelease(KeyEvent.VK_ENTER);
			waitForPageLoad();
			click(clickViewBtn);
			waitForPageLoad();
			waitForPageLoad();
			waitFortextToBePresentInElement(createdSN, CrSuiteName, 10);
			sleep(1000);
			waitForPageLoad();
			Assert.assertEquals("Created SuiteName Mismatched", CrSuiteName, getText(createdSN));
			System.out.println(CrSuiteName);
			Assert.assertEquals("Created Location  Mismatched", getCrlocation, getText(createdLoc));
			System.out.println(getCrlocation);
			Assert.assertEquals("Created Length    Mismatched", getCrLength, getText(createdLength));
			System.out.println(getCrLength);
			Assert.assertEquals("Created Width     Mismatched", getCrWidth, getText(createdWidth));
			System.out.println(getCrWidth);
			Assert.assertEquals("Created Height    Mismatched", getCrHeight, getText(createdHeight));
			System.out.println(getCrHeight);

			if (j <= 0) {

				break;

			} else {
				waitForPageLoad();
				click(rtnToSuitesPage);
				waitForPageLoad();
				clearText(suitesSearchBox);
			}
			workbook.close();
			noOfRowsInCreatedSuite--;
		}
	}

	public void searchCreatedSuiteName() throws IOException {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int noOfRowsInCreatedSuite = createdSuiteSheet.getLastRowNum();

		waitForPageLoad();
		existingSN = readExcel("Test Datas", "CreatedSuites", noOfRowsInCreatedSuite, 0);
		sendKeyWithEnter(suitesSearchBox, existingSN);
		workbook.close();
		waitForPageLoad();
		click(clickImageInSearchedSN);

	}

	public String getBreadCrumLinkText() throws IOException {

		waitForPageLoad();
		BC = BC.replaceAll("createdSN", existingSN);
		String textString = getTextString(BC);
		return textString;
	}

// ****** ------------------- EDIT SUITE ------------------- *****

	public void lastCreatedSuite() throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet AddSuitesSheet = workbook.getSheet("AddSuites");
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int noOfRowsInCreatedSuite = createdSuiteSheet.getLastRowNum();
		int noOfRowsinAddSuite = AddSuitesSheet.getLastRowNum();

		System.out.println("Total Num Of Rows in Created Suite :" + noOfRowsInCreatedSuite);
		System.out.println("Total Num Of Rows in Add Suite :" + noOfRowsinAddSuite);

		CrSuiteName = readExcel("Test Datas", "CreatedSuites", noOfRowsInCreatedSuite, 0);

		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, CrSuiteName);
		waitForPageLoad();
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
		waitForPageLoad();
		click(clickViewBtn);
		waitForPageLoad();
		waitForPageLoad();
		waitFortextToBePresentInElement(createdSN, CrSuiteName, 10);
		sleep(1000);
		waitForPageLoad();
		workbook.close();
	}

	public void clickEditButton() {

		click(btnEditSuite);
	}

	public void delSuiteName() throws IOException {

		deleteUsingSendKeys(suiteName);
		click(btnUpdateSuite);
	}

	public void delLocation() throws IOException {

		click(location);
		selectDropDown(emptyLocation);
		click(btnUpdateSuite);
	}

	public void delMandatoryFields() throws IOException {

		deleteUsingSendKeys(suiteName);
		click(location);
		selectDropDown(emptyLocation);
		waitForFullPageElementLoad();
		click(btnUpdateSuite);

	}

	public void updateDuplicateData(String expSNExistToastMessage) throws Exception {

		click(btnPopupClose);
		deleteUsingSendKeys(suitesSearchBox);
		waitForPageLoad();
		click(suitesModule);
		waitForPageLoad();
		click(btnAddSuites);
		String duplicateSN = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(duplicateSN);
		sendKeys(suiteName, duplicateSN);
		waitForPageLoad();
		click(location);
		String get1stRowLocationDataFromExcelForUpdate = readExcel("Test Datas", "AddSuites", 1, 1);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName",
				get1stRowLocationDataFromExcelForUpdate);
		selectDropDown(dropDownListForLocation);
		click(btnAdd);
		waitForPageLoad();
		Assert.assertEquals("Toast Message is not displayed", "Saved Successfully!!",
				getText(savedSuccessfullToastMsg));
		click(btnToastMsgSuccessOk);
		String crSuiteName = writeExcel("Test Datas", "CreatedSuites", 0, duplicateSN);
		System.out.println(crSuiteName);
		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int lastRowNum = createdSuiteSheet.getLastRowNum();

		String lastCreatedSuite = readExcel("Test Datas", "CreatedSuites", lastRowNum - 1, 0);
		click(suitesModule);
		waitForPageLoad();
		deleteUsingSendKeys(suitesSearchBox);
		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, lastCreatedSuite);
		waitForPageLoad();
		click(clickViewBtn);
		waitForPageLoad();
		sleep(3000);
		click(btnEditSuite);
		waitForPageLoad();
		deleteUsingSendKeys(suiteName);
		String readExcel = readExcel("Test Datas", "CreatedSuites", lastRowNum, 0);
		sendKeys(suiteName, readExcel);

		click(location);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName",
				get1stRowLocationDataFromExcelForUpdate);
		selectDropDown(dropDownListForLocation);

		click(btnUpdateSuite);

		waitForPageLoad();
		Assert.assertEquals("Suite Name already exists  toast message is not displayed", expSNExistToastMessage,
				getText(getSNExitsToastMsg()));

		click(btnToastMsgAlreadyExistOk);

// -------->>> updateDuplicateDatawithDiffLocation <<<---------------

		String get2ndRowLocationDataFromExcelForUpdate = readExcel("Test Datas", "AddSuites", 2, 1);

		dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location",
				get2ndRowLocationDataFromExcelForUpdate);

		click(location);
		selectDropDown(dropDownListForDiffLocation);
		workbook.close();
		click(btnUpdateSuite);
	}

	public void updateDuplicateDatawithDiffLocation() throws IOException {

//     waitForFullPageElementLoad();	
//     String diffLoc = getText(createdLoc);
//	 System.out.println(diffLoc);
//	 
//	 String get1stRowFromExcel = readExcel("Test Datas", "EditSuites", 1, 1);
//	 System.out.println("1st Row From Excel :"+get1stRowFromExcel);
//	 
//	 String get2ndRowFromExcel = readExcel("Test Datas", "EditSuites", 2, 1);
//	 System.out.println("2nd Row From Excel :"+get2ndRowFromExcel);
//	 
//	 dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", get2ndRowFromExcel);
//		
//	 click(location);
//	 selectDropDown(dropDownListForLocation);

//	
//	 if (diffLoc.equals(get1stRowFromExcel)) {
//		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", get2ndRowFromExcel);
//		
//		click(location);
//		selectDropDown(dropDownListForLocation);
//
//	 }
//		else if (diffLoc.equals(get2ndRowFromExcel)) {
//		dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location", get1stRowFromExcel);	
//		
//		click(location);
//		selectDropDown(dropDownListForDiffLocation);
//		
//			}
//	if (diffLoc.equals(getLocationDataFromExcel)) {
//		click(location);
//		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getAnotherLocationDataFromExcel);
//		selectDropDown(dropDownListForLocation);
//		
//		} 
//		else if (diffLoc.equals(getAnotherLocationDataFromExcel)) {
//			click(location);
//			dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location", getLocationDataFromExcel);	
//		selectDropDown(dropDownListForDiffLocation);
//		}

	}

	public void verifyExistSNWithDiffLocationIsUpdatedSuccessfully() throws Exception {

		waitForPageLoad();
		waitForFullPageElementLoad();

		String diffLoc = getText(createdLoc);

		getLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 2, 1);

		getAnotherLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 1, 1);

		if (diffLoc.equals(getLocationDataFromExcel)) {
			Assert.assertEquals("Exist SN with diff location is not updated successfully", getLocationDataFromExcel,
					getText(createdLoc));
		} else if (diffLoc.equals(getAnotherLocationDataFromExcel)) {
			Assert.assertEquals("Exist SN with diff location is not updated successfully",
					getAnotherLocationDataFromExcel, getText(createdLoc));
		}
	}

	String existLocation;
	String getLocationDataFromExcel;
	String getAnotherLocationDataFromExcel;

	public void updateMandatoryFields(String expToastMessage) throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet updatedSuiteSheet = workbook.getSheet("UpdatedSuites");
		Sheet CreatedSuiteSheet = workbook.getSheet("CreatedSuites");
		int lastRowNum = updatedSuiteSheet.getLastRowNum();
		int CRLastRowNum = CreatedSuiteSheet.getLastRowNum();

		String text = readExcel("Test Datas", "CreatedSuites", CRLastRowNum, 0);

		System.out.println("Created Suite :" + text);

		deleteUsingSendKeys(suiteName);

		createSuiteName = (readExcel("Test Datas", "EditSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);

		existLocation = getText(location);
		System.out.println("Exist Location :" + existLocation);
		getLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 2, 1);
		System.out.println("Loc Data 01 :" + getLocationDataFromExcel);
		getAnotherLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 1, 1);
		System.out.println("Loc Data 02 :" + getAnotherLocationDataFromExcel);

		click(location);

		if (existLocation.equals(getLocationDataFromExcel)) {
			dropDownListForLocation = dropDownListForLocation.replaceAll("locationName",
					getAnotherLocationDataFromExcel);
			selectDropDown(dropDownListForLocation);
		} else if (existLocation.equals(getAnotherLocationDataFromExcel)) {
			dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location", getLocationDataFromExcel);
			selectDropDown(dropDownListForDiffLocation);
		}

		click(btnUpdateSuite);

		Assert.assertEquals("Toast Message is not displayed", expToastMessage, getText(savedSuccessfullToastMsg));
		click(btnToastMsgSuccessOk);

		updatedSuiteSheet.createRow(lastRowNum + 1).createCell(1).setCellValue(createSuiteName);

		CreatedSuiteSheet.createRow(CRLastRowNum + 1).createCell(0).setCellValue(createSuiteName);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();

		writeExcelLastRow("Test Datas", "UpdatedSuites", 0, text);

	}

	public String MFSuiteName;

	public void verifyMandatoryFieldsAreUpdatedSuccessfully() throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int lastRowNum = createdSuiteSheet.getLastRowNum();

		MFSuiteName = readExcel("Test Datas", "CreatedSuites", lastRowNum, 0);

		click(suitesModule);
		waitForPageLoad();
		deleteUsingSendKeys(suitesSearchBox);
		sendKeyWithEnter(suitesSearchBox, MFSuiteName);
		waitForPageLoad();
		click(clickViewBtn);
		waitForPageLoad();
		sleep(1000);
		System.out.println("expSN:" + MFSuiteName);
		System.out.println("actSN:" + getText(createdSN));

		waitForPageLoad();

		Assert.assertEquals("Suite Name is not updated successfully", MFSuiteName, getText(createdSN));

		if (existLocation.equals(getLocationDataFromExcel)) {
			Assert.assertEquals("Created Location  Mismatched", getAnotherLocationDataFromExcel, getText(createdLoc));
		} else if (existLocation.equals(getAnotherLocationDataFromExcel)) {
			Assert.assertEquals("Created Location  Mismatched", getLocationDataFromExcel, getText(createdLoc));
		}

		workbook.close();
	}

	public String BCLinkTextForCurrentSuite() throws IOException {

		waitForPageLoad();
		BC = BC.replaceAll("createdSN", MFSuiteName);
		String textString = getTextString(BC);
		return textString;
	}

	String getCrLength;
	String getCrWidth;
	String getCrHeight;

	public void updateAllFields(String expToastMessage) throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet updatedSuiteSheet = workbook.getSheet("UpdatedSuites");
		Sheet CreatedSuiteSheet = workbook.getSheet("CreatedSuites");
		int lastRowNum = updatedSuiteSheet.getLastRowNum();
		int CRLastRowNum = CreatedSuiteSheet.getLastRowNum();

		String text = readExcel("Test Datas", "CreatedSuites", CRLastRowNum, 0);

		System.out.println("Created Suite :" + text);

		deleteUsingSendKeys(suiteName);

		createSuiteName = (readExcel("Test Datas", "EditSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);

		existLocation = getText(location);
		System.out.println("Exist Location :" + existLocation);
		getLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 2, 1);
		System.out.println("Loc Data 01 :" + getLocationDataFromExcel);
		getAnotherLocationDataFromExcel = readExcel("Test Datas", "EditSuites", 1, 1);
		System.out.println("Loc Data 02 :" + getAnotherLocationDataFromExcel);

		click(location);

		if (existLocation.equals(getLocationDataFromExcel)) {
			dropDownListForLocation = dropDownListForLocation.replaceAll("locationName",
					getAnotherLocationDataFromExcel);
			selectDropDown(dropDownListForLocation);
		} else if (existLocation.equals(getAnotherLocationDataFromExcel)) {
			dropDownListForDiffLocation = dropDownListForDiffLocation.replaceAll("location", getLocationDataFromExcel);
			selectDropDown(dropDownListForDiffLocation);
		}

		getCrLength = readExcel("Test Datas", "EditSuites", 1, 2);
		getCrWidth = readExcel("Test Datas", "EditSuites", 1, 3);
		getCrHeight = readExcel("Test Datas", "EditSuites", 1, 4);

		clearText(length);
		sendKeys(length, getCrLength);
		clearText(width);
		sendKeys(width, getCrWidth);
		clearText(height);
		sendKeys(height, getCrHeight);

		click(btnUpdateSuite);

		waitForPageLoad();
		Assert.assertEquals("Toast Message is not displayed", expToastMessage, getText(savedSuccessfullToastMsg));
		click(btnToastMsgSuccessOk);

		updatedSuiteSheet.createRow(lastRowNum + 1).createCell(1).setCellValue(createSuiteName);

		CreatedSuiteSheet.createRow(CRLastRowNum + 1).createCell(0).setCellValue(createSuiteName);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();

		writeExcelLastRow("Test Datas", "UpdatedSuites", 0, text);

	}

	public void verifyAllFieldsAreUpdatedSuccessfully() throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet createdSuiteSheet = workbook.getSheet("CreatedSuites");

		int lastRowNum = createdSuiteSheet.getLastRowNum();

		MFSuiteName = readExcel("Test Datas", "CreatedSuites", lastRowNum, 0);

		deleteUsingSendKeys(suitesSearchBox);
		waitForPageLoad();
		click(suitesModule);
		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, MFSuiteName);
		waitForPageLoad();
		click(clickViewBtn);
		waitForPageLoad();
		sleep(1000);
		System.out.println("expSN:" + MFSuiteName);
		System.out.println("actSN:" + getText(createdSN));

		waitForPageLoad();

		Assert.assertEquals("Suite Name is not updated successfully", MFSuiteName, getText(createdSN));

		if (existLocation.equals(getLocationDataFromExcel)) {
			Assert.assertEquals("Created Location  Mismatched", getAnotherLocationDataFromExcel, getText(createdLoc));
		} else if (existLocation.equals(getAnotherLocationDataFromExcel)) {
			Assert.assertEquals("Created Location  Mismatched", getLocationDataFromExcel, getText(createdLoc));
		}

		Assert.assertEquals("Created Length    Mismatched", getCrLength, getText(createdLength));
		System.out.println(getCrLength);
		Assert.assertEquals("Created Width     Mismatched", getCrWidth, getText(createdWidth));
		System.out.println(getCrWidth);
		Assert.assertEquals("Created Height    Mismatched", getCrHeight, getText(createdHeight));
		System.out.println(getCrHeight);

		workbook.close();
	}

	public void delAllFields() {

		deleteUsingSendKeys(suiteName);
		click(location);
		selectDropDown(emptyLocation);
		clearText(length);
		clearText(width);
		clearText(height);
		click(btnUpdateSuite);
	}

}
