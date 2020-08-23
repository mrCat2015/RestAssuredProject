package day01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice1 {

    //http://100.25.36.30:8000/api/hello

    @Test
    public void test1() {

        Response response = get("http://100.25.36.30:8000/api/hello");
        //then we need to store it into a variable "response", because when you hover over the path, it returns a "response"
        //once we *store* the response object, we can use it in a lot of ways
        //ex ---> response.statusCode(); --> gives you the code (either store it or print it)
        System.out.println("status code of this response: " + response.statusCode());
        System.out.println("getting status line of this response: " + response.statusLine());
        System.out.println("getting the value of headers: " + response.headers());
        System.out.println("====================================================");
        // try to get Content-Type header value and Date header value
        System.out.println("getting the value of date header: " + response.header("Date"));
        // try to get Content-Type header value and Content-Type header value
        System.out.println("getting the value of Content-Type header: " + response.header("Content-Type"));
        // try to get Content-Type header value and Content-Length header value
        System.out.println("getting the value of Content-Length header: " + response.header("Content-Length"));


    }

    @DisplayName("Testing /hello endpoint")
    @Test
    public void testHello() {

        Response response = get("http://100.25.36.30:8000/api/hello");
        assertEquals(200, response.statusCode());
        assertEquals("17", response.header("Content-Length"), "Wrong Content-Length Header");
        assertEquals("text/plain;charset=UTF-8", response.header("Content-Type"), "Wrong Content-Type Header");
    }


    @DisplayName("Testing /hello endpoint body")
    @Test
    public void testingHelloWordBody() {

        // get the body and assert the body equal to Hello from Sparta
        Response response = get("http://100.25.36.30:8000/api/hello");

        // getting the body as String using asString method of Response object
        System.out.println("response.asString() = " + response.asString());

        // getting the body by calling body method
        // PLEASE DO NOT USE TOSTRING -- IT DOES NOT GIVE YOU THE CONTENT
        // THAT'S WHY ASSTRING METHOD EXISTS
        System.out.println("response.getBody().asString() = " + response.body().asString());
        System.out.println("response.getBody().asString() = " + response.getBody().asString());

        // assert the body is Hello from Sparta , length is 17
        assertEquals(response.body().asString().length(), 17);
        assertEquals(response.body().asString(), "Hello from Sparta");
        assertEquals(response.body().print(), "Hello from Sparta");


    }

    @DisplayName("Printing the response body using method")
    @Test
    public void printBody() {
        Response response = get("http://100.25.36.30:8000/api/hello");
        // easy way to print the response body and return at the same time
        //response.prettyPrint();

        System.out.println("=================================");

        // another way to see the response quick is prettyPeek
        // it print out the entire response
        // it will include all header, status code, body
        // Most importantly, it return same Response object rather than String like prettyPrint
        // it will enable you to call more method of response object after peeking
        response.prettyPeek();

        System.out.println("=================================");
        // I want to see entire response + save the status code into a variable in same statement
        int statusCode = response.prettyPeek().statusCode();
        System.out.println("PRINTING ONLY STATUS CODE: " + statusCode);


    }


}
