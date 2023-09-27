#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@Regression
Feature: Verify Xealei Suites Page


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
  
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
    And User must navigate to Suite Module
    Then User must verify suite page is displayed "Suites"
    And User must click Add Suite button
    Then User must verify "Add Suite" popup should be displayed after click the Add Suites button
    And User must perform all fields and verify the toast message after perform all fields "Saved Successfully!!"
    Then User must verify all fields are created successsfully
