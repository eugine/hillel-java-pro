package ua.ithillel.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }

    @Test
    void shouldAdd() {
        int result = calc.add(5, 6);

        assertEquals(11, result);
    }

    @Test
    void shouldMinus() {
        int result = calc.minus(15, 6);

        assertEquals(9, result);
    }
}