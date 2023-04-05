package com.cydeo.Day_4;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class JsonPathİnsideJson extends HRTestBase {

    @DisplayName(("GET reqyest to countries with Path Method"))
    @Test

    public void test1(){
         baseURI="http://100.26.225.217:1000/ords";

         Response response=given().accept(ContentType.JSON).
                queryParam("q","{\"region_id\":2}")
                 .when().get("countries");

       // Assertions.assertEquals(200,response.statusCode());
        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore

        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first countryId
String firstcountry= response.path("items[0].country_id");
        System.out.println("response.path(\"items[0].country_id\") = " + response.path("items[0].country_id"));

        String secondCountry=response.path("items[1].country_id");
        System.out.println("secondCountry = " + secondCountry);

        //print second country name

        System.out.println("response.path(\"items[1].country_name\") = " + response.path("items[1].country_name"));

        //print Canada link
      //  href": "http://100.26.225.217:1000/ords/hr/countries/CA"

        System.out.println("response.path(\"items[2].links[0].href\") = " + response.path("items[2].links[0].href"));

        //print all country names
        List<String> countryNames=response.path("items.country_name");

        System.out.println("countryNames = " + countryNames);


        //assert all regions ids which are =2

        List<Integer>idList=response.path("items.region-id");

        for (Integer each:idList){
            System.out.println("regionsID = " + each);
            Assertions.assertEquals(2,each);
        }

    }
}
