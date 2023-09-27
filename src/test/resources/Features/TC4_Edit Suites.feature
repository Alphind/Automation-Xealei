#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

Feature: Verify Xealei Suites Page

  Scenario Outline: To verify user able to Edit/Update Suites in Suites page by entering only Non-Mandatory fields
  
    Given User is on Xealei login page
    When User must perform login with valid "<email>","<password>"
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the created suite
    Then User must verify the created suite details <"SuiteName">, <"Availability">, <"Location">, <"Length">, <"Width"> , <"Height">
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button in Suite page
    And User must perform only non-mandatory fields <"Length">, <"Width">, <"Height">
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"

  Scenario Outline: To verify user able to Edit/Update Suites in Suites page by entering only Mandatory fields
  
    Given User is on Xealei login page
    When User must perform login with valid "<email>","<password>"
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the created suite
    Then User must verify the created suite details <"SuiteName">, <"Availability">, <"Location">, <"Length">, <"Width"> , <"Height">
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button in Suite page
    And User must perform only mandatory fields <"SuiteName">, <"Location">
     Then User must verify the toast message after perform only mandatory fields "Saved Successfully!!"
    Then User must verify mandatory fields are updated successfully

  Scenario Outline: To verify user able to Edit/Update Suites in Suites page by entering all fields
  
    Given User is on Xealei login page
    When User must perform login with valid "<email>","<password>"
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must search the created suite
    Then User must verify the created suite details <"SuiteName">, <"Availability">, <"Location">, <"Length">, <"Width"> , <"Height">
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button in Suite page
    And User must perform all fields <"SuiteName">, <"Availability">, <"Location">, <"Length">, <"Width">, <"Height">
     Then User must verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are updated successsfully
