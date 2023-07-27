package ua.ithillel.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAdd() {
        var calc = new Calculator();

        int result = calc.add(5, 6);

        assertEquals(11, result);
    }

    @Test
    void shouldMinus() {
        var calc = new Calculator();

        int result = calc.minus(15, 6);

        assertEquals(9, result);
    }
}