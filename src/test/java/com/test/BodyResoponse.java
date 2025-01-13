package com.test;

//import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class BodyResoponse {
	
public static void main(String[] args)	
	
	{
 baseURI= "https://reqres.in/api";

 given().
 get("/users?page=2")
 .then().
 statusCode(200).
 body("data[1].id",  equalTo(8)).
 log().all();
 
 
		
	}

}
