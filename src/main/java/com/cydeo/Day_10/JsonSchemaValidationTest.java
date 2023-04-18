package com.cydeo.Day_10;

import com.cydeo.utilities.SpartansAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidationTest extends SpartansAuthTestBase {
    @DisplayName("Get request to verify one spartans against to schema")
    @Test

    public void schemaValidation(){
        given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id",10)
                .and().auth().basic("admin","admin")
                .when()
                .get("/api/spartans{id}")
                .then().statusCode(200).log().all();
    }
}
