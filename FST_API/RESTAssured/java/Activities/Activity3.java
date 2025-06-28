package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	RequestSpecification req;
	ResponseSpecification res;

	@DataProvider(name = "pets")
	public Object[][] petInfo() {
		Map<String, Object> pet1 = new HashMap<String, Object>();
		pet1.put("id", 99012);
		pet1.put("name", "Praveen");
		pet1.put("status", "alive");
		Map<String, Object> pet2 = new HashMap<String, Object>();
		pet2.put("id", 99013);
		pet2.put("name", "Pandu");
		pet2.put("status", "alive");
		return new Object[][] { { pet1 }, { pet2 } };
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		req = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json").build();

		// create responseSpec
		URL jsonSchema = new URL("https://petstore.swagger.io/v2/swagger.json");
		res = new ResponseSpecBuilder().expectStatusCode(200).expectBody("status", Matchers.equalTo("alive"))
				.expectBody(JsonSchemaValidator.matchesJsonSchema(jsonSchema))
				.expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).build();
	}

	@Test(priority = 1, dataProvider = "pets")
	public void addPets(Map<String, Object> pet) {
		RestAssured.given().// use requestspec
				spec(req).// sent requestbody
				body(pet). // sent post req
				log().all().when().post().then().spec(res). // assertions using responseSpec
				body("name", Matchers.equalTo(pet.get("name"))); // additional assertion
	}

	@Test(priority = 2, dataProvider = "pets")
	public void getRequestType(Map<String, Object> pet) {
		// send request, get response, assert response
		RestAssured.given().spec(req).pathParam("petId", pet.get("id")).when().get("/{petId}").then().spec(res)
				.body("name", Matchers.equalTo(pet.get("name")));
	}

	// DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3, dataProvider = "pets")
	public void deleteRequestType(Map<String, Object> pet) {
		// send request, get response, assert response
		RestAssured.given().spec(req).pathParam("petId", pet.get("id")).when().delete("/{petId}").then().statusCode(200)
				.body("message", Matchers.equalTo(String.valueOf(pet.get("id")))). // another way to convert int to str
																			// (""+petId)
				log().all();
	}
}
