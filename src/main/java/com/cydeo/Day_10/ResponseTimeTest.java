package com.cydeo.Day_10;

import com.cydeo.utilities.SpartansAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ResponseTimeTest extends SpartansAuthTestBase {

    @Test
    public void test1(){
        Response response = given().auth().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .when().get("/api/spartans");
             //   .then()
             //   .time(both(greaterThan(500L)).and(lessThanOrEqualTo(1100L)))
      //  extract.response();

//cevap verme suresini veirir
        System.out.println("response.getTime() = " + response.getTime());

    }
}
