package com.cydeo.Day_6;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartansTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class spartanPojoGetRequestTest extends SpartansTestBase {
    String url="http://100.26.165.187:8000/api/spartans";
    @DisplayName("Get one spartan and  convert it to spartan Object")
    @Test
    public void oneSapartanPojo(){
         Response response = RestAssured.get(url);

     Response response1= given().accept(ContentType.JSON)
                .and().pathParam("id","15")
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .extract().response();

     //de serialize ---> Json to Pojo(Java custom class)
        //2 way to do this
        //1.using as() method
        //we convert to json response to spartan object with the help of  jackson
        //as() method uses jacskson to deserialize(converting Json to Java class)
         Spartan spartan15=response.as(Spartan.class);
       System.out.println(spartan15);
        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());

        //2.way of deserialize json to Java

    }
}

