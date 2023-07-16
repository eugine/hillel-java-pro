package ua.ithillel.oop.encapsulation;

public class Main {
    public static void main(String[] args) {
        var cat = new Cat();

        cat.play();
        cat.feed();
        cat.sleep();

        var t = new EncapsulationExample().protectedVariable;
    }
}
