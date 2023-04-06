package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;
public abstract class SpartansTestBase {
    @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      baseURI="http://100.26.165.187:8000/";

       String dbUrl = "jdbc:oracle:thin:@100.26.165.187:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";
        //DBUtulities.createConnection(dbUrl,dbUsername,dbPassword);


    }
    @AfterAll
    public static  void teardown(){
        //DBUtulities.destroy();
    }

}