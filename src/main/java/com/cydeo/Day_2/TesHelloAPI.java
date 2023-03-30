package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesHelloAPI {
    /*
    given no headers provided
    When users send get request to Api hello
    Then respond status code should be 200
    And content type should be "text/plain;charset=UTF-8"
    And header shloud contain date
    And Content length  should be 17
    And body should be "Hello from Sparta"
     */

    @Test
    public void testHello(){
         String baseUrl="http://54.160.103.125:8000";

        Response response= RestAssured.when().get(baseUrl+"/api/hello");//given yok  böyle yaz
          System.out.println("response.prettyPrint() = " + response.prettyPrint());
          //status code
              Assertions.assertEquals(200,response.statusCode());
             //content type
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

     //verify that we have headers name date?
       Assertions.assertTrue( response.headers().hasHeaderWithName("Date"));

//how to get header from response using header key?//header pbaşlıgı altında olanları buraya yazarak  true false verir

        System.out.println("response.headers(\"Content-Length\") = " + response.header("Content-Length"));
        Assertions.assertEquals( "17",response.header("Content-Length"));

        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

//verify   body should be "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());
    }
}
