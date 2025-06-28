package Activities;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Activity1 {
	//POST https://petstore.swagger.io/v2/pet
	@Test (priority = 1)
	public void postRequestTest()
	{
		//create the request body
		Map<String, Object> reqBody=new HashMap<>();
		reqBody.put("id", 56788);
		reqBody.put("name", "chichoo");
		reqBody.put("status", "alive");		
		
		//send the request , get response, assert response
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			body(reqBody).
		when().
			post().
		then().
			statusCode(200).
			body("name",Matchers.equalTo("chichoo")).
			body("status", Matchers.equalTo("alive")).
			log().all();
	}
	
	//PUT https://petstore.swagger.io/v2/pet
	@Test(priority = 2)
	public void putRequestTest()
	{
		//create the request body
		Map<String, Object> reqBody=new HashMap<>();
		reqBody.put("id", 56788);
		reqBody.put("name", "pikoooo");
		reqBody.put("status", "alive");		
		
		//send the request , get response, assert response
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			body(reqBody).
		when().
			put().
		then().
			statusCode(200).
			body("name",Matchers.equalTo("pikoooo")).
			body("status", Matchers.equalTo("alive")).
			log().all();
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void getRequestTest()
	{
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			pathParam("petId", 56788).
		when().
			get("/{petId}").
		then().
			statusCode(200).
			body("name", Matchers.equalTo("pikoooo")).
			body("status", Matchers.equalTo("alive")).
			log().all();
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 4)
	public void deleteRequestType()
	{
		//
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			pathParam("petId", 56788).
		when().
			delete("/{petId}").
		then().
			log().all().
			statusCode(200).
			body("message", Matchers.equalTo("56788"));
	}
	
}
