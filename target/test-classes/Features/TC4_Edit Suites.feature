#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date 05/10/2023
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/
Feature: Verify Xealei Suites > Edit Suites Page

  Background: 
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the created suite
    And User must click the searched suite
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button

  Scenario Outline: To verify the field 'Suite Name *' is mandatory
    And User must delete the Suite Name and click Add button
    Then User must verify the error message contain for Mandatory field "Please Enter Suite Name"

  Scenario Outline: To verify the field 'Location *' is mandatory
    And User must delete the Suite Name and click Add button
    Then User must verify the error message contain for Mandatory field "Please select facility location"

  Scenario Outline: To verify duplicate validation for 'Suite Name' in Edit Suites screen
    And User must perform only mandatory fields with existing suiteName and location
    Then User must verify the toast message after perform dupicate datas "Suite Name already exists."

  Scenario Outline: To verify duplicate Suite name with different 'Location' in Edit Suites screen
    And User must perform only mandatory fields with existing suiteName and different location
    Then User must verify the toast message after perform existing suiteName and different location "Saved Successfully!!"

  Scenario Outline: To verify validation message is displayed under mandatory fields in edit screen and also verify the user able to close the Edit Suite popup
    And User must delete all the fields and click update button
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"
    And User must close the Edit Suite popup
    Then User must verify the Edit Suite popup is closed successfully

  Scenario Outline: To verify user able to Edit/Update Suites by updating only Non-Mandatory fields
    And User must delete the suite name and select empty value in location and perform only non mandatory fields
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"

  Scenario Outline: To verify user able to Edit/Update Suites by updating only Mandatory fields and also verify the 'Bread Crums' link
    And User must perform only mandatory fields
    Then User must verify the toast message after perform only mandatory fields "Saved Successfully!!"
    Then User must verify mandatory fields are updated in view screen successfully
    Then User must verify the breadcrums link should be display with module suite name > updated suite name
    Then User must verify after click the breadcrums link it should be return to Suite searched page
    
  Scenario Outline: To verify user able to Edit/Update Suites by updating all fields 
    And User must perform all fields
    Then User must verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are updated in view screen successsfully

