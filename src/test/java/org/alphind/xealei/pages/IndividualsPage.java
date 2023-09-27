/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pages;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualsPage extends BaseClass{
	
	
	public IndividualsPage() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Individuals']")
	private WebElement btnIndividuals;

	@FindBy(xpath = "//span[text()='Add Individual']")
	private WebElement btnAddIndividuals;
	
	@FindBy(xpath = "//span[text()='Upload']/parent::button")
	private WebElement btnUpload;
	
	@FindBy(xpath = "//span[text()=' Identification ']")
	private WebElement btnIdentification;
	
	@FindBy(xpath = "//span[text()='Select Title']/parent::span//parent::div[1]/parent::div/parent::mat-select")
	private WebElement ddTitle;
	
	@FindBy(xpath = "(//input[@placeholder='First Name'])[1]")
	private WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement txtMiddleName;
	
	@FindBy(xpath = "(//input[@placeholder='Last Name'])[1]")
	private WebElement txtLastName;
	
	@FindBy(xpath = "//mat-radio-button[@ng-reflect-value='notspecify']")
	private WebElement rdoGender;
	
	@FindBy(xpath = "//input[@placeholder='Suffix']")
	private WebElement txtSuffix;
	
	@FindBy(xpath = "//input[@placeholder='DOB']")
	private WebElement txtDOB;
	
	@FindBy(xpath = "//span[text()='Select Suite']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddSuite;
	
	@FindBy(xpath = "//span[text()='Select Race']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddRace;
	
	@FindBy(xpath = "//span[text()='Select Marital Status']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddMaritalStatus;
	
	@FindBy(xpath = "//span[text()=' Address ']")
	private WebElement btnAddress;
	
	@FindBy(xpath = "//input[@placeholder='Residential Address']")
	private WebElement residentalAddress;
	
	@FindBy(xpath = "//input[@placeholder='Mailing Address']")
	private WebElement mailingAddress;
	
	@FindBy(xpath = "//span[text()=' Preference ']")
	private WebElement btnPreference;
	
	@FindBy(xpath = "//input[@placeholder='Nick Name']")
	private WebElement txtNickName;
	
	@FindBy(xpath = "//span[text()='Select Pronoun']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddPronoun;
	
	@FindBy(xpath = "//span[text()='Select Ethnic Affiliation']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddEthnicAffiliation;
	
	@FindBy(xpath = "//span[text()=' Preference ']")
	private WebElement ddPreferredLanguage;
	
	@FindBy(xpath = "//span[text()='Select Preferred Language']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddReligion;
	
	@FindBy(xpath = "(//input[@placeholder='First Name'])[2]")
	private WebElement txtEmFirstName;
	
	@FindBy(xpath = "(//input[@placeholder='Last Name'])[2]")
	private WebElement txtEmLastName;
	
	@FindBy(xpath = "//span[text()='Select Relationship']/parent::span/parent::div/parent::div/parent::mat-select")
	private WebElement ddRelationship;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement txtPhoneNumber;
	
	@FindBy(xpath = "(//mat-icon[text()='arrow_forward'])[3]")
	private WebElement btnLastArrowForward;
	
	@FindBy(xpath = "//span[text()='Confirm']/parent::button")
	private WebElement btnConfirm;
	
	
	
	public WebElement getBtnIndividuals() {
		return btnIndividuals;
	}

	public WebElement getBtnAddIndividuals() {
		return btnAddIndividuals;
	}

	public WebElement getBtnUpload() {
		return btnUpload;
	}

	public WebElement getBtnIdentification() {
		return btnIdentification;
	}

	public WebElement getDdTitle() {
		return ddTitle;
	}
	
	String dropDownTitle = "//span[text()='title']/parent::mat-option";

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtMiddleName() {
		return txtMiddleName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getRdoGender() {
		return rdoGender;
	}

	String gender = "//mat-radio-button[@ng-reflect-value='chooseYourGender']";
	
	public WebElement getTxtSuffix() {
		return txtSuffix;
	}

	public WebElement getTxtDOB() {
		return txtDOB;
	}

	public WebElement getDdSuite() {
		return ddSuite;
	}
	
	String dropDownSuites = "//span[text()='selectSuitesName']/parent::mat-option";
	
	public WebElement getDdRace() {
		return ddRace;
	}
	
	String dropDownRace = "//span[text()='selectRace']/parent::mat-option";

	public WebElement getDdMaritalStatus() {
		return ddMaritalStatus;
	}

	String dropDownMaritalStatus = "//span[text()='selectMaritalStatus']/parent::mat-option";
	
	public WebElement getBtnAddress() {
		return btnAddress;
	}

	public WebElement getResidentalAddress() {
		return residentalAddress;
	}

	public WebElement getMailingAddress() {
		return mailingAddress;
	}

	public WebElement getBtnPreference() {
		return btnPreference;
	}

	public WebElement getTxtNickName() {
		return txtNickName;
	}

	public WebElement getDdPronoun() {
		return ddPronoun;
	}

	String dropDownPronoun = "//span[text()='selectPronoun']/parent::mat-option";
	
	public WebElement getDdEthnicAffiliation() {
		return ddEthnicAffiliation;
	}

	String dropDownEthnicAffiliation = "//span[text()='selectEthnicAffiliation']/parent::mat-option";
	
	public WebElement getDdPreferredLanguage() {
		return ddPreferredLanguage;
	}
	
	String dropDownPreferredLanguage = "//span[text()='selectPreferredLanguage']/parent::mat-option";

	public WebElement getDdReligion() {
		return ddReligion;
	}
	
	String dropDownReligion = "//span[text()='selectReligion']/parent::mat-option";

	public WebElement getTxtEmFirstName() {
		return txtEmFirstName;
	}

	public WebElement getTxtEmLastName() {
		return txtEmLastName;
	}

	public WebElement getDdRelationship() {
		return ddRelationship;
	}

	String dropDownRelationship = "//span[text()='selectRelationship']/parent::mat-option";
	
	public WebElement getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public WebElement getBtnLastArrowForward() {
		return btnLastArrowForward;
	}

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}
	
	
	public void addIndividuals() {
		
		waitForPageLoad();
		click(getBtnIndividuals());
		waitForPageLoad();
		sleep(3000);
		click(getBtnAddIndividuals());
		waitForPageLoad();
		click(getBtnUpload());
		uploadImage("C:\\Xealei Automation\\Xealei\\src\\test\\resources\\Individuals Images\\Image.jpg");	
		waitForPageLoad();
		click(getBtnIdentification());
		click(getDdTitle());
		dropDownTitle = dropDownTitle.replaceAll("title", "Mr");
		selectDropDown(dropDownTitle);
		sendKeys(getTxtFirstName(), "Manoj");
		sendKeys(getTxtMiddleName(), "s");
		sendKeys(getTxtLastName(), "kumar");
		gender = gender.replaceAll("chooseYourGender", "female");
		selectDropDown(gender);
		sendKeys(getTxtSuffix(), "AM");
		sendKeys(getTxtDOB(), "9/05/1999");
		click(getDdSuite());
		dropDownSuites = dropDownSuites.replaceAll("selectSuitesName","John");
		selectDropDown(dropDownSuites);
		click(getDdRace());
		dropDownRace = dropDownRace.replaceAll("selectRace", "Asian");
		selectDropDown(dropDownRace);
		click(getDdMaritalStatus());
		dropDownMaritalStatus = dropDownMaritalStatus.replaceAll("selectMaritalStatus", "Single");
		selectDropDown(dropDownMaritalStatus);
		click(getBtnAddress());
        sendKeys(getResidentalAddress(),"No.1234 Southern street");
        sendKeys(getMailingAddress(),"No.1234 Southern street");
        click(getBtnPreference());
        sendKeys(getTxtNickName(), "Raja kannan");
        click(getDdPronoun());
        dropDownPronoun = dropDownPronoun.replaceAll("selectPronoun","He/Him/His");
        selectDropDown(dropDownPronoun);
        click(getDdEthnicAffiliation());
        dropDownEthnicAffiliation = dropDownEthnicAffiliation.replaceAll("selectEthnicAffiliation","Cuban");
        selectDropDown(dropDownEthnicAffiliation);
        click(getDdPreferredLanguage());
        dropDownPreferredLanguage = dropDownPreferredLanguage.replaceAll("selectPreferredLanguage","English");
        selectDropDown(dropDownPreferredLanguage);
        click(getDdReligion());
        dropDownReligion = dropDownReligion.replaceAll("selectReligion","Cuban");
        selectDropDown(dropDownReligion);
        sendKeys(getTxtEmFirstName(), "Karan");
        sendKeys(getTxtEmLastName(), "Chopra");
        click(getDdRelationship());
        dropDownRelationship = dropDownRelationship.replaceAll("selectRelationship","Others");
        selectDropDown(dropDownRelationship);
        sendKeys(getTxtPhoneNumber(), "4357889640");
        click(getBtnLastArrowForward());
        //click(getBtnConfirm());
	}

	}
