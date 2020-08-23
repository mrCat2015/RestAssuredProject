package day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class OpenMovieDB_Test {

    @BeforeAll
    public static void setUp(){


        RestAssured.baseURI = "http://www.omdbapi.com" ;
    }


    @DisplayName("Test Movie API")
    @Test
    public void testMovies(){

        given().
                queryParam("apikey", "26aa5b74").
                queryParam("t", "Catch Me If You Can").
                queryParam("plot", "a doctor").
                log().all().
        when().
                get().// what if my URL is already complete , DO NOTHING
        then().
                statusCode(200).
                log().all().
                contentType(ContentType.JSON).
                // checking title contains Catch Me If You Can
                // if you are searching for exact match use is equalTo
                body("Title", containsString("Catch Me If You Can")).
                body("Year", containsString("2002")).
                body("Ratings[0].Value", is("8.1/10")).
                body("Ratings[-1].Value", is("75/100"))
        ;

    }




}
