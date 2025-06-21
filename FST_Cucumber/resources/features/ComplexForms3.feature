@activity2
Feature: Catering Service Form Submission
Scenario: Successful submission of the Catering Service form
Given the user is on the Catering Service web page
When the user enters name into the Full Name field
And the user enters phone number into the Phone field
And the user enters address into the Address field
And the user selects event from the Event Type dropdown
And the user sets the number of guests to 150 using the slider
And the user checks for food preferences
And the user sets date as the Event Date
And the user sets time as the Event Time
And the user clicks the Submit button
And a confirmation message should be displayed