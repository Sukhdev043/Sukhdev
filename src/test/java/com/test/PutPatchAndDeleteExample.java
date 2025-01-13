package com.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class PutPatchAndDeleteExample {
	
	


	@Test
	public void PutReq()
	{
		
		
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
			put("users/2").
		then().
			statusCode(200).log().all();	
		
	}
	
	@Test
	public void PatchReq()
	{
		
		
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
			patch("users/2").
		then().
			statusCode(200).log().all();	
		
	}
	
	
	@Test
	public void DeleteReq()
	{
		
		
		
		
     	baseURI= "https://reqres.in/api/";
	
     	//https://reqres.in/api/users/2
		when().
			delete("users/2").
		then().
			statusCode(204).log().all();	
		
	}
}
