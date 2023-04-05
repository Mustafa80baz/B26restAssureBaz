package com.cydeo.Day_4;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CBTrainningApiWithJsonPath {
         //BeforeAll is a annotation equals to @BeforeClass in TestNG, we use with static methıd name
    @BeforeAll
    public static  void init(){
        //save thisURL inside the veriable so that we dont need to type each http method
        RestAssured.baseURI="http://api.cybertektraining.com";
    }
    @DisplayName("GET request to individual student")

    @Test
    public void test1(){
        /*
        send a get request to student id 23401 as path parameter and accept header application
        verify status code /content type /content-Encodıng=gzip
        Verify date header exists
        assert that
        First name=Vera    Batch=14 section=12
        emailaddress=aaa@gmail.com   company name=Cybertek    state=IL  zi code:60606
        usıng jsonPath
         */
    }
}
