#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date 05/10/2023
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/
@EditSuites-AllScenario
Feature: Verify Xealei Suites > Edit Suites Page

  Background: 
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    Then User must searched the created suite
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button

  Scenario Outline: To verify the field 'Suite Name *' and 'Location *' is mandatory
    And User must delete the Suite Name and click Add button
    Then User must verify the error message under Suite Name field "Please Enter Suite Name"
    And User must update all fields with empty Location
    Then User must verify the error message under Location field "Please select facility location"

  Scenario Outline: To verify validation message is displayed under mandatory fields in edit screen and also verify the user able to close the Edit Suite popup
    And User must delete all the fields and click update button
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"
    And User must close the Edit Suite popup
    Then User must verify the Edit Suite popup is closed successfully

  Scenario Outline: To verify user able to Edit/Update Suites by updating only Non-Mandatory fields
    And User must delete the suite name and select empty value in location and perform only non mandatory fields
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"

  Scenario Outline: To verify duplicate validation for 'Suite Name' and to verify user able to update exist suiteName with different 'Location'
    And User must update only mandatory fields with existing datas and verify the toast message '"Suite Name already exists."' and user change the different location
    Then User must verify the toast message after perform existing suiteName and different location "Saved Successfully!!"
    Then User must verify the existing suiteName and different location is updated successfully

  Scenario Outline: To verify user able to Edit/Update Suites by updating only Mandatory fields and also verify the 'Bread Crums' link
    And User must update only mandatory fields and verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify mandatory fields are updated in view screen successfully
    Then User must verify the breadcrums link should be display with module suite name > updated suite name
    Then User must verify after click the breadcrums link it should be return to Suite searched page

  Scenario Outline: To verify user able to Edit/Update Suites by updating all fields
    And User must update all fields and verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are updated in view screen successsfully
