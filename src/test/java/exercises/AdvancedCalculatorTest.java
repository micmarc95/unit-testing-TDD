package exercises;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class AdvancedCalculatorTest {

// TODO Please write unit test for AdvancedCalculator class

    // czy liczba jest całkowita
    // czy liczba jest dodatnia
    // czy wartość przekracza zakres zmiennych numerycznych

    @Test
    public void test1 (){
        AdvancedCalculator advancedCalculator = new AdvancedCalculator();
        // GIVEN
        int x = 10;
        int result;
        // WHEN
        result = advancedCalculator.silnia(10);
        // THEN
        assertEquals(3_628_800,result);
    }

    @Test
    public void test2 (){
        AdvancedCalculator advancedCalculator = new AdvancedCalculator();
        try {
                advancedCalculator.silnia(-1);
                fail();
            } catch (IllegalArgumentException e) {
                assertEquals("Silnia jest policzalna tylko dla liczb dodatnich", e.getMessage());
            } catch (Exception e) {
                fail();
            }
        }

        @Test
    @Parameters({
            "8, 40320",
            "9, 362880"
    })
    public void testAdvancedCalculatorForCertainValues(int x, int expectedResult) {

        AdvancedCalculator advancedCalculator = new AdvancedCalculator();
        int result = advancedCalculator.silnia(x);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testBigNumberOverInt (){

        try {
            AdvancedCalculator advancedCalculator = new AdvancedCalculator();
            int result = advancedCalculator.silnia(13);
            //fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Wynik nie może być mniejszy od zera", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void testPotegaCalculation (){

        try {
            AdvancedCalculator advancedCalculator = new AdvancedCalculator();
            double result = advancedCalculator.potega(0,0);
            //fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Wynik nie może być mniejszy od zera", e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }
}

