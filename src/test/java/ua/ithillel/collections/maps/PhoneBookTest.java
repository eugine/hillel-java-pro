package ua.ithillel.collections.maps;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void add() {
        var target = new PhoneBook();

        target.add("Ivan", "6666");
        target.add("Ivan", "5555");
        target.add("Ivan", "7777");

        List<String> actual = target.getAll().get("Ivan");

        assertThat(actual, containsInAnyOrder("6666", "5555", "7777"));

    }

    @Test
    void find() {
        var target = new PhoneBook(Map.of(
                "Evgeniy", List.of("1234", "4321")
        ));

        String result = target.find("Evgeniy");

        assertThat(result, Matchers.isOneOf("1234", "4321"));
    }

    @Test
    void findAll() {
    }
}