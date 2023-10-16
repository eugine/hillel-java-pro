package ua.ithillel.utils;

public interface Test {

    static void hello() {
        System.out.println("hello in interface");
    }

    default void test() {
        System.out.println("test in interface");
    }

    public static void main(String[] args) {
        Test.hello();
        new Test() {

        }.test();
    }
}
