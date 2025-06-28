package Examples;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestWithQueryParam()
	{
		//send request, save the response
		Response response=
				RestAssured.given(). //request spec
					baseUri("https://petstore.swagger.io/v2/pet").
					header("Content-Type","application/json").
					queryParam("status", "alive").
				when().
					get("/findByStatus");
							
		//print response status code
		System.out.println("Status Code: "+response.statusLine());
		System.out.println("Status Code: "+response.statusCode());
				
		//print response headers
		System.out.println("Response Headers: "+response.getHeaders().asList());
				
		//print response body
		System.out.println("Response Body: "+response.getBody().asString());
		System.out.println("Response Body: "+response.getBody().asPrettyString());
						
		//extract property from response body
		String petName=response.then().extract().path("[0].name");
		
		//Assertions
		assertEquals(petName, "King Kong");
		
		//RESTAssured assertions
		response.then().
			statusCode(200).
			body("[0].name", Matchers.equalTo("King Kong")).
			body("[0].status", Matchers.equalTo("sold"));
		
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	
	@Test
	public void getRequestWithPathParam()
	{
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			pathParam("petId", 9).
			log().all(). //logs the request
		when().
			get("/{petId}").
		then().
			log().all(). //logs the response
			statusCode(200).
			body("name", Matchers.equalTo("King Kong")).
			body("status", Matchers.equalTo("alive"));
	}
}
