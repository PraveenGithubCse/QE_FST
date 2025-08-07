Feature: Test for login page
@smoke
Scenario: get all tags
    Given url 'https://conduit-api.bondaracademy.com/api'
    Given path 'tags'
    When method Get
    Then status 200   
    #assertions
    And match response.tags contains "Zoom"
    And match response.tags contains any ["Zoom","Test","Git"]
    And match response.tags !contains "Zoom1"
    #assertions fuzzy matching
    And match response.tags == '#array'
    And match response.tags contains '#string'
    #asertion for schema validation
    And match response.tags == '#[10]'
    
@skipme
Scenario: For post request
	* def cred = {email: "Karate@testingdemo.com", password: "12345678"}
    Given url 'https://conduit-api.bondaracademy.com/api/users/login'
    #multi-line expressions
    And request 
    """
    {
    	user: {email: '#(cred.email)', 
    	password: '#(cred.password)'}
    }
    """
    When method Post
    Then status 200
    
