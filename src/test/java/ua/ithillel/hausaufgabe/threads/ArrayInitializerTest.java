package ua.ithillel.hausaufgabe.threads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {

    private final double[] array = new double[10];

    @BeforeEach
    void setUp() {
        Arrays.fill(array, 10);
    }

    @Test
    void shouldInitArray() {
        ArrayInitializer.init(array);
        assertArrayInitialized();
    }

    @Test
    void shouldInitArrayV2() {
        ArrayInitializerV2.init(array);
        assertArrayInitialized();
    }

    private void assertArrayInitialized() {
        var countWithInitialValue = DoubleStream.of(array)
                .filter(value -> Math.abs(value - 10) < 0.001)
                .count();
        assertTrue(countWithInitialValue < 5);

        for (int i = 0; i < array.length / 2; i++) {
            assertEquals(array[i], array[i + array.length / 2], 0.001);
        }
    }
}