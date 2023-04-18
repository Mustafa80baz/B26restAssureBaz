package com.cydeo.Day_7;

import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class putAndPatchRequestDemo extends SpartansTestBase {
   @DisplayName("PUT request to one spartan for update with Map")
   @Test
   public void PUTRequest(){
       //just like post request we have diffrent options to sen d body  we will go wiht map
       Map<String,Object>putRequestMap=new LinkedHashMap<>();
       putRequestMap.put("name","Aliye");
       putRequestMap.put("gender","Female");
       putRequestMap.put("phone",8877441111L);

       given().contentType(ContentType.JSON)
               .body(putRequestMap)
               .and().pathParam("id",117)
               .when().put("/api/spartans/{id}")
               .then()
               .statusCode(204);
       //send a get request after update, make sure updated field changed ,or the new  info matching with requestBody that we send

   }
   @DisplayName("PATCH request to one spartan for update with Map")
   @Test
   public void PATHRequest(){
       //just like post request we have diffrent options to sen d body  we will go wiht map
       Map<String,Object>putRequestMap=new LinkedHashMap<>();

       putRequestMap.put("phone",8877441111L);

       given().contentType(ContentType.JSON)
               .body(putRequestMap)
               .and().pathParam("id",117)
               .when().patch("/api/spartans/{id}")
               .then()
               .statusCode(204);

}
}
