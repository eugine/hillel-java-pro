package ua.ithillel.hausaufgabe.hw6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.ithillel.hausaufgabe.hw6.GuessGame.GameResult;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ithillel.hausaufgabe.hw6.GuessGame.GuessResult.LOST;
import static ua.ithillel.hausaufgabe.hw6.GuessGame.GuessResult.WIN;

class GuessGameTest {

    @ParameterizedTest
    @MethodSource("datasource")
    void shouldPlayGame(String word, String guess, GameResult expectedResult) {
        var result = GuessGame.play(word, guess);

        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> datasource() {
        return Stream.of(
                Arguments.of("apple", "apricot", new GameResult(LOST, "ap#############")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("puzzle", "pizza", new GameResult(LOST, "p#zz###########")),
                Arguments.of("apple", "apple", new GameResult(WIN, null))
        );
    }

    /*

    @Test
    void shouldReturnLostResult() {
        var result = GuessGame.play("apple", "apricot");

        assertEquals(result, );
    }

    @Test
    void shouldReturnLostResult2() {
        var result = GuessGame.play("puzzle", "pizza");

        assertEquals(result, new GameResult(LOST, "p#zz###########"));
    }


    @Test
    void shouldReturnWinResult() {
        var result = GuessGame.play("apple", "apple");
        assertEquals(result, new GameResult(WIN, null));
    }*/
}