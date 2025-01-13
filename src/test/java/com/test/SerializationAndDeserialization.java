package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SerializationAndDeserialization {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public class Person{
		private String Name;
		private String Job;
		
		Person(String Name, String Job)
		{
			this.Name= Name;
			this.Job= Job;
		}
		
		// getter and setter methods
		
		public String getName()
		{
			return Name;
		}
		public void setName(String Name)
		{
			this.Name= Name;
		}
		public String getJob()
		{
			return Job;
		}
		public void setAge(String Job)
		{
			this.Job= Job;
		}
		
	}
	
	public class APITest{
		
		@BeforeClass
		public void setup()
		{
			RestAssured.baseURI="https://reqres.in/api/";
			//
//			RestAssured.baseURI="http://example.com/api";
			
		}
		@Test
		public void testCreatePersion()
		{
			Person person= new Person("Sukhadewa", "IT");
			
			Response response= RestAssured.given().contentType(ContentType.JSON).body(person) // serialization heppened here
					.post("/users");
			Assert.assertEquals(response.getStatusCode(), 201);
					
		}
		
		
		@Test
		public void testGetsPerson()
		{
			Response response = RestAssured.given().get("/users/1");
			Assert.assertEquals(response.getStatusCode(), 200);
			
			Person person = response.as(Person.class); // desearlization happen here 
			
					Assert.assertEquals(person.getName(), "Sukhadewa");
					Assert.assertEquals(person.getJob(), "IT");
			
		}
	}

}
