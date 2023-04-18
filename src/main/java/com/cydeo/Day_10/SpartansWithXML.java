package com.cydeo.Day_10;

import com.cydeo.utilities.SpartansAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpartansWithXML extends SpartansAuthTestBase {
    @DisplayName("Get requet to /api/spartans and verify  xml")

    @Test
public void getSpartansXml(){

        //we will ask for xml response
        //assert statuc code 200
        //assert content type is xml (we got xml response)
        //verify first spartans name is Meade
     given().accept(ContentType.XML)
                .and()
                .auth().basic("admin","admin")
                .when()
                .get("/api/spartans")
                .then()
                .statusCode(200)
                .contentType("application/xml;charset=UTF-8")
                .body("list.item[0].name",is("Meade"))
                .body("list.item[0].gender",is("Male"))
                .log().all();



    }
    @DisplayName("Get request api/spartans with xmlPath")
    @Test
    public void testXmlPath(){
        Response response = given().accept(ContentType.XML)
                .and()
                .auth().basic("admin", "admin")
                .when()
                .get("/api/spartans");

        //get response xml body and save inside the xmlpath
        XmlPath xmlPath=response.xmlPath();
        String name =xmlPath.getString("List.item[1].name");
        System.out.println("name = " + name);
        int id=xmlPath.getInt("List.item[2].id");
        System.out.println("id = " + id);
        long phone= xmlPath.getLong("List.item[4].phone");;
        System.out.println("phone = " + phone);
        //how to get all names and save into list of string
        List<String> names=xmlPath.getList("List.item.name");
        System.out.println("names = " + names);
}
}