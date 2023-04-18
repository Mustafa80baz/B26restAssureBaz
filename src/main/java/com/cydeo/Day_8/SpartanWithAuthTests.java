package com.cydeo.Day_8;

import com.cydeo.utilities.SpartansAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class SpartanWithAuthTests extends SpartansAuthTestBase {
@DisplayName("GET /api/spartans as a public user(guest) expected 401")
@Test
        public void Test1(){

           given().accept(ContentType.JSON).when().
get("/api/spartans")

            .then().statusCode(401)
            .log().all();

}
@DisplayName("GET/api/spartans as admin user expect 200")
    @Test
    public void Test2(){
    //how to pass admin as a username and password?
    given().auth().basic("admin","admin")
            .and().accept(ContentType.JSON)
            .when().get("/api/spartans")
            .then().statusCode(200).log().all();
}
@DisplayName("DELETE /spartans/ {id} as editor user expect 403")
    @Test

    public void testEditorDelete(){
    given().auth().basic("editor","editor").and()
            .accept(ContentType.JSON)
            .and().pathParam("id",1)
            .when().delete("/api/spartans/{id}")
            .then()
            .statusCode(403).log().body();

}


}
