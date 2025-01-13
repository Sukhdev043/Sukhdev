package com.test;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapRequestXML {
	
	@Test
	public void ValidSoapXML() throws IOException
	{   
		File file= new File("./SoapRequest/Add.xml");
		if(file.exists())
		{
			System.out.println("file is exists in system");
		}
		FileInputStream FIS= new FileInputStream(file);
		
		String RequestBody= IOUtils.toString(FIS, "UTF-8");
		baseURI="http://www.dneonline.com";
		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(RequestBody).
		when().
		post("/calculator.asmx").
		then().
		statusCode(200).log().all();
	}

}
