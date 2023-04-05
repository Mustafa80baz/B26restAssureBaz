package com.cydeo.Day_3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ORDSApiTestWithParameters {
        @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://34.234.203.226:1000/ords/hr";
    }
     @DisplayName("GET request to /countries with query Param")
    @Test
    public void Test1(){

            baseURI="http://100.26.225.217:1000/";
            /*
            Given accept type json
            And parameters :q={"region_id":2}
            When users sends a GET request to "/countries"
            Then status code is 200
            And Content type is application/json
            And
            playload should contain "United States of America"
             */
         Response response=given().accept(ContentType.JSON).
                 and ().queryParam("q","{\"region_id\":2}").log().all()
                 .when().get("countries");

         Assertions.assertEquals(200,response.statusCode());
         Assertions.assertEquals("application/json",response.header("Content-Type"));

         Assertions.assertTrue(response.body().asString().contains("United States of America"));

}
}