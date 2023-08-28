Feature: Verify Xealei Login Page 

Scenario Outline: To verify Xealei login page with valid credentials 

Given User is on Xealei login page
When User must perform <"email">,<"password">
Then User must verify once login is successfull "Home"
