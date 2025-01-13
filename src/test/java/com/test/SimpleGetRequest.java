package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleGetRequest {
	
public static void main(String[] args)	
	
	{
		Response res=  RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getContentType());
		System.out.println(res.getStatusLine());
		
	}

}
