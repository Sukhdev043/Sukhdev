package com.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.devtools.v129.fetch.model.AuthChallengeResponse.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FISAPITesting {
	
	
	@Test
		public void GetReq()
		{
//			baseURI= "https://api.coindesk.com/v1/bpi";
//			// https://api.coindesk.com/v1/bpi/currentprice.json
//			
//			
//			
//			given().
//			get("/currentprice.json").
//			then().
//			statusCode(200).
//			//log().all().
//			//body("bpi[0].code", equalTo("USD"));
//			body("USD[0].code", hasItems("USD", "GBP","EUR")); // it's checking whether that George and Rachel name are there or not
		// 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
		//git remote set-url origin https://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@github.com/sukhdev043/sukhdev.git
//			
			RestAssured.baseURI= "https://api.coindesk.com/v1/bpi/currentprice.json";
			RequestSpecification http=  RestAssured.given();
			
			io.restassured.response.Response response= http.request(Method.GET,"https://api.coindesk.com/v1/bpi/currentprice.json");
			ResponseBody body= response.body();
			String bodyObj= body.asString();
			//System.out.println(bodyObj);
			
			JsonPath jse= response.jsonPath();
			int count=  jse.getInt("bpi.size()");
			Assert.assertEquals(count, 3);
			System.out.println("count is "+ count);
			String st= jse.getString("bpi.GBP.description");
			System.out.println("Str "+ st);
			Assert.assertEquals(st.contains("British Pound Sterling"), true, "Printing the GBP's description");
			
			String st1= jse.getString("bpi");
			System.out.println(st1);
			Assert.assertEquals(st1.contains("USD"), true, "Printing the GBP's description");
			
			
			
		}

}
