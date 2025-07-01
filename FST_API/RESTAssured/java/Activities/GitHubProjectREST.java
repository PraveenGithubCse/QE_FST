package Activities;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectREST {
	RequestSpecification req;
	ResponseSpecification res;
	int keyId;

	@BeforeClass
	public void setUp() {
		req = new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token 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")
				.build();
		res = new ResponseSpecBuilder()
				. expectBody("title",Matchers.equalTo("TitleKey"))// Assertion for title
				. expectBody("key",Matchers.equalTo("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDkMuUSae4bPQ5cD+lesnL/kbe3pDeP2F9X+n3uluawoFh4V2yCZ2BmehX9cc6HuhYfaYRIzvyjv5IlJH9cs3w+xKDGgxqX1JTYGsQF6iY71jpmtjkWxDyYICntfPz4ba9KAD5D/dm41jzmds8rT4qR72t+vbR79RK4FJ625yUYLZuLtqWRUhO9bLK0lN45PXGbM0IRks0BYAQOdDB/XRdq31N2KkYHk+9hLcyRwH8m8meqJJfnZHbgrzxcKb/G55BjmDl/Xx0kvEwwoc/X3jMMoGz08MPDk12rqpmKMNRLqSZf+1J/OJ7OSTUU4XswAQQLShsyBOFrPRb2e1AAGlhv"))// Assertion for key
				.expectResponseTime(Matchers.lessThan(5000L))
				.build();
	}

	@Test(priority = 1)
	public void postRequest() {
		Map<String, Object> key = new HashMap<>();
		key.put("title", "TitleKey");
		key.put("key","ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDkMuUSae4bPQ5cD+lesnL/kbe3pDeP2F9X+n3uluawoFh4V2yCZ2BmehX9cc6HuhYfaYRIzvyjv5IlJH9cs3w+xKDGgxqX1JTYGsQF6iY71jpmtjkWxDyYICntfPz4ba9KAD5D/dm41jzmds8rT4qR72t+vbR79RK4FJ625yUYLZuLtqWRUhO9bLK0lN45PXGbM0IRks0BYAQOdDB/XRdq31N2KkYHk+9hLcyRwH8m8meqJJfnZHbgrzxcKb/G55BjmDl/Xx0kvEwwoc/X3jMMoGz08MPDk12rqpmKMNRLqSZf+1J/OJ7OSTUU4XswAQQLShsyBOFrPRb2e1AAGlhv");
		Response response = RestAssured.given().
				spec(req).
				body(key).
				log().all().
		when().
			post();
		keyId = response.
					then().
					statusCode(201).
					log().all().
					extract().
					path("id");
		//response.then().statusCode(Matchers.anyOf(Matchers.equalTo(200), Matchers.equalTo(202)));
	}

	@Test(priority = 2)
	public void getRequest() {
		RestAssured.given().
			spec(req).
			pathParam("keyId", keyId).
			log().all().
		when().
			get("/{keyId}").
		then().
			statusCode(200).
			spec(res).
			log().all();
	}

	@Test(priority = 3)
	public void deleteRequest() {
		RestAssured.given().
			spec(req).
			pathParam("keyId", keyId).
			log().all().
		when().
			delete("/{keyId}").
		then().
		statusCode(204).
		log().all();
	}
}
