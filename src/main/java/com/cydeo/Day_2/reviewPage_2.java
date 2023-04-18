package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class reviewPage_2 {

    String baseurl="http://100.26.209.0:8000";

    @Test
    public void Test1(){
        Response response = RestAssured.get(baseurl + "/api/spartans");

       // System.out.println("response.body().asString() = " + response.body().asString());

        System.out.println("response.statusCode() = " + response.statusCode());
        //System.out.println("response.getBody() = " + response.contentType());
        //System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
        //System.out.println("response.body().asString().contains(\"Allen\") = " + response.body().asString().contains("Allen"));

        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertTrue(response.body().asString().contains("Allen"));
        Assertions.assertTrue(response.body().asString().contains("Sinclair"));

    }
    @Test
    public void Test2(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseurl + "/api/spartans/56");
        Assertions.assertEquals(response.contentType(),"application/json");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertTrue(response.body().asString().contains("Ewan"));
        Assertions.assertTrue(response.body().asString().contains("Male"));

        System.out.println("response.header() = " + response.header("Date"));
    }

}
