package ua.ithillel.exception;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class TryCatchFinallyTest {

    @Test
    void shouldThrowException() {
        var target = new TryCatchFinally();

        var exception = assertThrows(MyException.class, () -> target.demo());
        assertEquals(exception.getMessage(), "My exception");
    }
}