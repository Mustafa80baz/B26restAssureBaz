package com.cydeo.Day_3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class TaskEmployeesJobTitle {
         @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://34.234.203.226:1000/ords/hr";
    }
     @DisplayName("GET request to /employees with query Param")
    @Test
    public void Test1(){

            baseURI="http://34.234.203.226:1000/ords/hr";
            /*
            Given accept type json
            And parameters :q={employees/IT_PROG}
            When users sends a GET request to  employees and get only employees who works as a IT_PROG"
            Then status code is 200
            And Content type is application/json
            And

             */

         Response response= given().accept(ContentType.JSON).
                 and().queryParam("q","{ \"job_id\": \"IT_PROG\"}")
                 .when().get("/employees");

         System.out.println("response.prettyPrint() = " + response.prettyPrint());
         Assertions.assertEquals(200,response.statusCode());

         Assertions.assertEquals("application/json",response.header("Content-Type"));

         Assertions.assertTrue(response.body().asString().contains("IT_PROG"));

     }
     //how to get who is working for 10000 dolalr
   // { "job_id": "IT_PROG"}

    //postman de "job_id" yerine "salary" ve ""IT_PROG" yerine de 10000 yazacaz
}