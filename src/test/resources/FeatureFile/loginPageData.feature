Feature: login functionality

Scenario: Checking timesheet for the user
Given I load the "https://opensource-demo.orangehrmlive.com/"
Then I enter username and password into the respective field
|username|password|
|Admin|admin123|
Then I click element1 "//*[@id='btnLogin']"
Then I click element2 "//span[contains(text(),'Timesheets')]"
Then I enter "Cecil Bonaparte" into element "employee"
And I click element3 "//*[@id='btnView']"