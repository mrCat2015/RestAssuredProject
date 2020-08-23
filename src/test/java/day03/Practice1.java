package day03;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class Practice1 {

    @BeforeAll
    // in JUnit 5 @BeforeAll @AfterAll is static method
    // if we do not make it static it does not work because that's how it's defined in the doc
    public static void setUp() {

        RestAssured.baseURI = "http://54.174.216.245";
        RestAssured.basePath = "/api";
        RestAssured.port = 8000;

    }

    @DisplayName("simple test")
    @Test
    public void test1(){

        given().
                log().all().
                queryParam("gender", "female").
        when().
                get("spartans/search/").
        then().
                statusCode(200).
                log().all();  


    }

}
