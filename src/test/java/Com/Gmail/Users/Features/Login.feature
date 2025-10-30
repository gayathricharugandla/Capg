Feature: Store login
This feature deals with the login functionality.
Background:
Given I navigate to login page
@TC1
Scenario: Login with correct username and correct password
 
	#Given I navigate to login page
	And I entered correct username and password
	And I clicked signin button
	Then Its navigated to the HomePage
@TC2
Scenario: Login with correct username and incorrect password
 
	#Given I navigate to login page
	And I entered correct username
	But invalid credentials
	And I clicked signin button
	Then Its navigated to the error message

	