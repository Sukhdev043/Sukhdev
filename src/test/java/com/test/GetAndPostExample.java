package com.test;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExample {
	
	//@Test
	public void GetReq()
	{
		baseURI= "https://reqres.in/api/";
		//https://reqres.in/api/users?page=2
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George", "Rachel")); // it's checking whether that George and Rachel name are there or not
		
		
		
	}


	@Test
	public void PostReq()
	{
		Map<String, String> map= new HashMap<>();
		
//		map.put("name", "Sukhdev");
//		map.put("job", "Test Lead");
//		
//		System.out.println(map);
		
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("name", "Sukhdev");
		jsonobj.put("job", "TL");
		 System.out.println(jsonobj.toJSONString());
		
		
     	baseURI= "https://reqres.in/api/";
	
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonobj.toJSONString()).
		when().
			put("/users").
		then().
			statusCode(201).log().all();
		
		
//		body("data[4].first_name", equalTo("George")).
//		body("data.first_name", hasItems("George", "Rachel")); // it's checking whether that George and Rachel name are there or not
//		
		
		
	}
}
