package ua.ithillel.oop.inheritance;

public class Audi extends Car {

    private final String name;

    public Audi(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Audi start");
    }
}
