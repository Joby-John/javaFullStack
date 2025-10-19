package com.joby.junitdemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    
    @Test
    void twoPlusTwoShouldEqualTwo(){
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        assertEquals(4, simpleCalculator.add(2, 2));
    }

    @Test
    void threePlusSevenEqualsTen(){
        var simpleCalculator = new SimpleCalculator();
        assertEquals(10, simpleCalculator.add(3, 7)); 
    }
}
