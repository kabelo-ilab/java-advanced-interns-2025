package Chapter9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {
    @ParameterizedTest(name = "Test Pass Mark - [{index}] : {arguments}")
    @ValueSource(doubles = {77.5, 50, 64.9, 56, 83.8, 47})
    void testPassMark(double testMark){
        boolean expected = true;

        boolean actual = testMark >= 65;

        assertEquals(expected, actual, "Pass mark should be >= 65 [" + testMark + "]");
    }

    @ParameterizedTest(name = "Test names - [{index}] : {arguments}")
    @ValueSource(strings = {"Kate", "Jake", "Jessica", "Carol", "Tom", "John", "Jackson", "Mike"})
    void testNameStartsWithJ(String name){
        assertTrue(name.startsWith("J"), name + " doesn't start with 'J'");
    }

    @ParameterizedTest
    @CsvSource(value = {"Milk,20.99,50","Cheese,55,25","Eggs,78.99,70", "Bread,18.99,15"})
    void testLowStockProducts(String name, double price, int qtyInStock){
        assertTrue(qtyInStock < 50, "There is enough stock [" + qtyInStock + "] for [" + name + "]");
        System.out.println("name = " + name + ", price = " + price + ", qtyInStock = " + qtyInStock);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Student Test Marks.csv", numLinesToSkip = 1)
    void testFailedStudents(String firstname, String lastname, int testMark){

        assertTrue(testMark < 65, "Student [" + firstname + " " + lastname + "] " +
         "managed to pass the test [" + testMark + "]");

        System.out.println("firstname = " + firstname + ", lastname = " + lastname + ", testMark = " + testMark);
    }

    @ParameterizedTest
    @MethodSource("hobbies")
    void testHobbies(String hobby){
        System.out.println("hobby = " + hobby);
    }

    @ParameterizedTest(name = "[{index}] : Test Even Numbers - {arguments}")
    @MethodSource("randomNumbers")
    void testEvenNumbers(int number){
        assertTrue(number %2 == 0, number + " is not an even number");
        System.out.println("number = " + number);
    }

    @ParameterizedTest
    @MethodSource
    void randomNumbers(int number){
        System.out.println("number = " + number);
    }

    @ParameterizedTest
    @MethodSource("Chapter9.DataStore#randomNumbers")
    void testOddNumbers(int number){
        assertTrue(number % 2 != 0, number + " is not an odd number");
    }


    static List<Integer> randomNumbers(){
        Random rnd = new Random();
        List<Integer> numbers = new ArrayList<>();
        int count = rnd.nextInt(5, 15);

        for (int i = 0; i < count; i++) {
            numbers.add(rnd.nextInt(10, 70));
        }
        return numbers;
    }

    static Stream<String> hobbies(){
        return Stream.of("Tennis", "Hockey", "Chess", "Hiking", "Soccer");
    }

}
