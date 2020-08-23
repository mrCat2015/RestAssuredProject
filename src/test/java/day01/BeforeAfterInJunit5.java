package day01;

import org.junit.jupiter.api.*;

public class BeforeAfterInJunit5 {

    // this method runs only once before the entire test


    @BeforeAll
    public static void setUp() {
        System.out.println("This run before All");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Running before the test");
    }

    //@Disabled // same idea as @ignore
    @Test
    public void test1() {
        System.out.println("Test is running");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Running after each test");
    }

    @Test
    public void test2() {
        System.out.println("Test is running");
    }

    @Test
    public void test3() {
        System.out.println("Test is running");


    }

    @AfterAll
    public static void tearDown() {
        System.out.println("This run ALL the way at the end");
    }
}
