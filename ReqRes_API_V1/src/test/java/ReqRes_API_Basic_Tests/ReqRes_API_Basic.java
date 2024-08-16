package ReqRes_API_Basic_Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

@SuppressWarnings("unused")
public class ReqRes_API_Basic {
	
	int id;

	@Test(priority=1)
	void getUsers()
	{
		given()
				
		.when()
			.get("https://reqres.in/api/users?page=2")
				
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
			
	}
	

	@SuppressWarnings("unchecked")
	@Test(priority=2)
	void createUser()
	{
		@SuppressWarnings({ "rawtypes" })
		HashMap data=new HashMap<String, String>();
		data.put("name","Nayan");
		data.put("job","Dev Ops Enginner");
		
		
		id=given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		//.then()
		//	.statusCode(201)
		//	.log().all();
			
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{

		HashMap data=new HashMap<String, String>();
		data.put("name","Spider_007");
		data.put("job","Automation Engineer ");
		
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
				
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
			
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
}
