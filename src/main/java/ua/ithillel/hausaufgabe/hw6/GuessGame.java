package ua.ithillel.hausaufgabe.hw6;

import static ua.ithillel.hausaufgabe.hw6.GuessGame.GuessResult.LOST;
import static ua.ithillel.hausaufgabe.hw6.GuessGame.GuessResult.WIN;

public class GuessGame {

    public static final int MAX_HINT_LENGTH = 15;
    public static final char HINT_HIDDEN_CHAR = '#';

    public static GameResult play(String word, String guess) {
        if (word.equalsIgnoreCase(guess)) {
            return new GameResult(WIN, null);
        }

        var hint =  generateHint(word, guess);

        return new GameResult(LOST, hint);
    }

    private static String generateHint(String word, String guess) {
        var result = new StringBuilder();
        for (int i = 0; i < MAX_HINT_LENGTH; i++) {
            if ( i < word.length() && i < guess.length()) {
                if (word.charAt(i) == guess.charAt(i)) {
                    result.append(word.charAt(i));
                } else {
                    result.append(HINT_HIDDEN_CHAR);
                }
            } else {
                result.append(HINT_HIDDEN_CHAR);
            }
        }
        return result.toString();
    }


    public record GameResult(GuessResult result, String hint) {

    }

    public enum GuessResult {
        WIN,
        LOST
    }


}
