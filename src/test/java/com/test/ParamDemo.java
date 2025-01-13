package com.test;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
 
public class ParamDemo {
 
 
    @Test
    public void verifyQueryParam() {
 
        String endpoint = "https://reqres.in/api/";
 
        // Given
        given()
                .queryParam("page", "2")
 
                // When
                .when()
                .get(endpoint + "users/")
 
                // Then
                .then()
 
                // To verify the response body
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2)).log().all();
 
    }
}
