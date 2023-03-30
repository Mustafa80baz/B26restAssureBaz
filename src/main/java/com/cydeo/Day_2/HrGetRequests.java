package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {
     //BeforeAll is a annotation equals to @BeforeClass in TestNG, we use with static methıd name
    @BeforeAll
    public static  void init(){
        //save thisURL inside the veriable so that we dont need to type each http method
        RestAssured.baseURI="http://54.160.103.125:1000/ords/hr";
    }
    @DisplayName("Get request to /regions")
    @Test
    public void test1(){
        Response response=RestAssured.get("/regions");


    }
    @DisplayName("GET request to /regions/2")
@Test
    public void test2(){

         Response response=RestAssured.get("/regions/2");

          //verify status codeprint the status code
        Assertions.assertEquals(200,response.statusCode());
       // System.out.println("response.statusCode() = " + response.statusCode());

       // System.out.println("response.prettyPrint() = " + response.prettyPrint());
        //System.out.println("response.contentType() = " + response.contentType());
        Assertions.assertEquals("application/json",response.contentType());
        response.header("body");
        System.out.println("response.prettyPrint() = " + response.prettyPrint());
        Assertions.assertEquals(response.body().asString().contains("Americas"),true);


    }
    /*
    Given accept type is application/json
       When users send get request /regions2
    Then respond status code should be 200
    And content type equals the applications/json
     And body should be contains  "Americas"
     */
}
