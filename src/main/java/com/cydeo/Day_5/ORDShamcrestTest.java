package com.cydeo.Day_5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ORDShamcrestTest {
    @DisplayName("GET request to Employees IT_PROG and point and chaining")
    @Test
    public void Test1(){

//along with this statement , l want to save names inside the List<String>

        List<String>names=given().accept(ContentType.JSON)
                .and()
                .queryParam("nameContains","j",
                        "gender","Male")
                .when()
                .get("api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElement",is(6))
                .extract().response().jsonPath().getList("content.name");
        System.out.println("names = " + names);


    }
     @DisplayName("GET request to Employees IT_PROG and point and chaining")
    @Test
    public void Test2(){

//status code

       int statusCode=given().accept(ContentType.JSON)
                .and()
                .queryParam("nameContains","j",
                        "gender","Male")
                .when()
                .get("api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElement",greaterThan(3))
                .extract().response().statusCode();

        System.out.println("names = " + statusCode);


    }
}
