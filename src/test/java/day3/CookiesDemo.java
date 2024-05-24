package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import java.util.Map;

public class CookiesDemo {
	
	@Test
	void testCookies()
	{
		given()
		
		
		.when()
		 .get("https://www.google.com")
		
		.then()
		.statusCode(200)
		.cookie("AEC","AQTF6HwQV6XeyhoxDt-qQ2XCmaA4cFZ9447o5dpLHZKLDW3ge9THrRLfpg")
		 .log().all();
		
	}
	@Test(priority=2)
	void GetCookies()
	{
		
		Response res = given()
		
		.when()
		 .get("https://www.google.com");
		 
		 
		 
		//get single cookie info
		//String cookie_value=res.getCookie("AEC");
		//System.out.println(cookie_value);
		
		//get all cookie info
		
		Map<String, String> cookie_all_values = res.getCookies();
		
		for(String key_value:cookie_all_values.keySet())
		{
			String cookie_value = res.getCookie(key_value);
			System.out.println(key_value + "  "+ cookie_value);
			
		}
		
		
		
	}


}
