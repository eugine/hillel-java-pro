package ua.ithillel.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("one");
        items.add("one");
        items.add("two");
        items.add("three");
        items.add("three");

        System.out.println("size: " + items.size());

        List<String> items2 = List.of("one", "two", "three");

        items.addAll(items2);

        items.remove("two");
        items.remove(0);

        String value = items.get(0);

        boolean result = items.contains("one");


        System.out.println("1 --------------------");
        foriLoop(items);

        System.out.println("2 --------------------");
        for (String item : items) {
            System.out.println("Item: " + item);
        }

//        iterator(items);
    }

    private static void foriLoop(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item: " + items.get(i));
        }
    }


    public static List<String> improveList(List<String> source) {
        var result = new ArrayList<>(source);
        result.add("test");
        return result;
    }



    private static void iterator(List<String> items) {
        var iter = items.listIterator();
        System.out.println(iter.hasNext());
        System.out.println(iter.hasPrevious());
        System.out.println("-----------------" + iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.hasPrevious());
        System.out.println("-----------------" + iter.previous());
        iter.previous();
    }

}
