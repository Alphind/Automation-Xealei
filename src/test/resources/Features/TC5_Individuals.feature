#/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.
#
#* created by Mohamed Razul, on date
#
#* reviewed by Hajira Begam
#
#* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement
#
#*/

Feature: Verify  Xealei individuals Page 

Scenario Outline: To verify user able to Create Individuals in Individuals page by entering all fields

Given User is on Xealei login page
When User must perform <"email">,<"password">
Then User must verify once login is successfull "Home"
And User must navigate to Individuals page and perform all fields <"Title">, <"FirstName">,<"MiddleName">, <"LastName">,<"Gender">, <"Suffix">, <"DOB">, <"Suite">,<"Race">,<"MaritalStatus">,<"ResidentialAddress">,<"MailingAddress">,<"Pronoun">,<"EthnicAffiliation">,<"PreferredLanguage">,<"Religion">,<"FirstName">,<"LastName">,<"Relationship">,<"PhoneNumber">
Then User must verify once the Individual Registration is created successfully "Individual Saved Successfully"

