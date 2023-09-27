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

public class AddSuitesPage extends BaseClass {

	/*
	 * Description - All the Suites Module/Page locators are stored here.
	 * 
	 */

	public AddSuitesPage() {
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

	@FindBy(xpath = "//button[@class='button4 mat-raised-button mat-button-base']")
	private WebElement btnAdd;

	@FindBy(xpath = "//span[text()='Please Enter Suite Name']")
	private WebElement valMsgForSuiteName;

	@FindBy(xpath = "//span[text()='Please select facility location']")
	private WebElement valMsgForLocation;

	String dropDownListForLocation = "//span[text()='locationName']/parent::mat-option";

//	@FindBy(xpath = "//div[@class='row col-12']//span[@class='btn-txt']")
//	private WebElement actualText;

	@FindBy(xpath = "//span[text()='Saved Successfully!!']")
	private WebElement toastMsg;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement suitesSearchBox;

	@FindBy(xpath = "//span[@class='btn-txt']")
	private WebElement searchCreatedSN;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement createdSN;

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
	private WebElement btnToastMsg;
	
	
	
	@FindBy(xpath = "//span[text()='updatedLocation']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement createdLocation2;

	@FindBy(xpath = "//mat-select[@placeholder='Select location']")
	private WebElement locationAvailability;

	String upDatedLocation = "//span[text()='updatedLocation']/parent::mat-option";

	String availability = "//span[text()='availability']/parent::mat-option";

	@FindBy(xpath = "//span[text()='Edit']/parent::button")
	private WebElement editSuiteButton;

	@FindBy(xpath = "//span[text()='Update']/parent::button")
	private WebElement suiteUpdateButton;

	@FindBy(xpath = "(//span[@class='d-block'])[1]")
	private WebElement updatedSuiteName;

	@FindBy(xpath = "(//span[@class='d-block'])[2]")
	private WebElement updatedLocation;

	@FindBy(xpath = "(//span[@class='d-block'])[3]")
	private WebElement updatedLength;

	@FindBy(xpath = "(//span[@class='d-block'])[4]")
	private WebElement updatedWidth;

	@FindBy(xpath = "(//span[@class='d-block'])[5]")
	private WebElement updatedHeight;

	public WebElement getSuitesPage() {
		return suitesPage;
	}

	public WebElement getAddSuitePopupText() {
		return addSuitePopupText;
	}

	public WebElement getValidationMessageForSuiteName() {
		return valMsgForSuiteName;
	}

	public WebElement getValidationMessageForLocation() {
		return valMsgForLocation;
	}

	public WebElement getToastMessage() {
		return toastMsg;
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

	
	/*
	 * Description - Below methods helps to perform the Testcase actions for Suites
	 * page..
	 * 
	 */

	String createSuiteName;
	public String createdSuite;
	public String getLocationDataFromExcel;

	String SuiteName;
	String Location;
	String Length;
	String Width;
	String Height;
	String createdSuiteName;


	public void navToSuiteModule() {

		waitForPageLoad();
		click(suitesModule);
	}

	public void addSuiteButton() {

		waitForPageLoad();
		click(btnAddSuites);
	}

	public void createSuitePerformedOnlyNonMandatoryFields() throws IOException {

		sendKeys(length, readExcel("Test Datas", "AddSuites", 1, 2));
		sendKeys(width, readExcel("Test Datas", "AddSuites", 1, 3));
		sendKeys(height, readExcel("Test Datas", "AddSuites", 1, 4));
		click(btnAdd);

	}

	public void createSuitePerformedOnlyMandatoryFields() throws Exception {

		createSuiteName = (readExcel("Test Datas", "AddSuites", 1, 0) + dateAndTime());
		System.out.println(createSuiteName);
		sendKeys(suiteName, createSuiteName);
		createdSuite = writeExcel("Test Datas", "AddSuites", 1, 5, createSuiteName);
		click(location);
		getLocationDataFromExcel = readExcel("Test Datas", "AddSuites", 1, 1);
		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", getLocationDataFromExcel);
		selectDropDown(dropDownListForLocation);
		click(btnAdd);

	}

	public void getCreatedSuitePerformedMandatoryField() throws IOException {

		
		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, createdSuite);
		waitForPageLoad();
		click(searchCreatedSN);
	}

	public void createSuitePerformedAllFields(String expToastMessage) throws Exception {

		File file = new File(".//Excel//Test Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("AddSuites");

		int noOfRows = sheet.getLastRowNum();
		System.out.println(noOfRows);
	
		for (int i = 1; i <= noOfRows; i++) {

			SuiteName = sheet.getRow(i).getCell(0).getStringCellValue() + dateAndTime();
			Location = sheet.getRow(i).getCell(1).getStringCellValue();
			Length = sheet.getRow(i).getCell(2).getStringCellValue();
			Width = sheet.getRow(i).getCell(3).getStringCellValue();
			Height = sheet.getRow(i).getCell(4).getStringCellValue();

			waitForPageLoad();
			sendKeys(suiteName, SuiteName);
		    waitForPageLoad();
		    waitForVisiblityOfElement(location, 10);
			click(location);
		    waitForPageLoad();
			dropDownListForLocation = dropDownListForLocation.replaceAll("locationName", Location);
			selectDropDown(dropDownListForLocation);
			waitForPageLoad();
			sendKeys(length, Length);
			sendKeys(width, Width);
			sendKeys(height, Height);
			click(btnAdd);
			waitForPageLoad();
			Assert.assertEquals("Toast Message is not displayed",expToastMessage, getText(toastMsg));
			waitForPageLoad();
			click(btnToastMsg);
			sheet.getRow(i).getCell(5).setCellValue(SuiteName);
			FileOutputStream outputStream = new FileOutputStream(file);
	        workbook.write(outputStream);
			if(i==noOfRows) {
				System.out.println("Row is empty");
	            break;
			} else {
				System.out.println("Row is !empty");
				waitForPageLoad();
			click(btnAddSuites);
			waitForPageLoad();
			click(btnAddSuites);
			}	       
		}   
		}
	

public void getCreatedSuitePerformedAllFields() throws IOException, AWTException {
	
	
	
	File file = new File(".//Excel//Test Datas.xlsx");
	FileInputStream stream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet("AddSuites");

	int noOfRows = sheet.getLastRowNum();

	for (int j = 1; j <= noOfRows; j++) {
		
		
		createdSuiteName = sheet.getRow(j).getCell(5).getStringCellValue();
		Location = sheet.getRow(j).getCell(1).getStringCellValue();
		Length = sheet.getRow(j).getCell(2).getStringCellValue();
		Width = sheet.getRow(j).getCell(3).getStringCellValue();
		Height = sheet.getRow(j).getCell(4).getStringCellValue();
		waitForPageLoad();
		sendKeyWithEnter(suitesSearchBox, createdSuiteName);
		waitForPageLoad();
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
		waitForPageLoad();
		click(searchCreatedSN);
		waitForPageLoad();
		waitForPageLoad();
		waitFortextToBePresentInElement(createdSN, getText(createdSN), 10);
		sleep(1000);
		Assert.assertEquals("Created SuiteName Mismatched", createdSuiteName, getText(createdSN));
		Assert.assertEquals("Created Location  Mismatched", Location,         getText(createdLoc));
		Assert.assertEquals("Created Length    Mismatched", Length,           getText(createdLength));
		Assert.assertEquals("Created Width     Mismatched", Width,            getText(createdWidth));
		Assert.assertEquals("Created Height    Mismatched", Height,           getText(createdHeight));
	
		if(j==noOfRows) {
			
			break;
			
		} else {
			waitForPageLoad();
			click(rtnToSuitesPage);
			waitForPageLoad();
			clearText(suitesSearchBox);
		}
	}
}



}


//		createSuiteName = (readDatafromExcel("Test Datas", "AddSuites", 1, 0) );
//		System.out.println(createSuiteName);
//		sendKeys(suiteName, createSuiteName);
//		createdSuite = writeDataInExcel("Test Datas", "AddSuites",1, 5, createSuiteName);
//		click(location);
//		getLocationDataFromExcel = readDatafromExcel("Test Datas", "AddSuites", 1, 1);
//		dropDownListForLocation = dropDownListForLocation.replaceAll("locationName",getLocationDataFromExcel);
//		selectDropDown(dropDownListForLocation);
//		sendKeys(length, readDatafromExcel("Test Datas", "Suites", 1, 2));
//		sendKeys(width, readDatafromExcel("Test Datas", "AddSuites", 1, 3));
//		sendKeys(height, readDatafromExcel("Test Datas", "AddSuites", 1, 4));
//		waitForElementToBeClickable(addButtonToAddSuite, 10);
//		click(addButtonToAddSuite);

	

//	public void addSuite(String SuiteName, String Location, String Length, String Breadth, String Height)
//			throws Exception {
//
//		waitForPageLoad();
//		click(getBtnSuitesPage());
//		waitForPageLoad();
//		sleep(5000);
//		click(getBtnAddSuites());
//		createdSuitesdata = (readDatafromExcel("TestDatas", "Suites", 1, 0) + dateAndTime());
//		sendKeys(getTxtSuiteName(), createdSuitesdata);
//		writeDataInExcel("TestDatas", "Suites", 1, 5, createdSuitesdata);
//		waitForPageLoad();
//		click(getDropDownLocation());
//		locationDD = locationDD.replaceAll("locationName", readDatafromExcel("TestDatas", "Suites", 1, 1));
//		clickXpath(locationDD);
//		sendKeys(getTxtLength(), readDatafromExcel("TestDatas", "Suites", 1, 2));
//		sendKeys(getTxtWidth(), readDatafromExcel("TestDatas", "Suites", 1, 3));
//		sendKeys(getTxtHeight(), readDatafromExcel("TestDatas", "Suites", 1, 4));
//		waitForElementToBeClickable(getBtnAdd(), 10);
//		click(getBtnAdd());
//		waitForPageLoad();
//		sendKeyWithEnter(getSearchBoxSuites(), createdSuitesdata);
//		waitForPageLoad();
//		click(getTxtCreatedSuiteName());
//	}
//
//	public void editSuite(String SuiteName, String Location, String Availability, String Length, String Breadth,
//			String Height) throws Exception {
//
//		click(getBtnEditSuite());
//		getTxtSuiteName().clear();
//		waitForPageLoad();
//		String updatedSuite = readDatafromExcel("TestDatas", "EditSuite", 1, 0) + dateAndTime();
//		sendKeys(getTxtSuiteName(), updatedSuite + dateAndTime());
//		writeDataInExcel("TestDatas", "EditSuite", 1, 5, updatedSuite);
//		click(getDropDownLocation());
//		upDatedLocationDD = upDatedLocationDD.replaceAll("updatedLocation", readDatafromExcel("TestDatas", "EditSuite", 1, 1));
//		clickXpath(upDatedLocationDD);
////		click(getDropDownAvailability());
////		availabilityDD = availabilityDD.replaceAll("availability", readData("TestDatas", "EditSuite", 1, 6));
////		clickXpath(availabilityDD);
//		getTxtLength().clear();
//		sendKeys(getTxtLength(), readDatafromExcel("TestDatas", "EditSuite", 1, 2));
//		getTxtWidth().clear();
//		sendKeys(getTxtWidth(), readDatafromExcel("TestDatas", "EditSuite", 1, 3));
//		getTxtHeight().clear();
//		sendKeys(getTxtHeight(), readDatafromExcel("TestDatas", "EditSuite", 1, 4));
//		click(getBtnUpdateSuite());
//	}

