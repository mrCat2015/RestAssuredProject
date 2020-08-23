package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SpartanSearchTest_QueryParam {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://100.25.36.30:8000";
        RestAssured.basePath = "/api";
    }

    //http://100.25.36.30:8000/api/spartans/search?gender=male&nameContains=ea
    @DisplayName("Testing /spartans/search Endpoint")
    @Test
    public void testSearch(){

        given().
                log().all().
                queryParam("gender", "male").
                queryParam("nameContains", "ea").
        when().
                get("/spartans/search/").
        then().
                statusCode(200).
                log().all().
                body("numberOfElements", is(3));

    }


}
