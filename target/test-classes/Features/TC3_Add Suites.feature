#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date 05/10/2023
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

Feature: Verify Xealei Suites > Add Suites Page

Background:  

    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    
  Scenario Outline: To verify the web url link for suite page
  
    And User must navigate to Suite Module
    Then User must verify the tab url address for suites screen


  Scenario Outline: To verify the validation message is displayed
 
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must click Add button
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"


  Scenario Outline: To verify the field 'Suite Name *' is mandatory
    
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform all fields except Suite Name
    Then User must verify the error message contain for Mandatory field "Please Enter Suite Name"


  Scenario Outline: To verify the field 'Location *' is mandatory
   
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform all fields except Location
    Then User must verify the error message contain for Mandatory field "Please select facility location"


#@TC-ValidationNotIncluded
  #Scenario Outline: To verify the field 'Suite Name *' with invalid data - (Spacebar & tilde)
   #
    #And User must navigate to Suite Module
    #Then User must verify suite page is displayed "Suites"
    #And User must click Add Suite button
    #Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    #And User must perform all fields suite name field alone with invalid data - (Spacebar & tilde)
    #Then User must verify the error message


#@TC-ValidationNotIncluded
  #Scenario Outline: To verify the field 'Suite Name *' on limit for characters
   #
    #And User must navigate to Suite Module
    #Then User must verify suite page is displayed "Suites"
    #And User must click Add Suite button
    #Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    #And User must perform Suite Name field with more than 14 characters
    #Then User must verify that more than "14" characters can not be entered in the Suite Name field


#@TC-ValidationNotIncluded
  #Scenario Outline: To verify the fields 'Length, Width, Heigth' with invalid data - (Characters / Spacebar)
   #
    #And User must navigate to Suite Module
    #Then User must verify suite page is displayed "Suites"
    #And User must click Add Suite button
    #Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    #And User must perform only non mandatory fields with invalid data
    #Then User must verify that the invalid datas are not entered in the fields

#@TC-ValidationNotIncluded
  #Scenario Outline: To verify the fields 'Length, Width, Heigth' on limit for digits
   #
    #And User must navigate to Suite Module
    #Then User must verify suite page is displayed "Suites"
    #And User must click Add Suite button
    #Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    #And User must perform only non mandatory fields
    #Then User must verify that more than "11" digits can not be entered in the respective fields


  Scenario Outline: To verify the 'Close' icon in Add Suites screen
   
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must close the Add Suite popup
    Then User must verify the popup is closed successfully


  Scenario Outline: To verify duplicate validation for 'Suite Name'
   
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform only mandatory fields with existing suiteName and location
    Then User must verify the toast message after perform dupicate datas "Suite Name already exists."



  Scenario Outline: To verify duplicate Suite name with different 'Location'
    
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform only mandatory fields with existing suiteName and different location
    Then User must verify the toast message after perform existing suiteName and different location "Saved Successfully!!"



  Scenario Outline: To verify user able to Add/Create Suites in Suites page by entering only Non-Mandatory fields
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform only non-mandatory fields
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"



  Scenario Outline: To verify user able to Add/Create Suites in Suites page by entering only Mandatory fields
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform only mandatory fields
    Then User must verify the toast message after perform only mandatory fields "Saved Successfully!!"
    Then User must verify mandatory fields are created successsfully



  Scenario Outline: To verify user able to Add/Create Suites in Suites page by entering all fields
    
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform all fields and verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are created successsfully



  Scenario Outline: To verify 'VIEW' button in created Suite screen
    
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the existing suiteName and click the view button
    Then User must verify the Selected Suites should highlight


  Scenario Outline: To verify 'Bread Crums' button in Suites view screen
   
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the existing suiteName and click the image in suites screen
    Then User must verify the breadcrums link should be display with module suite name > selected suite name
    Then User must verify after click the breadcrums link it should be return to Suite searched page 
