package com.cydeo.Zülfikar;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class PostMeythod extends HRTestBase {
    //add a new spartan
    @Test
    public void test1(){
String body="{\n"+"\name\":\"Hershel\",\n"
            +"\"gender\":\"Male\",\n"+
            "\"phone\": 5278678322\"}";
        Response response=given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        Assertions.assertEquals(response.statusCode(),200);
    }
}
