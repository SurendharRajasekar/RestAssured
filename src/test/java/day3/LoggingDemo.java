package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class LoggingDemo {
	
	@Test
	void testlogs()
	{
		given()
		
		.when()
		.get("https://www.google.com")
		
		.then()
		.log().body();
		
	}

}
