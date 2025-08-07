Feature: Signup new users
	Scenario: Signing up new users using data generators
 		Given url 'https://conduit-api.bondaracademy.com/api/users'
 		* def dataGen = Java.type('Helpers.DataGenerator')
 		* def ranEmail = dataGen.email()
 		* def ranUsrname = dataGen.username()
 		And request
 		"""
 		{
 			"user":{
 				"email":'#(ranEmail)',
 				"password":"12345678",
 				"username":'#(ranUsrname)'
 			}
 		}
 		"""
 		When method Post
 		Then status 201