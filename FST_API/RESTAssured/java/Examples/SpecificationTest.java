package Examples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationTest {
	
	//declare the request and response specification
	RequestSpecification req;
	ResponseSpecification res;
	int petId;
			
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		//create requestSpec
		req=new RequestSpecBuilder().
				//setting base Uri
				setBaseUri("https://petstore.swagger.io/v2/pet").
				//set content type
				//setContentType(ContentType.JSON).
				addHeader("Content-Type", "application/json").
				addHeader("Accept", "application/json"). //telling the accept only the json type ->addHeader("Accept", "*/*") will accept any type of file
				//addHeader("Authorization", "token ghp_0U ...") for the authentication apis
		build();
		
		
		//create responseSpec
		URL jsonSchema=new URL("https://petstore.swagger.io/v2/swagger.json");
		res=new ResponseSpecBuilder().
				expectStatusCode(200).
				expectBody("status",Matchers.equalTo("alive")).
				expectBody(JsonSchemaValidator.matchesJsonSchema(jsonSchema)).
				expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).
		build();
				
	}
	
	//POST https://petstore.swagger.io/v2/pet
	@Test(priority=1)
	public void postRequestType() throws IOException
	{
		//create a req body
		Map<String,Object> reqBody=new HashMap<>();
		reqBody.put("id", 12345);
		reqBody.put("name", "Praveen");
		reqBody.put("status", "alive");

		//sending request, saving response, 
		Response response=RestAssured.given().
				spec(req).
				body(reqBody).
				log().all().
		when().
			post();
		
		//extracting pet id value
		petId=response.then().extract().path("id");
		
		//asertions
		response.then().
		spec(res).log().all();
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 2)
	public void getRequestType()
	{
		//send request, get response, assert response
		RestAssured.given().
			spec(req).
			pathParam("petId", petId).
		when().
			get("/{petId}").
		then().
			spec(res);
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deleteRequestType()
	{
		//send request, get response, assert response
		RestAssured.given().
			spec(req).
			pathParam("petId", petId).
		when().
			delete("/{petId}").
		then().
			statusCode(200).
			body("message",Matchers.equalTo(String.valueOf(petId))). //another way to convert int to str (""+petId)
			log().all();
	}
	
}
