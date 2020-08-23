package day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SpartanTest_Parameters {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://100.25.36.30:8000";
        RestAssured.basePath = "/api";
    }

    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testSingleSpartan( ){

        given().
                log().all().
                pathParam("id", 100).
                accept(ContentType.JSON).
        when().
                get("/spartans/{id}").
        then().
                log().all().
                statusCode(is(200));

    }

    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testSingleSpartans2(){

        given().
                log().all().
        when().
                get("/spartans/{id}", 100).
        then().
                log().all().
                statusCode(is(200));

    }

    @DisplayName("Testing /spartans/{id} Body")
    @Test
    public void testSingleSpartanBody() {

        given(). //RequestSender
                log().all().
                pathParam("id", 97).
        when().
                get("/spartans/{id}").
        then(). //ValidateResponse
                log().all().
                statusCode(is(200))
                //.body("JSON PATH", is("THE_VALUE"))
                .body("id", is(97))
                .body("name", is("Saleem"))
                .body("gender", is("Male"))
                .body("phone", is(6586151920L));
    }




}
