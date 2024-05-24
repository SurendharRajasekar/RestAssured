package day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ParsingJsonResponse {
	
	
	@Test
	void testJsonResponse()
	{
		
		
		//approach 1 - using json path
	/*	given()
		 .contentType("ContentType.json")
		
		
	     .when()
	     
	     .get("http://localhost:3000/students")
	     
		
		.then()
		.header("Content-Type", "application/json")
		.body("[2].location", equalTo("Coimbatore"));
		
	*/
		
		//approach 2
		
	
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/students");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.contentType(),"application/json");
		String loc=res.jsonPath().get("[2].location").toString();
	    System.out.println(loc);
	    Assert.assertEquals(loc, "Coimbatore");
	    
	    JSONObject jo=new JSONObject(res.toString());   //converting response to json object to type
	    for(int i=0;i<jo.getJSONArray(null).length();i++)
	    {
	    	jo.getJSONArray(loc)
	    }
	   
		
		
		
	}

}
