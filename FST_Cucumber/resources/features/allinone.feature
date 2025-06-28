@AllScenarios
Feature: System test

@activity1
Scenario: Testing Cucumber programs
 Given the user is on the TS homepage
 When they click on the About Us button
 Then they are redirecting to the About Us page

@activity2 @loginTest
Scenario: Successful login
 Given the user on the login-form page
 When the user enters the username and password
 And click the submit button
 Then the user should able to see the confirmation page
 
@activity4 @loginTest
Scenario: Successful login
 Given the user on the login-form page
 When the user enters the "admin" and "password"
 And click the submit button
 Then the user should able to see the confirmation page "Login Success!"

@activity3
Scenario Outline: Steps for simple and confirmation alerts
 Given User is on the alerts page
 When User clicks the <Type> Alert button
 Then Alert opens
 And Read the text from it and print it
 And Close the alert
 And Read the result text
Examples:
 | Type    |
 | Simple  |
 | Confirm |


@activity3
Scenario: Steps for prompt alerts
 Given User is on the alerts page
 When User clicks the Prompt Alert button
 Then Alert opens
 And Read the text from it and print it
 And write a custom message in it
 And Close the alert
 And Read the result text

@activity6
Scenario: Adding items to a to-do list
 Given user is on the To-Do list page
 When user adds the following tasks
	| task1 |
	| task2 |	
	| task3 |
 Then they can see the task added to the list