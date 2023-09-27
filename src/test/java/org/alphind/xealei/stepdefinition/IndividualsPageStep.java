/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.pom.PageObjectManager;

import io.cucumber.java.en.Then;

public class IndividualsPageStep  {
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User must navigate to Individuals page and perform all fields <{string}>, <{string}>,<{string}>, <{string}>,<{string}>, <{string}>, <{string}>, <{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>")
    public void user_must_navigate_to_individuals_page_and_perform_all_fields(String Title, String FirstName, String MiddleName, String LastName, String Gender, String Suffix, String DOB, String Suite, String Race, String MaritalStatus, String ResidentialAddress, String MailingAddress, String Pronoun, String EthnicAffiliation, String PreferredLanguage, String Religion, String emFirstName, String emLastName, String Relationship, String PhoneNumber) {

		pom.getIndividualsPage().addIndividuals();
		
	}
	

	@Then("User must verify once the Individual Registration is created successfully {string}")
	public void user_must_verify_once_the_individual_registration_is_created_successfully(String expMessage) {
	    
		
		
	}



}
