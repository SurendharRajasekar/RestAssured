package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Waysto_create_post_request_body {
	
	
	//post request body using HashMap
//	@Test(priority=1)
	void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		data.put("name", "Sheerin");
		data.put("location", "Hyderabad");
		data.put("phone", "5725615323");
		String[] coursearr= {"c","c++"};
		data.put("courses", coursearr);
		
		
		given()
		  .contentType("application/json")
		  .body(data)
		
		
		.when()
		 .post("http://localhost:3000/students")
		
		
		.then()
		 .statusCode(201)
		 .body("name", equalTo("Sheerin"))
		 .body("location", equalTo("Hyderabad"))
		 .body("phone", equalTo("5725615323"))
		 .body("courses[0]", equalTo("c"))
		 .body("courses[1]",equalTo("c++"))
		 .header("content-Type", "application/json")
		 .log().all();
		
		
	}
	
	//post request body using org.json library
//	@Test
	void testPostUsingOrgJsonLibrary()
	{
	   JSONObject data=new JSONObject();
	   data.put("name","surenJson");
	   data.put("location", "Singapore");
	   data.put("phone", "2622622622");
	   String coursesarr[]= {"java","dotnet"};
	   data.put("courses", coursesarr);
		
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		
		
		.when()
		 .post("http://localhost:3000/students")
		
		
		.then()
		 .statusCode(201)
		 .body("name",equalTo("surenJson"))
		 .body("location", equalTo("Singapore"))
		 .body("phone", equalTo("2622622622"))
		 .body("courses[0]", equalTo("java"))
		 .body("courses[1]",equalTo("dotnet"))
		 .header("content-Type", "application/json")
		 .log().all();
		
		
	}
	
	
	//post request body using POJO class
//	@Test
	void testPostUsingPOJOClass()
	{
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setName("surenPOJO");
		data.setLocation("DubaiPOJO");
		data.setPhone("5555555555");
		String coursesarr[]= {"frontend","backend"};
		data.setCourses(coursesarr);
		
		
		given()
		  .contentType("application/json")
		  .body(data)
		
		
		.when()
		 .post("http://localhost:3000/students")
		
		
		.then()
		 .statusCode(201)
		 .body("name",equalTo("surenPOJO"))
		 .body("location", equalTo("DubaiPOJO"))
		 .body("phone", equalTo("5555555555"))
		 .body("courses[0]", equalTo("frontend"))
		 .body("courses[1]",equalTo("backend"))
		 .header("content-Type", "application/json")
		 .log().all();
		
		
	}
	
	//post request body using external json file
	@Test
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		
		
		.when()
		 .post("http://localhost:3000/students")
		
		
		.then()
		 .statusCode(201)
		 .body("name",equalTo("surenJsonFile"))
		 .body("location", equalTo("America"))
		 .body("phone", equalTo("1111111111"))
		 .body("courses[0]", equalTo("python1"))
		 .body("courses[1]",equalTo("python2"))
		 .header("content-Type", "application/json")
		 .log().all();
		
		
	}
	
	//delete student record
	@Test(priority=2)
	void testDelete()
	{
		
		given()
		
		.when()
		 .delete("http://localhost:3000/students/4") 
		
		.then()
		 .statusCode(404)
		 .log().all();
		
		
		
		
	}

}
 