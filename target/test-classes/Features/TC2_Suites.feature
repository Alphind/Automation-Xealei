Feature: Verify Xealei Suites Page 

Scenario Outline: To verify user able to Add/Create and Edit Suite in Suites page by entering all fields

Given User is on Xealei login page
When User must perform <"email">,<"password">
Then User must verify once login is successfull "Home"
And User must navigate to Suites page and perform all fields <"SuiteName">, <"Location">, <"Length">, <"Breadth"> , <"Height">
Then User must verify once the Suite is created successfully
And User must navigate to created Suite page and edit the required fields <"SuiteName">, <"Location">, <"Availability">, <"Length">, <"Breadth"> , <"Height"> 
Then User must verify once the Suite is updated successfully


