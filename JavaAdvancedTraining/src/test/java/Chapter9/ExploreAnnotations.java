package Chapter9;

import org.junit.jupiter.api.*;

/**
 * @author Kabelo Tlhape
 * This class demonstrate use of different annotations from JUnit's library
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreAnnotations {

    @BeforeAll
    static void setUp(){
        System.out.println("Getting things started...\n");
    }
    @AfterAll
    static void finish(){
        System.out.println("\nAll tests are completed...");
    }
    @BeforeEach
    void beforeEachTest(){
        System.err.println("Before Each Test...");
    }
    @Test
    @DisplayName("TC1 - First Test")
    @Order(1)
    @Tag("Sanity")
    void firstTest(){
        System.out.println("First Test Method");
    }
    @Test
    @DisplayName("TC2 - Second Test")
    @Order(3)
    @Tag("Regression")
    void secondTest(){
        System.out.println("Second Test Method");
    }
    @Test
    @DisplayName("TC3 - Third Test")
    @Order(2)
    @Tag("Integration")
    void thirdTest(){
        System.out.println("Third Test Method");
    }
    @Test
    @DisplayName("TC4 - Forth Test")
    @Order(4)
    @Tag("Integration")
    @Tag("Regression")
    void forthTest(){
        System.out.println("Forth Test Method");
    }
}
