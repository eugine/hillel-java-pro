package ua.ithillel;

import java.util.Arrays;
import java.util.List;

public class StringExample {

    public static List<String> toWords(String value) {
        if (value == null) {
            return List.of();
//               return List.of();
//               return Collections.emptyList();
        }
        return Arrays.stream(value.split(" ")).toList();
    }


    public static void main(String[] args) {
        var result = toWords("test string");

        var count = result.stream()
//                   .filter()
//                   .map()
                .count();

        System.out.println("count: " + count);

//        System.out.println(toWords("test string"));
    }

}
