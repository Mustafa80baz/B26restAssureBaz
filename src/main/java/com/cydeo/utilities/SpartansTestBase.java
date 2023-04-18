package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
public abstract class SpartansTestBase {
    @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      baseURI="http://54.237.73.114:8000";

       String dbUrl = "jdbc:oracle:thin:@54.237.73.114:1521";
        String dbUsername = "SP";
        String dbPassword = "SP";
        //DBUtulities.createConnection(dbUrl,dbUsername,dbPassword);


    }
    @AfterAll
    public static  void teardown(){
        //DBUtulities.destroy();
    }

}