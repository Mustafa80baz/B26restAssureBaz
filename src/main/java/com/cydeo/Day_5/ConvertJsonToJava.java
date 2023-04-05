package com.cydeo.Day_5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
public class ConvertJsonToJava {

    @DisplayName("GET all spartans to JAVA structure ")
    @Test

    public void getAllSpartans(){

        String url="http://100.25.24.118:8000";
        Response response=given().accept(ContentType.JSON).
                when().
                get("/api/spartans").then().statusCode(200)
                .extract().response();


    }
}
