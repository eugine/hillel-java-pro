package ua.ithillel.hausaufgabe.lambdas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class HeroUtils {

    public static double findAverageHeight(List<Hero> heroes) {
        return heroes.stream()
                .mapToDouble(Hero::height)
                .filter(height -> height > 0)
                .average()
                .orElse(0);
    }

    public static String findTheTallest(List<Hero> heroes) {
        return findTopHeroName(heroes, Hero::height);
    }

    public static String findTheHeaviest(List<Hero> heroes) {
        return findTopHeroName(heroes, hero -> (double) hero.weight());
    }

    private static String findTopHeroName(List<Hero> heroes, Function<Hero, Double> keyExtractor) {
        return heroes.stream()
                .max(comparing(keyExtractor))
                .map(Hero::name)
                .orElseThrow();
    }

    public static Map<String, Long> countByGender(List<Hero> heroes) {
        return countBy(heroes, Hero::gender);
    }

    public static Map<String, Long> countByGroup(List<Hero> heroes) {
        return countBy(heroes, Hero::alignment);
    }

    private static Map<String, Long> countBy(List<Hero> heroes, Function<Hero, String> classifier) {
        return heroes.stream()
                .collect(groupingBy(classifier, counting()));
    }

    public static List<String> findTopPublishers(List<Hero> heroes, int limit) {
        return countBy(heroes, Hero::publisher)
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }


}
