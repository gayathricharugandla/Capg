Feature: Store login
This feature deals with the login functionality.
Background:
Given I navigated to login page

@TC1
Scenario: Login with correct username and correct password

When I entered "mercury" and "mercury"

And I clicked on signin button

Then Its navigated to the web page

@TC2
Scenario: Login with incorrect username or correct password

When I entered "mercury" and "abcd"

And I clicked on signin button

Then Its navigated to the error msg


@TC3
Scenario: using DataTable



When I entered the following
|gayathri|gayathri|
|mercury|abcd|

And I clicked on signin button

Then Its navigated to the web page

@TC4

Scenario Outline: login with multiple data 

#When I entered username and password

When I insert "<userName>" and "<passWord>"

And I clicked on signin button

Then Its navigated to the web page "<expected result>"


Examples:

| userName | passWord |expected result|

| mercury | mercury |Login Successfully|

| mercury | aaa |Enter your userName and password correct|

| ssss | mercury |Enter your userName and password correct|

