package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PracticeDay1 {
	
	int id;
	@Test
	void getAllUser()
	{
		given()
		
		
		.when()
		 .get("https://reqres.in/api/users?page=2")
		
		.then()
		 .statusCode(200)
		 .log().all();
		
	}
	
	@Test
	void createNewUser()
	{
		
		
		HashMap data=new HashMap();
		data.put("name", "sheerin");
		data.put("job","dancer");
		
		id=given()
		.contentType("application/json")
		.body(data)
	
		.when()
	     .post("https://reqres.in/api/users")
	     .jsonPath().getInt("id");
		
		
		
		
	}
	
	

}
