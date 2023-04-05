package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartansTestBase {
    @BeforeAll
    public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
      String baseURI="http://100.25.24.118:8000/";

       String dbUrl = "jdbc:oracle:thin:@100.25.24.118:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";
        DBUtulities.createConnection(dbUrl,dbUsername,dbPassword);


    }
    @AfterAll
    public static  void teardown(){
        DBUtulities.destroy();
    }

}