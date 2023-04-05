package com.cydeo.Day_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchersIntro {
    @Test
    public void simpleTest(){
        assertThat(5+5,equalTo(10));
        assertThat(5+5,is(equalTo(10)));
       assertThat(5+5, is (20));//is de yazan valu expected deger 5+5=10 gibi //10 yerine 20 yazınca error verir
//matcher has 3 diffrent ways like above
        //it means 2 overloading version
 //negatative version
        assertThat(5+5,is(not(9)));
assertThat(5+5,not(9));
assertThat(5+5,is(not(equalTo(9))));


//number comparison
        //greaterThan()
        assertThat(5+5,greaterThan(9));
        assertThat(5+5,is(not(greaterThan(11))));
        //greaterThanOrEqualTo()


    }
    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){
        String text="B26 is learning Hamcrest";

        assertThat(text,is("B26 is learning Hamcrest"));
        //statrswith method
        assertThat(text,startsWith("B26"));
        //endswith Method
        assertThat(text,endsWith("crest"));

        //check if text contains String learning
        assertThat(text,containsString("learning"));
        //with ıgnoreCasse
        assertThat(text,containsStringIgnoringCase("LEARNING"));
String str="  ";
assertThat(str,emptyString());
assertThat(str.trim(),emptyString());

    }
    @DisplayName("Hamcrest for Collection")
    @Test
    public void testColletion(){
        List<Integer>listOfNumbers= Arrays.asList(1,4,5,6,32,54,66,77,45,23);
        //check the size of the list
        assertThat(listOfNumbers,hasSize(10));
        //check if the 77 is in the list
        assertThat(listOfNumbers,hasItem(77));
        //check multible ıtems like 45,23,54

        assertThat(listOfNumbers,hasItems(45,23,54));

        //chek if all numbers greather than 5
        assertThat(listOfNumbers,everyItem(greaterThan(0)));

    }
}
