package Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity2 {
	//POST 
	@Test(priority=1)
	public void postRequestType() throws IOException
	{
		//import json file 
		FileInputStream inputJSON=new FileInputStream("src/test/resources/userinfo.json");
		
		RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/user"). //set baseURI
				header("Content-Type","application/json"). //set headers
				body(inputJSON). //pass request body from file
				when().post(). //send post resquest
			
		
		//assertion
		then().  
		body("message",Matchers.equalTo("19901")).
		body("code",Matchers.equalTo(200));
		
		//close the json file
		inputJSON.close();
	}
	
	@Test(priority=2)
	public void getUserInfo()
	{
		//import json file to write to
		File outputJSON=new File("src/test/resources/userGETResponse.json");
		
		Response response= RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/user") //set baseURI
				.header("Content-Type","application/json") //set headers
				.pathParam("username","justin")
		.when().get("/{username}");
		
		//get response body
		String resBody=response.getBody().asPrettyString();
		System.out.println("GET Response Body:\n" + resBody);
		
		try
		{
			//create JSON file 
			outputJSON.createNewFile();
			//write response body to external file
			FileWriter writer=new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//assertions
		response.then().
		body("id",Matchers.equalTo(19901)).
		body("username",Matchers.equalTo("justin")).
		body("firstName",Matchers.equalTo("Justin")).
		body("lastName",Matchers.equalTo("Case")).
		body("email",Matchers.equalTo("justincase@mail.com")).
		body("password",Matchers.equalTo("password123")).
		body("phone",Matchers.equalTo("7893200359"));
	}
	
	@Test(priority = 3)
	public void deleteUser() throws IOException
	{
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/user").//set baseUri
			header("Content-Type","application/json").//set headers
			pathParam("username","justin").//add path parameter
		when().delete("/{username}").//send post request
		//assertions
		then().
		body("code",Matchers.equalTo(200)).
		body("message",Matchers.equalTo("justin"));
		
	}
}
