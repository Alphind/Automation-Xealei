#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

@Login-AllScenarios
Feature: Verify Xealei Login Page

  Scenario Outline: To verify the web url link for login page
    Given User should open the browser
    When User must enter the respective URL in browser tab
    Then User must verify the login page is displayed
    Then User must verify the tab url address for login screen


  Scenario Outline: To verify the login page for fields, logo & button.
    Given User is on Xealei login page
    Then User must verify the Login text is displayed
    Then User must verify the Email and password fields contains * symbol
    Then User must verify the Email textbox contains "Email" text
    Then User must verify the Password textbox contains "Password" text
    Then User must verify the eye icon is displayed
    Then User must verify the "Login" text is displayed in Login button
    Then User must verify the Forget password link is displayed
    Then User must verify the copy rights "Powered by Alphind © 2023" text is displayed


  Scenario Outline: To verify the eye icon is working in Password field.
    Given User is on Xealei login page
    When User must enter password in password textbox
    Then User must verify the entered password in password textbox is display as hidden
    And User must click the eye icon
    Then User must verify the password is display as Unhidden


  Scenario Outline: To verify the Privacy Policy link.
    Given User is on Xealei login page
    When User must click the Privacy Policy
    Then User must verify "PRIVACY POLICY" popup should be displayed after click the Privacy Policy link


  Scenario Outline: To verify Xealei Login page with Invalid credentials
    Given User is on Xealei login page
    When User must perform invalid email and password and click Login button
    Then User must verify the error message after click the Login button "User not found"


  Scenario Outline: To verify Xealei Login Page by enter only valid Email/Username
    Given User is on Xealei login page
    When User must enter valid email in email textbox and click Login button without enter password
    Then User must verify the error message contains for password after click the Login button "Please enter password"


  Scenario Outline: To verify Xealei Login Page by enter only valid Password
    Given User is on Xealei login page
    When User must enter valid password in password textbox and click Login button without enter email
    Then User must verify the error message contains for email after click the Login button "Please enter email ID"


  Scenario Outline: To verify Xealei Login Page by enter only valid Email/Username and Invalid Password
    Given User is on Xealei login page
    When User must enter valid email and invalid password and click Login button
    Then User must verify the error message after enter valid email, invalid password and click the Login button "Incorrect password"


  Scenario Outline: To verify Xealei Login Page without enter Email/Username and Password
    Given User is on Xealei login page
    When User click Login button without enter username and password
    Then User must verify the error message contains for both email and password after click the Login button "Please enter email ID" and "Please enter password"

@LOGIN01
  Scenario Outline: To verify Xealei login page with valid credentials
    Given User is on Xealei login page
    When User must perform login with valid email and password
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"


  Scenario Outline: To verify Xealei login page by click the ENTER key with valid credentials
    Given User is on Xealei login page
    When User must perform login with valid email and password by click the Enter key
    Then User must verify once the page is navigate to HOME_DASHBOARD successfully "Home"
