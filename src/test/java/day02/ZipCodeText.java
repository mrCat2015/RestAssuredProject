package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

// you may also add display name at class level like you did at test level
@DisplayName("Testing Zip Code API")
public class ZipCodeText {

    @BeforeAll
    public static void setUp(){
        // THE URL MUST START WITH HTTP OR HTTPS
        // OR REST ASSURED CAN NOT DECIDE IT'S A VALID URL OR NOT
        RestAssured.baseURI = "http://api.zippopotam.us" ;
        RestAssured.basePath = "/us" ;
    }


    @DisplayName("Zip to City Test")
    @Test
    public void ZipCodeTest(){

        given().
                pathParam("zip", "22030").
                accept(ContentType.JSON).
                log().all().
        when().
                get("{zip}").
        then().
                statusCode(is(200)).
                contentType(ContentType.JSON).
                body("country", is("United States")).
                body("places[0].longitude", is("-77.3242")).
                body("places[0].state", is("Virginia")).
                body("'post code'", is("22030"));

        // if a field/key you are trying to get has space
        // then add ''  for example  'post code'


    }

    @DisplayName("City to Zip")
    @Test
    public void testCityToZip(){

        //api.zippopotam.us/us/:state/:city
        given().
                pathParam("state", "VA").
                pathParam("city", "Fairfax").
                log().all().
        when().
                get("/{state}/{city}").
        then().log().all().
                statusCode(200).
                body("'country abbreviation'", is("US")).
                // test the latitude of first place is "38.8458"
                body("places[0].latitude", is("38.8458")).
                // jsonPath hack for getting last item from jsonArray
                // -1 index indicate the last item , only works here not in postman
                body("places[-1].latitude", is("38.7602")). // -1 gets us last of the end
                body("places[-2].latitude", is("38.8528")); // -2 gets us second of the end







    }
}
