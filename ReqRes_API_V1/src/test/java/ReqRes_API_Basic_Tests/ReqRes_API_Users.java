package ReqRes_API_Basic_Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class ReqRes_API_Users {
		
	
	@SuppressWarnings("unchecked")
	@Test
	void registeruser() {
		
		
		@SuppressWarnings({ "rawtypes" })
		HashMap data=new HashMap<String, String>();
		data.put("email","eve.holt@reqres.in");
		data.put("password","pistol");
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/register")
					
		.then()
            .statusCode(200) 
            .body("id", equalTo(4)) 
            .body("token", equalTo("QpwL5tke4Pnpja7X4")) 
            .log().all();		
		
	}
	
	    @Test
		void unsucessfulregisteruser() {
		
		
		@SuppressWarnings({})
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("email","eve.holt@reqres.in");
		
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
	

}
