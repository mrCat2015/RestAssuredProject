package day01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
// Hamcrest library is a assetion library
// to aim make the test more human readable
// using lots of human readable machers like something is(somethingelse)
// Most importantly restassured use hamcrest matcher
//when we chain multiple rest assured methods
public class Practice2 {

    @Test
    public void test1() {
        // assert 5+4 is 9
        int num1 = 5;
        int num2 = 4;

        // we need these two import for this to work
        // import static org.hamcrest.MatcherAssert.assertThat;
        // import static org.hamcrest.Matchers.*;

        // Hamcrest already come with RestAssured dependency

        // hamcrest library use the assertThat method for all assertions
        // hamcrest use built in matchers to do assertion
        // couple common ones are :
           // -is( some value )
           // -equalTo( some value)
           // -or optionally is ( equalTo(some value) )
           // -not

        assertThat( num1 + num2 ,  is(9)   );
        assertThat(num1 + num2, equalTo(9));
        assertThat(num1 + num2, is(equalTo(9)));

        // not( value )
        // is( not (some value ) )
        // not( equalTo(11) )
        assertThat(num1 + num2, not(10));
        assertThat(num1 + num2, is(not(10)));
        assertThat(num1 + num2, not(equalTo(11)));

        // save your first name and last name into 2 variables
        // test the concatenation result using hamcrest matcher
        String firstName = "Marina";
        String lastName = "Makarova";
        assertThat(firstName + " " + lastName, is("Marina Makarova"));
        assertThat(firstName + " " + lastName, equalTo("Marina Makarova"));
        assertThat(firstName + " " + lastName, is(equalTo("Marina Makarova")));
        assertThat(firstName+lastName, not("Marina Makarova"));

        // String matchers
        // equalToIgnoringCase
        // equalToCompressingWhiteSpace
        // containsString, endsWith, startsWith - test string matching

        // how to check in caseInsenstive manner
        assertThat(firstName + " " + lastName, equalToIgnoringCase("MArina Makarova"));

        // how to ignore all whitespaces
        assertThat(firstName + " "+lastName, equalToCompressingWhiteSpace("Marina Makarova "));


    }
    @DisplayName("Support for collection")
    @Test
    public void test2(){

        List<Integer> numList = Arrays.asList(11, 44, 3, 55, 88, 8);
        // checking the list size is 6
        assertThat(numList.size(), equalTo(6));
        assertThat(numList, hasSize(6));

        // checking the list contains 11
        assertThat(numList, hasItem(88));

        // has items is used to check multiple items : 11, 3, 55
        assertThat(numList, hasItems(11, 3, 55));

        // contains method works like equals here
        // checking the list contains all the items in exact order : 11,44,3,55,88,5
        assertThat(numList, contains(11, 44, 3, 55, 88, 8));

        // checking the list contains all the items in any order  : 11, 44, 55,3,88
        assertThat(numList, containsInAnyOrder(11, 44, 8, 55, 3, 88));


    }

}
