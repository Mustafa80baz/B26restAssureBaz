package com.cydeo.Day_10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class FormulaOneXmlTest {
    @BeforeAll
    public static void setUp(){
        //http://ergast.com/api/f1/drivers/alonso
     baseURI="http://ergast.com";
     basePath="/api/f1";


    }
    @Test
    public void test1(){
       Response response= given().pathParam("driver","alonso")
                .when()
                .get("/drivers/{driver}")
                .then().statusCode(200).log().all()
                .extract().response();


        XmlPath xmlPath=response.xmlPath();
        // get family name

        //get code and URL

        String givenname= xmlPath.getString("MRData.DriverTable.Driver.GivenName");
        System.out.println("givenname = " + givenname);
String Familyname= xmlPath.getString("MRData.DriverTable.Driver.FamilyName");
        System.out.println("Familyname = " + Familyname);
    //get driver name
        String drverId= xmlPath.getString("MRData.DriverTable.Driver.FamilyName");
        System.out.println("drverId = " + drverId);
    }

}
