@activity2
Feature: Activity to test the login feature

@loginTest
Scenario: Successful login
Given the user on the login-form page
When the user enters the username and password
And click the submit button
Then the user should able to see the confirmation page