package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
public class HRTestBase {
 @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://52.91.120.147:1000/ords/hr";

        //get ip address from configuraitons
        String dbUrl = "jdbc:oracle:thin:@52.91.120.147:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

      //  DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }
}
