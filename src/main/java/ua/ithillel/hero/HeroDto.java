package ua.ithillel.hero;

import java.util.List;

public record HeroDto(
        String name,
        List<String> movies
) {
}
