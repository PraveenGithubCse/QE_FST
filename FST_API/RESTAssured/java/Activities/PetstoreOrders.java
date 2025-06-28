package Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PetstoreOrders {
	
	public static void appendGETData(String resBody)
	{
		try {
			File f=new File("src/test/resources/orderGETResponse.json");
			f.createNewFile();
			FileWriter fw=new FileWriter(f.getPath(),true);
			fw.write(resBody+"\n");
			fw.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@DataProvider(name="orderInfo")
	public Object[][] ordersInfo(){
		Map<String,Object> order1=new HashMap<>();
		order1.put("id", 1);
		order1.put("petId", 345678);
		order1.put("quantity", 6);
		order1.put("status", "placed");
		
		Map<String,Object> order2=new HashMap<>();
		order2.put("id", 9);
		order2.put("petId", 987644);
		order2.put("quantity", 67);
		order2.put("status", "placed");
		
		return new Object[][]{
				{order1},{order2}	
		};
	}
	
	@Test(priority = 1)
	public void postRequest()
	{
		Map<String,Object> order=new HashMap<>();
		order.put("id", 7);
		order.put("petId", 123344);
		order.put("quantity", 4);
		order.put("status", "placed");
		
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/order").
			header("Content-Type","application/json").
			body(order).
			log().all().
		when().
			post().
		then().
			log().all().	
			statusCode(200).
			body("status", Matchers.equalTo("placed"));
	}
	
	@Test(priority = 2,dataProvider = "orderInfo")
	public void addOrderInfo(Map order)
	{
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/order").
			header("Content-Type","application/json").
			body(order).
			log().all().
		when().
			post().
		then().
			statusCode(200).
			body("status", Matchers.equalTo("placed")).
			body("id", Matchers.equalTo(order.get("id"))).
			body("petId",Matchers.equalTo(order.get("petId"))).
			log().all();
	}
	
	@Test(priority = 3)
	public void postRequestUsingFile() throws IOException
	{
		FileInputStream f= new FileInputStream("src/test/resources/orderInfo.json");
		Response res=RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/order").
			header("Content-Type","application/json").
			body(f).
			log().all().
		when().
			post();
		String resBody=res.getBody().asPrettyString();
		appendGETData(resBody);
		res.then().
			statusCode(200).
			body("id", Matchers.equalTo(8)).
			log().all();
		f.close();
			
	}
	
	@Test(priority = 4)
	public void getRequest()
	{
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/inventory").
			contentType(ContentType.JSON).
			log().all().
		when().
			get().
		then().
			statusCode(200).
			log().all();
	}
	
	@Test(priority = 5,dataProvider = "orderInfo")
	public void getRequestUsingPathParam(Map order) throws MalformedURLException
	{
		URL url=new URL("https://petstore.swagger.io/v2/swagger.json");
		Response res=RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/order").
			header("Content-Type","application/json").
			pathParam("orderId", order.get("id")).
			log().all().
		when().
			get("/{orderId}");		
		res.then().
			statusCode(200).
			body("petId", Matchers.equalTo(order.get("petId"))).
			body("status", Matchers.equalTo(order.get("status"))).
			body(JsonSchemaValidator.matchesJsonSchema(url)).
			log().all();
		String resBody= res.getBody().asPrettyString();
		
		appendGETData(resBody);
	}
	
	@Test(priority = 6,dataProvider = "orderInfo")
	public void deleteRequest(Map order)
	{		
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/store/order").
			header("Content-Type","application/json").
			pathParam("orderId", order.get("id")).
			log().all().
		when().
			delete("/{orderId}").
		then().
			statusCode(200).
			body("message",Matchers.equalTo(""+order.get("id"))).
			log().all();
	}
}
