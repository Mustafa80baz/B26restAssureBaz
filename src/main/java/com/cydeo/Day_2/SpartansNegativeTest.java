package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartansNegativeTest {
    @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      RestAssured.baseURI="http://54.160.103.125:8000/";
    }
@DisplayName("GET request to /api/spartans/10")
    @Test
    public void Test1(){
RestAssured.baseURI="http://54.160.103.125:8000/";
           /*
    Given accept type is application/xml
       When users send get request api/spartans/10 end point
    Then respond status code should be 406
    And content type must be application/xml; charset=UTF-8
     And body should be contains  "Americas"
     */

   Response response= given()
           .accept(ContentType.HTML)
           .when()
           .get("/api/spartans/10");

    System.out.println("response.statusCode() = " + response.statusCode());
    //verify status code
  assertEquals(406,response.statusCode());


    //VERİFY CONTENT tYPE

    assertEquals("application/xml;charset=UTF-8",response.contentType());
    }
}
