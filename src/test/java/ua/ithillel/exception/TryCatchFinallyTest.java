package ua.ithillel.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TryCatchFinallyTest {
    @Test
    void shouldThrowException() {
        var target = new TryCatchFinally();

        assertThrows(MyException.class, () -> target.demo());
    }
}