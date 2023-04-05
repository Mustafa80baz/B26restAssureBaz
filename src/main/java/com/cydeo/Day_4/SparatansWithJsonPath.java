package com.cydeo.Day_4;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class SparatansWithJsonPath extends HRTestBase {
 @DisplayName(("GET one Spartan with json Path"))
    @Test

    public void test1(){
         baseURI="http://100.26.225.217:8000";

         Response response=given().accept(ContentType.JSON).
                queryParam("id",10)
                 .when().get("/api/spartans/{id}");

     Assertions.assertEquals(200,response.statusCode());
     Assertions.assertEquals("application/json",response.contentType());

     //print name with path method
     System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
     //assining response to Jsonpath
     JsonPath jsonPath=response.jsonPath();

     int id=jsonPath.getInt("id");
     String name=jsonPath.get("name");
      String gender=jsonPath.get("gender");
       long phone=jsonPath.getLong("phone");
     System.out.println("id = " + id);
     System.out.println("name = " + name);
     System.out.println("gender = " + gender);
     System.out.println("phone = " + phone);

 }
}