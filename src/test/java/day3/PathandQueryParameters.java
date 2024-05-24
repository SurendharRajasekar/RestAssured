package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathandQueryParameters {
	
	@Test
	void testPathandQueryParameters()
	{
		
		//https://reqres.in/api/users?page=2&id=5
		given()
		
		.pathParam("mypath", "users") //path parameters
		.queryParam("page",2)   //query parameter
		.queryParam("id", 6) //query parameter
		
		
		.when()
		 .get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
