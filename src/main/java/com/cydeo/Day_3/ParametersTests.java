package com.cydeo.Day_3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ParametersTests {
     public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://34.234.203.226:8000/";
    }


   //Given accept type is Json
//Andquery parameter are gender/female nameContains/e
// When user sends GET request to api/spartans/search
    //then respond status code should be 200
    //and respond content type is :application/Json
    //And "Female " should be in response playload
    //And "Janette " should be in response playload
     @DisplayName("GET request to /api/spartans/search with Query Params")
    @Test
    public void Test1(){
baseURI="http://34.234.203.226:8000";

         Response response=given().
                 accept(ContentType.JSON).and().
                queryParam("nameContains","e")
                 .and().queryParam("gender","Female")
                 .when().get("api/spartans/search");

         Assertions.assertEquals(200,response.statusCode());

         Assertions.assertEquals("application/json",response.contentType());

         Assertions.assertTrue(response.body().asString().contains("Female"));
          Assertions.assertTrue(response.body().asString().contains("Janette"));
}

  @DisplayName("GET request to /api/spartans/search with Query Params()MAP")
    @Test
    public void Test2(){

//aynı testi map le yaptık
      Map<String,Object>queryMap=new HashMap<>();
      queryMap.put("nameContents","e");
      queryMap.put("gender","Female");

      Response response=given().log().all()
              .accept(ContentType.JSON).and()
              .queryParams(queryMap)
              .when()
              .get("api/spartans/search");

       Assertions.assertEquals(200,response.statusCode());

         Assertions.assertEquals("application/json",response.contentType());

         Assertions.assertTrue(response.body().asString().contains("Female"));
          Assertions.assertTrue(response.body().asString().contains("Janette"));
}

}

