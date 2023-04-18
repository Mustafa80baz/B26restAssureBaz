package com.cydeo.Day_7;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class SpartansPostRequestDemo extends SpartansTestBase {

   /*
        Given accept type and content type is json
            And reguset Json body is:
                   "name": "Severus",
    "gender": "Male",
    "phone": 3456821023
            When users sends a Post request to "/api/spartans/{id}"
            Then status code is 201
            And Content type is application/json
            And response plaload/responde /body should contain:
            "A Spartan is Born! " message
            and same data what is posted

    */
@Test
    public void postMethod1(){
    String requestJsonBody="{\"gender\":\"Female\",\n+" +
            "\"name\":\"Aliye\",\"phone\": 3456821023}";

Response response=given().accept(ContentType.JSON).and()
        .contentType(ContentType.JSON)
        .body(requestJsonBody)
        .when()
        .post("/api/spartans");
assertThat(response.statusCode(),is(201));
assertThat(response.contentType(),is("application/json"));

String expectedResponceMessage ="A Spartan is Born!";
//assertThat(response.path("success"),is(expectedResponceMessage));
assertThat(response.path("data.name"),is("Aliye"));
assertThat(response.path("data.gender"),is("Female"));
assertThat(response.path("data.phone"),is(3456821067L));




}
@DisplayName("Post with Map to JSON")//2.way
@Test
    public void postMethod2(){
    //Create a map keep request Json body information
    Map<String,Object>requestJsonMap= new LinkedHashMap<>();
    requestJsonMap.put("name","Aliye");
     requestJsonMap.put("gender","Female");
      requestJsonMap.put("phone",3456821067L);

Response response=given().accept(ContentType.JSON).and()
        .contentType(ContentType.JSON)
        .body(requestJsonMap).log().all()
        .when()
        .post("/api/spartans");
assertThat(response.statusCode(),is(201));
assertThat(response.contentType(),is("application/json"));

String expectedResponceMessage ="A Spartan is Born!";
//assertThat(response.path("success"),is(expectedResponceMessage));
assertThat(response.path("data.name"),is("Aliye"));
assertThat(response.path("data.gender"),is("Female"));
assertThat(response.path("data.phone"),is(3456821067L));

    System.out.println("response.prettyPrint() = " + response.prettyPrint());

}
@DisplayName("Post with Map to Spartan Class")//2.way
@Test
    public void postMethod3(){
    //Create a object from your pojo , send it as a json

    Spartan spartan=new Spartan();//bu java bir veri bunu Json a dönüştürecez
    spartan.setName("Aliye");
    spartan.setGender("Female");
    spartan.setPhone(3456821067L);
    System.out.println("spartan = " + spartan);

    Response response=given().accept(ContentType.JSON).and()
        .contentType(ContentType.JSON)
        .body(spartan).log().all()
        .when()
        .post("/api/spartans");

assertThat(response.statusCode(),is(201));
assertThat(response.contentType(),is("application/json"));

String expectedResponceMessage ="A Spartan is Born!";
//assertThat(response.path("success"),is(expectedResponceMessage));
assertThat(response.path("data.name"),is("Aliye"));
assertThat(response.path("data.gender"),is("Female"));
assertThat(response.path("data.phone"),is(3456821067L));

    System.out.println("response.prettyPrint() = " + response.prettyPrint());

}

@DisplayName("Post with Map to Spartan Class")//2.way
@Test
    public void postMethod4(){
    //Create a object from your pojo , send it as a json

    Spartan spartan=new Spartan();//bu java bir veri bunu Json a dönüştürecez
    spartan.setName("Aliye");
    spartan.setGender("Female");
    spartan.setPhone(3456821067L);
    System.out.println("spartan = " + spartan);
    String expectedResponceMessage ="A Spartan is Born!";

  int idFromPost=given().accept(ContentType.JSON).and()
        .contentType(ContentType.JSON)
        .body(spartan).log().all()
        .when()
        .post("/api/spartans")
            .then()
            .statusCode(201)
            .contentType("application/json")
            .body("success",is(expectedResponceMessage))
          .extract().jsonPath().getInt("data.id");
    System.out.println("idFromPost = " + idFromPost);

//send a get request to id
   Spartan spartansPosted= given().accept(ContentType.JSON)
            .and().pathParam("id",idFromPost)
            .when().get("/api/spartans/{id}")
            .then().statusCode(200).extract().as(Spartan.class);

assertThat(spartansPosted.getName(),is(spartan.getName()));
assertThat(spartansPosted.getGender(),is(spartan.getGender()));
assertThat(spartansPosted.getPhone(),is(spartan.getPhone()));



}
}
