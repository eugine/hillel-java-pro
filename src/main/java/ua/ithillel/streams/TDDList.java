package ua.ithillel.streams;

import java.util.List;
import java.util.stream.Collectors;

public class TDDList {

    public static <T> int countOccurrence(List<T> items, T item) {
        return (int) items.stream()
                .filter(element -> element.equals(item))
                .count();
    }

    public static <T> List<T> findUnique(List<T> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    public static <T> String calcOccurrence(List<T> list) {
        return findOccurrence(list).stream()
                .map((Result result) -> result.item + "=" + result.count)
                .map(value -> "[" + value + "]")
                .collect(Collectors.joining(", ", "Result: ", ""));
    }

    public record Result<T>(T item, int count) {}

    public  static <T> List<Result<T>> findOccurrence(List<T> list) {
        return findUnique(list).stream()
                .map(item -> new Result<>(item, countOccurrence(list, item)))
                .toList();
    }


}

