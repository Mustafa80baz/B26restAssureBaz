package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
public abstract class SpartansAuthTestBase {
    @BeforeAll
    public static void init(){
        //save base URL inside this variable so that we dont need to type each http method

         baseURI = "http://50.16.136.119:7000/";

    }
}
