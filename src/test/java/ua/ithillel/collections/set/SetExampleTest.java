package ua.ithillel.collections.set;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SetExampleTest {
    @Test
    void creation() {
        var set1 = Set.of("1", "2", "3");
        var set2 = new HashSet<>(set1);

        set2.add("1");
        set2.add("2");
        set2.add("3");

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set2.equals(set1));

//        assertThat(set1, equalTo(set2));
//        assertThat(set2, containsInAnyOrder("1", "2", "3"));
    }


    @Test
    void hashSet() {
        var set = new HashSet<Item>();
        set.add(new Item("item"));
        set.add(new Item("item"));

        System.out.println(set);
        assertThat(set, hasSize(1));
    }


    @Test
    void hashRecord() {
        var set = new HashSet<Record>();
        set.add(new Record("item"));
        set.add(new Record("item"));

        System.out.println(set);

        assertThat(set, hasSize(1));
    }


    @Test
    void treeSet() {
        var elements = new TreeSet<String>();
        elements.add("b");
        elements.add("d");
        elements.add("a");
        elements.add("w");
        elements.add("f");
        System.out.println(elements);
    }

    @Test
    void treeSetOrder() {
        var elements = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        elements.add("b");
        elements.add("d");
        elements.add("a");
        elements.add("w");
        elements.add("f");
        System.out.println(elements);
    }

    @Test
    void treeSetStringNumbersOrder() {
        var elements = new TreeSet<String>();
        elements.add("1");
        elements.add("111");
        elements.add("2");
        elements.add("222");
        elements.add("3");

        System.out.println(elements);
    }

    @Test
    void treeSetNumbersOrder() {
        var elements = new TreeSet<Integer>();
        elements.add(1);
        elements.add(111);
        elements.add(2);
        elements.add(222);
        elements.add(3);

        System.out.println(elements);
    }
}