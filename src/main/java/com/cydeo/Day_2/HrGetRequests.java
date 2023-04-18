package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HrGetRequests {
     //BeforeAll is a annotation equals to @BeforeClass in TestNG, we use with static methıd name
    @BeforeAll
    public static  void init(){
        //save thisURL inside the veriable so that we dont need to type each http method
        RestAssured.baseURI="http://100.26.209.0:1000/ords/hr";
    }
    @DisplayName("Get request to /regions")
    @Test
    public void test1(){
        Response response=get("/regions");


    }
    @DisplayName("GET request to /regions/2")
@Test
    public void test2(){
          /*
    Given accept type is application/json
       When users send get request /regions2
    Then respond status code should be 200
    And content type equals the applications/json
     And body should be contains  "Americas"
     */

         Response response=get("/regions/2");

          //verify status codeprint the status code
       assertEquals(200,response.statusCode());

        assertEquals("application/json",response.contentType());

  assertEquals(response.body().asString().contains("Americas"),true);


    }

}
