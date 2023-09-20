package ua.ithillel.hausaufgabe.lambdas;

import lombok.Builder;

@Builder
public record Hero(
        String name,
        String gender,
        String eyeColor,
        String race,
        String hairColor,
        double height,
        String publisher,
        String skinColor,
        String alignment,
        int weight
) {
}
