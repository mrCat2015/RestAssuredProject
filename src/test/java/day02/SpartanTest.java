package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SpartanTest {

    @DisplayName("Get All Spartans")
    @Test
    public void testAllSpartans() {

        String spartanURL = "http://100.25.36.30:8000/api/spartans";
        // how to set base URL , port , base path so I can reuse them
        RestAssured.baseURI = "http://100.25.36.30:8000";
        RestAssured.basePath = "/api";

        // it will create the request URL as is
        // baseURI + basePath + what is after get( "This Part" )

        // i want to explicitly specify I want JSON response from this result

        given().header("Accept", "Application/json").
                when().get("/spartans").then().statusCode(is(200));

    }
    @DisplayName("Get All Spartans 2")
    @Test
    public void testAllSpartans2() {

        // send the same request specifiying the accept header is application/json
        // use baseuri basepath , check status code 200 , contentType header is json

        given()
                .baseUri("http://100.25.36.30:8000")  // alternative way of doing it
                .basePath("/api")
             // .accept("application/json").
                .accept(ContentType.JSON).
                when()
                .get("/spartans").
                then()
                .statusCode( is(200) )
                //.contentType("application/json;charset=UTF-8")
                //.contentType( is("application/json;charset=UTF-8")  )
                // easiest way for contentType is using ContentType enum
                .contentType( ContentType.JSON )  ;

    }


}
