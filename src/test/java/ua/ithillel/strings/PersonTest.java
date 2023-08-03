package ua.ithillel.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldSetNameOnCreation() {
        var target = new Person("Test");

        assertEquals("Test", target.getName());
    }

    @Test
    void shouldUpdateName() {
        var target = new Person("Test");

        target.setPersonName("YYYY");

        assertEquals("YYYY", target.getName());

    }

}