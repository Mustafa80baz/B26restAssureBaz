package com.cydeo.Day_3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SpartanTestWithParameters {

    @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://34.234.203.226:8000/";//Ip ler dinamictir değişir
    }
    @DisplayName("GET request to /api/spartans/{id}with ID 5")
    @Test
    public void Test1(){


//Given accept type is Json
//And Id parameter value is 5
// When user sends GET request to api(spartans/{id}
    //then respond status code should be 200
    //and respond content type is :application/Json
    //And "Blythe " should be in response playload
     Response response= given().accept(ContentType.JSON).
             and().pathParam("id",5).
              when().get("/api/spartans/{id}");

        //verify status code
        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("application/json",response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Blythe"));

}
//Given accept type is Json
//And Id parameter value is 500
// When user sends GET request to api(spartans/{id}
    //then respond status code should be 404
    //and respond content type is :application/Json
    //And "Not Found " should be in response playload
     @DisplayName("GET request to /api/spartans/{id} Negative Test")
    @Test
    public void Test2(){
baseURI="http://34.234.203.226:8000";

        Response response=given().accept(ContentType.JSON)
                .and().pathParam("id",500)
                .when().get("/api/spartans/{id}");

         System.out.println("response.statusCode() = " + response.statusCode());
         System.out.println("response.contentType() = " + response.contentType());
         System.out.println("response.body().asString().contains(\"Not Found\") = " + response.body().asString().contains("Not Found"));
         System.out.println("response.prettyPrint() = " + response.prettyPrint());

     }
}