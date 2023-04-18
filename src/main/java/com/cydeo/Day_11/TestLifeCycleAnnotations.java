package com.cydeo.Day_11;

import org.junit.jupiter.api.*;

public class TestLifeCycleAnnotations {
    @BeforeAll// for test NG
    public static void init(){
        System.out.println("\tBefore all is running");
    }
    @BeforeEach // before each Method is testNg version of beforeEach, same logic
    public void initEach(){
        System.out.println( "Before each is running");
    }


        @AfterEach
    public void closeEach(){
        System.out.println("After each is running");
    }
    @Test
    public void tets1(){
        System.out.println("Test 1 is running");
    }
    @Disabled// bu testi çalıştırmaz
    @Test
    public void test2(){
        System.out.println("Test 2 is running");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("Afterall method is running");
    }
}
