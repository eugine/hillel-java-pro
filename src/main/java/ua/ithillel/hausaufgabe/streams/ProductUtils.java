package ua.ithillel.hausaufgabe.streams;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class ProductUtils {

    public static List<Product> filterByCategoryAndPriceGreaterThan(List<Product> products, String category, double minPrice) {
        return null;
    }

    public static List<Product> filterByCategoryAndDiscountable(List<Product> products, String category) {
       return null;
    }

    public static Product findCheapest(List<Product> products) {
        return null;
    }

    public static List<Product> findLatest(List<Product> products, int countLatest) {
       return null;
    }

    public static double calculatePrice(List<Product> products, String category, double minPrice, Duration createdAfter) {
//        var now = LocalDate.now();
//        return filterByCategoryAndPriceGreaterThan(products, category, minPrice).stream()
//                .filter(product -> Duration.between(now, product.creationDate()).compareTo(createdAfter) <= 0)
//                .mapToDouble(Product::price)
//                .sum();
        return 0;
    }

    public static Map<String, List<Product>> mapByCategories(List<Product> products) {
        return null;
    }

}
