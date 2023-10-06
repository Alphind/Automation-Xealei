#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date 05/10/2023
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

Background:
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"

Feature: Verify Xealei Suites > Edit Suites Page

 
  Scenario Outline: To verify duplicate validation for 'Suite Name' in Edit Suites screen
  
    And User must search the created suite
    And User must click the searched suite 
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button
    And User must perform only mandatory fields with existing suiteName and location
    Then User must verify the toast message after perform dupicate datas "Suite Name already exists."


  Scenario Outline: To verify duplicate Suite name with different 'Location' in Edit Suites screen
   
     And User must search the created suite
    And User must click the searched suite 
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button
    And User must perform only mandatory fields with existing suiteName and different location
    Then User must verify the toast message after perform existing suiteName and different location "Saved Successfully!!"

Scenario Outline: To verify validation message for mandatory fields in edit screen
  
    And User must search the created suite
    And User must click the searched suite 
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button
    And User must delete the suite name and select empty value in location and perform only non mandatory fields
    Then User must verify the error message contains for Mandatory fields "Please Enter Suite Name" and "Please select facility location"
    And User must close the Edit Suite popup
    Then User must verify the Edit Suite popup is closed successfully
    

  Scenario Outline: To verify user able to Edit/Update Suites in Suites page by updating only Mandatory fields
 
     And User must search the created suite
    And User must click the searched suite 
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button
    And User must perform only mandatory fields
    Then User must verify the toast message after perform only mandatory fields "Saved Successfully!!"
    Then User must verify mandatory fields are updated in view screen successfully



  Scenario Outline: To verify user able to Edit/Update Suites in Suites page by updating all fields

    And User must search the created suite
    And User must click the searched suite 
    Then User must verify the created suite details
    And User must click the Edit button
    Then User must verify "Edit Suite" popup should be displayed after click the Edit button
    And User must perform all fields
    Then User must verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are updated in view screen successsfully
