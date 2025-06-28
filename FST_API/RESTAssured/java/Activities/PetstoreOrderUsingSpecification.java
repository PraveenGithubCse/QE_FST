package Activities;

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
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PetstoreOrderUsingSpecification {
	
	RequestSpecification req;
	ResponseSpecification res;
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		req=new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/store/order").
				addHeader("Content-Type", "application/json").
				build();
		
		URL body=new URL("https://petstore.swagger.io/v2/swagger.json");
		res=new ResponseSpecBuilder().
				expectStatusCode(200).
				expectBody("status",Matchers.equalTo("placed")).
				expectBody(JsonSchemaValidator.matchesJsonSchema(body)).
				build();			
				
	}
	
	@Test(priority = 1)
	public void postRequest()
	{
		Map<String, Object> order=new HashMap<>();
		order.put("id", 3);
		order.put("petId", 294653);
		order.put("quantity", 64);
		order.put("status", "placed");
		RestAssured.given().
			spec(req).
			body(order).
			log().all().
		when().
			post().
		then().
			spec(res).
			log().all();
			
	}
	
	@Test(priority = 2)
	public void getRequest()
	{
		RestAssured.given().
			spec(req).
			pathParam("orderId", 3).
			log().all().
		when().
			get("/{orderId}").
		then().
			spec(res).
			log().all();
	}
	
	@Test(priority = 3)
	public void deleteRequest()
	{
		RestAssured.given().
			spec(req).
			pathParam("orderId", 3).
			log().all().
		when().
			delete("/{orderId}").
		then().
			statusCode(200).
			body("message", Matchers.equalTo("3")).
			log().all();
	}
}
