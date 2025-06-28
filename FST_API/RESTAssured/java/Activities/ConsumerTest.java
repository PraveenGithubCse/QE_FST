package Activities;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	// create header map
	Map<String, String> headers = new HashMap<String, String>();

	// create contract
	@Pact(consumer = "userconsumer", provider = "userprovider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		// set header values
		headers.put("Content-Type", "application/json");

		// create JSON body
		DslPart reqResBody = new PactDslJsonBody().numberType("id", 234).stringType("firstName", "Praveen")
				.stringType("lastName", "Bella").stringType("email", "praveen@ex.com");

		// build the fragment(interaction)
		return builder.
		// fragment start
				given("POST request").uponReceiving("a request to create a user").method("POST").path("/api/users")
				.headers(headers).body(reqResBody).willRespondWith().status(201).body(reqResBody).
				// end of fragment
				toPact();
	}

	@Test
	@PactTestFor(providerName = "userprovider", port = "8282") // create a mock server at localhost:8282
	public void postRequestType() {
		// create a request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 234);
		reqBody.put("firstName", "Praveen");
		reqBody.put("lastName", "Bella");
		reqBody.put("email", "praveen@ex.com");

		// send req, get res, log respo
		RestAssured.given().
			baseUri("http://localhost:8282/api/users").
			headers(headers).
			body(reqBody).
			log().all().
		when()
			.post()
		.then().
			log().all().
			statusCode(201).
			body("firstName", Matchers.equalTo("Praveen"));
	}
	

}
