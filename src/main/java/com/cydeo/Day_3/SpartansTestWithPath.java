package com.cydeo.Day_3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartansTestWithPath {
            @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://34.234.203.226:8000/";
    }
     @DisplayName("GET one spartan with path method")
    @Test
    public void Test1(){
                /*
          Given accept type json
            And path param is 10
            When users sends a GET request to "/api/spartans/{id}"
            Then status code is 200
            And Content type is application/json
            And response plaload values match the follwing :
            id is 10
            name is "Lorenza"
            gender is"Female"
            phone is 3312820936
                 */
baseURI="http://34.234.203.226:8000/";
         Response response=given().accept(ContentType.JSON).and()
                 .pathParam("id",10).
                 when().get("/api/spartans/{id}");

      assertEquals(200,response.statusCode());
      assertEquals("application/json",response.contentType());
      //verify each key has specific value

         System.out.println("response.path(\"id\").toString() = " + response.path("id").toString());
         System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
         System.out.println("response.path(\"gender\").toString() = " + response.path("gender").toString());
         System.out.println("response.path(\"phone\").toString() = " + response.path("phone").toString());

int id=response.path("id");
String name =response.path("name");
String gender=response.path("gender");
long phone=response.path("phone");

         System.out.println("id = " + id);
         System.out.println("name = " + name);
         System.out.println("gender = " + gender);
         System.out.println("phone = " + phone);

         //7verifications
         assertEquals(10,id);
         assertEquals("Lorenza",name);
         assertEquals("Female",gender);
       //  assertEquals("3312820936",phone);

String name2=response.path("name[0]");
         System.out.println("name2 = " + name2);
         // bütün isimlari alma yolu
         List<String>names=response.path("names");
         System.out.println("names = " + names);

for (String name1:names){
    System.out.println("name1 = " + name1);
}
     }
}