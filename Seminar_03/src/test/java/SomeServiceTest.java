import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
class SomeServiceTest {
    SomeService ss;
    @BeforeEach // так можно один раз создать объект для всех тестов
    void testinit() {
        ss = new SomeService();
    }
    /*
    @Test
    void testFizzBuzzModThree(){
        assertEquals("Fizz", ss.FizzBuzz(3));
    }
    @Test
    void testFizzBuzzModFive(){
        assertEquals("Buzz", ss.FizzBuzz(5));
    }
    @Test
    void testFizzBuzzModFifteen(){
        assertEquals("FizzBuzz", ss.FizzBuzz(15));
    }
    @Test
    void testFizzBuzzIncorrect(){
        assertEquals("14", ss.FizzBuzz(14));
    }
    */
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33}) //
    void testFizzBuzzModThree(int i){
        assertEquals("Fizz", ss.FizzBuzz(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 25, 55})
    void testFizzBuzzModFive(int i){
        assertEquals("Buzz", ss.FizzBuzz(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {15, 30, 60, 120})
    void testFizzBuzzModFifteen(int i){
        assertEquals("FizzBuzz", ss.FizzBuzz(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {14, 34, 76, 104})
    void testFizzBuzzIncorrect(int i){
        assertEquals(String.valueOf(i), ss.FizzBuzz(i));
    }
    @Test
    void testFirstLastEndSix(){
        assertTrue(ss.firstLast6(new int[]{3, 5, 3, 5, 6}));
    }
    @Test
    void testFirstLastBeginAndEndSix(){
        assertTrue(ss.firstLast6(new int[]{6, 5, 3, 5, 9, 6}));
    }
    @Test
    void testFirstLastDoNotExistsSix(){
        assertFalse(ss.firstLast6(new int[]{9, 5, 3, 5, 3}));
    }
    @Test
    void testLuckySumAllNumber() {
        assertEquals(6, ss.luckySum(1, 2, 3));
    }
    @Test
    void testLuckySumWithOutOneNumber() {
        assertEquals(5, ss.luckySum(13, 2, 3));
    }
    @Test
    void testLuckySumWithOutTwoNumber() {
        assertEquals(3, ss.luckySum(13, 13, 3));
    }
    @Test
    void testLuckySumWithOutThreeNumber() {
        assertEquals(0, ss.luckySum(13, 13, 13));
    }

}
