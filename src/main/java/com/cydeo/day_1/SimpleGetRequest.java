package com.cydeo.day_1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

     String url="http://54.160.103.125:8000/api/spartans";

    @Test
    public void test1(){


        Response response = RestAssured.get(url);
        //print response status
        System.out.println(response.statusCode());
// pirnt response body

        System.out.println(response.prettyPrint());


    }



}
