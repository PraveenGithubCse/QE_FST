@activity5
Feature: Activity to test the login feature

@loginTest
Scenario Outline:
Given the user on the login-form page
When the user enters the "<usernames>" and "<passwords>"
And click the submit button
Then the user should able to see the error message

Examples:
 | usernames | passwords |
 | admin1    | password1 |
 | admin2    | password2 |
 | admin3    | password3 |
 | admin4    | password4 |
 | admin5    | password5 |