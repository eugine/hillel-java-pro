package ua.ithillel.hibernate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HibernateExampleTest {
    @BeforeEach
    void setUpOne() {
        System.out.println("one");
    }

    @BeforeEach
    void setUpTwo() {
        System.out.println("two");
    }

    @Test
    void shouldDoTest() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        var val1 = "val1";
        var val3 = "val1";
        var val4 = "val1";
        var val5 = "val1";

        var val2 = new String("val1").intern();
        System.out.println(val1 == val2);
//        System.out.println(val1 == val3);

    }
}