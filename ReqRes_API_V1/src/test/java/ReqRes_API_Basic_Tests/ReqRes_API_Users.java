package ReqRes_API_Basic_Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;


public class ReqRes_API_Users {
	String Email = "eve.holt@reqres.in";
    String Pass = "pistol";
	String token = "QpwL5tke4Pnpja7X4";
	
	@SuppressWarnings("unchecked")
	@Test
	void registeruser() {
		
		
		@SuppressWarnings({ "rawtypes" })
		HashMap data=new HashMap<String, String>();
		data.put("email",Email);
		data.put("password",Pass);
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/register")
					
		.then()
            .statusCode(200) 
            .body("id", equalTo(4)) 
            .body("token", equalTo(token)) 
            .log().all();		
		
	}
	
	    @Test
		void unsucessfulregisteruser() {
		
		
		@SuppressWarnings({})
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("email",Email);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/register")
			
		.then()
            .statusCode(400) 
            .body("error", equalTo("Missing password")) 
            .log().all();
		
	}
	
	    @Test
	    void sucessfullLogin() {
		
			@SuppressWarnings({})
			HashMap<String, String> data=new HashMap<String, String>();
			data.put("email",Email);
			data.put("password", Pass);
			
			given()
				.contentType("application/json")
				.body(data)
			
			.when()
				.post("https://reqres.in/api/login")
				
			.then()
	            .statusCode(200) 
	            .body("token", equalTo(token)) 
	            .log().all();
			
		}
	    
	    @Test
	    void unsucessfullLogin() {
		
			@SuppressWarnings({})
			HashMap<String, String> data=new HashMap<String, String>();
			data.put("email",Email);
			
			given()
				.contentType("application/json")
				.body(data)
			
			.when()
				.post("https://reqres.in/api/login")
				
			.then()
	            .statusCode(400) 
	            .body("error", equalTo("Missing password")) 
	            .log().all();
			
		}
	    
}
