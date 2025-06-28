@activity3
Feature: Testing with Tags

Scenario Outline: Steps for simple and confirmation alerts
Given User is on the alerts page
When User clicks the <Type> Alert button
Then Alert opens
And Read the text from it and print it
#And write a custom message in it
And Close the alert
And Read the result text

Examples:
| Type    |
| Simple  |
| Confirm |


Scenario: Steps for prompt alerts
Given User is on the alerts page
When User clicks the Prompt Alert button
Then Alert opens
And Read the text from it and print it
And write a custom message in it
And Close the alert
And Read the result text