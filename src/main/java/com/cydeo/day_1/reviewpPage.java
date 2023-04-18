package com.cydeo.day_1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class reviewpPage {

String spartansBaseUrl="http://100.26.209.0:8000";
    @Test
    public void tetst(){
        Response response = RestAssured.get(spartansBaseUrl + "/api/spartans/");
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getSessionId() = " + response.getSessionId());
        // System.out.println("response.body().asString() = " + response.body().asString());
        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
    }
}



