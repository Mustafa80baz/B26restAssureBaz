package com.cydeo.Day_5;

import com.cydeo.utilities.HRTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonToJavaTest extends HRTestBase {
    @DisplayName("GET one spartan and deserialize to Map")
    @Test
    public void oneSpartanToMap(){
       Response response= given().pathParam("id",15)
                .when().get("/api/spartan/{id}")
                .then().statusCode(200).extract().response();
        //get the json and  convert it to the map
        Map<String,Object>jsonMap=response.as(Map.class);

        System.out.println(jsonMap.toString());
 //after we got the map, we can use  harcrest or junit assertions to do assertion

    String actualName=(String) jsonMap.get("name");
//assertThat(actualName, is().equals(""));

    }


}
