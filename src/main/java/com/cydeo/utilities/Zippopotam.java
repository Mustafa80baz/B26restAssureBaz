package com.cydeo.utilities;
import static io.restassured.RestAssured.baseURI;
public class Zippopotam {
     public static void init(){
        // //save thisURL inside the veriable so that we dont need to type each http method
         baseURI = "https://api.zippopotam.us/";
}
}