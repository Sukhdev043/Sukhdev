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


public class CreateFakeAPI {
	
	// How to create fake API
	/*
	 First thing is that you have to check in your system whether you have node js server in your system or not.
	 How to check it -> run this command in system=> node -v or node --version
	 
	 Second thing is that you have to check in your system whether you have npm in your system or not.
	 How to check it -> run this command in system=> npm -v or npm --version
	 
	 Than install json server in your system
	    run this command : npm install json-server
	    
	  Than start the json server
	  command : json-server --watch db.json
	  
	   http://localhost:3000
	   
	   parameter
	   http://localhost:3000/subjects?name=Automation
	   
	 
	 */


	//@Test
	public void getReq()
	{
		
		
		
		
		
     	baseURI= "http://localhost:3000/";
	
		given().
			
			get("users/").
		then().
			statusCode(200).log().all();	
		
	}
	
	//@Test
	public void post()
	{
		
		
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("firstName", "Rizwan");
		jsonobj.put("lastName", "Chaudhary");
		jsonobj.put("subjectline", 1);
		 System.out.println(jsonobj.toJSONString());
		
		
     	baseURI= "http://localhost:3000/";
	
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonobj.toJSONString()).
		when().
			post("users").
		then().
			statusCode(201).log().all();	
		
	}
	
	//@Test
	public void put()
	{
		
		
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("firstName", "Ram");
		jsonobj.put("lastName", "Choudhary");
		jsonobj.put("subjectline", 1);
		 System.out.println(jsonobj.toJSONString());
		
		
     	baseURI= "http://localhost:3000/";
	
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonobj.toJSONString()).
		when().
			put("users/3").
		then().
			statusCode(200).log().all();	
		
	}
	
	//@Test
	public void patch()
	{
		
		
		JSONObject jsonobj= new JSONObject();
		jsonobj.put("firstName", "Shyama");
		jsonobj.put("lastName", "Choudhary");
		jsonobj.put("subjectline", 1);
		 System.out.println(jsonobj.toJSONString());
		
		
     	baseURI= "http://localhost:3000/";
	
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonobj.toJSONString()).
		when().
			patch("users/4").
		then().
			statusCode(200).log().all();	
		
	}
	
	@Test
	public void DeleteReq()
	{
		
		
		
		
     	baseURI= "http://localhost:3000/";
	
     	//https://reqres.in/api/users/2
		when().
			delete("users/2").
		then().
			statusCode(200).log().all();	
		
	}
}
