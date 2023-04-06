package com.cydeo.Day_6;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class spartanPojoGetRequestTest extends SpartansTestBase {

    @DisplayName("Get one spartan and  convert it to spartan Object")
    @Test
    public void oneSapartanPojo(){


     Response response1= given().accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .extract().response();

     //de serialize ---> Json to Pojo(Java custom class)
        //2 way to do this
        //1.using as() method
        //we convert to json response to spartan object with the help of  jackson
        //as() method uses jacskson to deserialize(converting Json to Java class)
         Spartan spartan15=response1.as(Spartan.class);
       System.out.println(spartan15);
        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());

        //2.way of deserialize json to Java
        //using JsonPath  to deserialize to custom class
        JsonPath jsonPath=response1.jsonPath();
        Spartan s15=jsonPath.getObject("",Spartan.class);
        System.out.println("s15 = " + s15);
        System.out.println("s15.getName() = " + s15.getName());
        System.out.println("s15.getPhone() = " + s15.getPhone());

    }
    @DisplayName("Get one spartan from search endpoint result and use POJO")
    @Test
    public void spartanSearchWithPojo(){

     //Spartans /search?nameContains =Male
    //send get request to above end point and save first object with type of Spartan POJO
   JsonPath jsonPath=given().accept(ContentType.JSON)
            .and().queryParam("nameContains","a","gender","Male")
           .when().get("/api/spartans/search")
           .then().statusCode(200)
           .extract().response().jsonPath();

   //get the first spartant from content and put in to spartan object
        Spartan s1=jsonPath.getObject("content[0]", Spartan.class);
        System.out.println("s1 = " + s1);
        System.out.println("s1.getName() = " + s1.getName());
        System.out.println("s1.getGender() = " + s1.getGender());
    }


}

