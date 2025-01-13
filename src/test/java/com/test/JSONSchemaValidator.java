package com.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
public class JSONSchemaValidator {
	
	
	// https://www.liquid-technologies.com/online-json-to-schema-converter
	// https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation
	
	@Test
		public void getReq()
		{
		
		    baseURI= "https://reqres.in/api/";
		
	     	
	     // Given
	     	//JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

	     	given().
	     	get("users?page=2").
	     	then().
	     	assertThat().body(matchesJsonSchemaInClasspath("Jsonschema.json")).
	     	statusCode(200).log().all();	
			
		}

}
