package com.cydeo.Day_10;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HTTPvsHTTPS {

    /*
    Https  is secure connection
    Http is not secure connection
     */


    @Test
    public void test1(){

        // güvenli olmayan bir sayfayı inteli,je de acmanın youlu-1
        given().relaxedHTTPSValidation()
                .when().get();

    }
}
