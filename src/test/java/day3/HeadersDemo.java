package day3;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
	
	@Test
	public void headersdemo()
	{
		given()
		
		
		.when()
		
		.get("https://www.google.com")
		
		.then()
		.header("Content-type","text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip");
		
		
	}

	@Test
	public void CaptureHeaders()
	{
		Response res=given()
	   	             .when()
		             .get("https://www.google.com");
		             
		 //get single header
		           //String headervalue= res.getHeader("Content-Type");
		           //System.out.println("contentvalue header value"+ headervalue);
		
		//get multple headers
		         Headers headers_value=res.getHeaders();
		         for(Header hd:headers_value)
		          {
		        	  System.out.println("Headers : -------");
		        	  System.out.println(hd.getName() + hd.getValue());
		          }
		
		
	}
}
