package com.example.calk_3;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

public class MainActivityTest extends TestCase{


    @Test
    public void testPercentageAddition() {
        Double result = MainActivity.calculate("200", "10", "+");
        assertEquals(Double.valueOf(220), result);
        // 200 + (10% от 200)= 200 + 20 = 220
    }
    @Test
    public void testPercentageSubtraction() {
        Double result = MainActivity.calculate("200", "10", "-");
        assertEquals(Double.valueOf(180), result);
        // 200 - (10% от 200)= 180
    }
    @Test
    public void testPercentageDivision() {
        Double result = MainActivity.calculate("200", "10", "/");
        assertEquals(Double.valueOf(2000), result);
        // (200 / 10) * 100 =2000
    }
    @Test
    public void testPercentageMultiplication() {
        Double result = MainActivity.calculate("200", "10", "*");
        assertEquals(Double.valueOf(20), result);
        // (200 * 10) / 100 =20
    }

    @Test
    public void testPercentageWithNegativeValues() {
        Double result = MainActivity.calculate("200", "-10", "+");
        assertEquals(Double.valueOf(180), result);
        // 200 + (-10% от 200)= 180
        result = MainActivity.calculate("200", "-10", "-");
        assertEquals(Double.valueOf(220), result);
        // 200 - (-10% от 200)= 220
    }
}