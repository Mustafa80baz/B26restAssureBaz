package com.cydeo.Day_5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class HamcrestMathersApiTest {
    @DisplayName("one spartan with Hamcrest")
    @Test
public void test1(){
        /*
            Given accept type json
            And path param is 15
            When users sends a GET request to "/api/spartans/{id}"
            Then status code is 200
            And Content type is application/json
            And response plaload values match the follwing :
            id is 15
            name is "Meta"
            gender is"Female"
            phone is 1938695106

         */
        given().accept(ContentType.JSON).and().pathParam("id",15).when()
                .get("http://54.164.169.98:8000/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and().assertThat().
                contentType("application/json").and().body("id",equalTo(15),
                        "name",is("Meta"),
                        "gender",is("Female"),
                        "phone",is(1938695106));


    }
    @DisplayName("get me one spartan")
        @Test
public void SpartanDataTest(){

        //headers Verification
        given().accept(ContentType.JSON).
and().pathParam("id",17).
                when().

                get("http://54.82.20.4:8000/api/spartans/{id}")

                .then().statusCode(200).
                and().contentType("application/json").
                and().header("Connection",is("keep-alive")).
                and().
                header("Date",notNullValue()).
              and().assertThat()
                .and().body("spartans[0].firstName",is("Wash"))
                .and().body("spartans[0].id",is(17));


    }
    @DisplayName("GET request to spartans//all and chaining")

    @Test
    public void test2(){

        //verify Meade,Nels,Paige are in the list


        given().accept(ContentType.JSON)
                .when()
                .get("http://54.82.20.4:8000/api/spartans/")
                .then()
                .statusCode(200)
                .and()
                .body("spartans.firstName",hasItems("Meade","Nels","Paige"));

    }

}
