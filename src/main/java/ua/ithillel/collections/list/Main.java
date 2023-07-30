package ua.ithillel.collections.list;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("one");
        items.add("one");
        items.add("two");
        items.add("three");
        items.add("three");
//        items.addAll();


        items.remove("two");
//        items.get(0);

//        items.remove(0)
//        items.contains("one");
//        items.


        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item: " + items.get(i));
        }

        for (var item : items) {
            System.out.println("Item: " + item);
        }

//        iterator(items);
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
