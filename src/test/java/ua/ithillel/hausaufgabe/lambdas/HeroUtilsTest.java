package ua.ithillel.hausaufgabe.lambdas;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeroUtilsTest {

    @Test
    void shouldFindAverageHeight() {
        var heroes = List.of(
                Hero.builder().height(10).build(),
                Hero.builder().height(11).build(),
                Hero.builder().height(12).build(),
                Hero.builder().height(0).build(),
                Hero.builder().height(-1).build()
        );

        var actual = HeroUtils.findAverageHeight(heroes);

        assertThat(actual, equalTo(11.0));
    }

    @Test
    void shouldFindTheTallest() {
        var heroes = List.of(
                Hero.builder().name("Name1").height(10).build(),
                Hero.builder().name("Name2").height(11).build(),
                Hero.builder().name("Name3").height(12).build()
        );

        var actual = HeroUtils.findTheTallest(heroes);

        assertThat(actual, equalTo("Name3"));
    }

    @Test
    void shouldFindTheHeaviest() {
        var heroes = List.of(
                Hero.builder().name("Name1").weight(10).build(),
                Hero.builder().name("Name2").weight(11).build(),
                Hero.builder().name("Name3").weight(12).build()
        );

        var actual = HeroUtils.findTheHeaviest(heroes);

        assertThat(actual, equalTo("Name3"));
    }


    @Test
    void shouldCountByGender() {
        var heroes = List.of(
                Hero.builder().gender("M").build(),
                Hero.builder().gender("M").build(),
                Hero.builder().gender("M").build(),
                Hero.builder().gender("F").build(),
                Hero.builder().gender("F").build()
        );

        var result = HeroUtils.countByGender(heroes);

        assertThat(result, equalTo(
                Map.of(
                        "M", 3,
                        "F", 2
                )
        ));
    }
}