package com.cydeo.Day_4;

import com.cydeo.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ORDSApiWithJsonPath extends HRTestBase {
      @DisplayName(("GET request to countries"))
    @Test

    public void test1(){

         baseURI="http://100.26.225.217:1000/ords";


         Response response=get("countries");

          JsonPath jsonPath=response.jsonPath();
          String secondCountryName= jsonPath.getString("items[1].country_name");
          System.out.println("secondCountryName = " + secondCountryName);

          //7get all countries id

          List<String>countryID=jsonPath.getList("items.country_id");
          System.out.println("countryID = " + countryID);

//het all county names where their ıd is equal to 2

          List<String>countryNameid2=jsonPath.getList("items.findAll{it.region_id==2}country_name");

          System.out.println("countryNameid2 = " + countryNameid2);


      }
      @DisplayName("GET request /employees with query param")
    @Test
    public void Test2(){

          //we added limit query to get 107 employees
          Response response=given().queryParam("limit",107)
                  .when().get("/employees");

          // get me all meail of employees who is working as IT PROG.
JsonPath jsonPath=response.jsonPath();
          List<String>emailITPROG=jsonPath.getList("items.findAll{it.job-id==\"IT-PROG\"}.email");
          System.out.println("emailITPROG = " + emailITPROG);

          //get me first name of employees who is making more than 10000
          List<String>moreSalaryName=jsonPath.getList("item.findAll{it.salary<10000}.first_name");
          System.out.println("moreSalaryName = " + moreSalaryName);

          //get me the max salaray

          String kingSalary=jsonPath.getString("item.max{it.salary}.first_name");
          System.out.println("kingSalary = " + kingSalary);

      }
}