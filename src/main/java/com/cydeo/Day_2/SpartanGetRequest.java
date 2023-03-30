package com.cydeo.Day_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {

     String baseUrl="http://54.160.103.125:8000";
/*
Given Accept type application/json
When user send GET request to api/spartans end point
Then status code must 200
Then response Content Type musta be application/json
And reponse body should include spartan result
 */
@Test
    public void tets1(){

    /*
    //Given Accept type application/json: bu ne demek?
    bu : postman de "url spartanı" yaz Header tıkla key altına Accept Value bölümüne "application/json yaz demek

    //When user send GET request to api/spartans end point bu ne demek?
bu:postman de GET:154.254.62.124:8000/burası end point buraya "api/spartans" yazmak demek
yani ıp+8000veya 1000 neyse onu arkasına "spartan ve ordions gib şeyleri yaz demek.
Ancak İnteliji de URL in arkasındaki 8000 den sonrasını api/spartan kısmını  sildik
sonrada postman da send dedik

//Then status code must 200
respond bölümünde status a bak 200 olacak
//Then response Content Type musta be application/json
Content type postman de send dedikten sonra sonuçların oldugu Respond bölümündeki Header bölümünde o header aç  KEY:Content type
Value:application/json
//And reponse body should include spartan result
Bu da respond bölümünde Body tıklanarak bakılır Json mu XML mi?
     */
    //Response response= RestAssured.given().accept(ContentType.JSON)
          Response response=RestAssured.given().accept(ContentType.JSON)
            .when().get(baseUrl + "/api/spartans");
//printing status code  from response object
    System.out.println("response.statusCode() = " + response.statusCode());

    //printing response content Type from object
    System.out.println("response.contentType() = " + response.contentType());

    //printing whole reject
    System.out.println("response.prettyPrint() = " + response.prettyPrint());
    //how to do API test assertions
//verify status code is 200
    Assertions.assertEquals(response.statusCode(),200);

    //verify content type is applicatoin/json
    Assertions.assertEquals(response.contentType(),"application/json");
}

@DisplayName("Get one spartan/api/spartans/3 and verify")
@Test
public void test2(){

    /*
    Given header accept is application
    When users send a get request to api/spartans/3
    Then status code should be 200
    And content type should be applicaiton/json
    And Json body should contain Fidale
         */

    Response response=RestAssured.given().accept(ContentType.JSON)
            .when().get(baseUrl+"/api/spartans/3");

    //Print content Type
    System.out.println("response.statusCode() = " + response.statusCode());

    System.out.println("response.contentType() = " + response.contentType());

    System.out.println("response.prettyPrint() = " + response.prettyPrint());

    Assertions.assertEquals(response.contentType(),"application/json");
    Assertions.assertEquals(200,response.statusCode());

    Assertions.assertTrue(response.body().asString().contains("Fidole"));
}
}
