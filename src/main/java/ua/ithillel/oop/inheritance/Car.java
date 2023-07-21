package ua.ithillel.oop.inheritance;

public abstract class Car {

    public Car() {

    }

    public void start() {
        System.out.println("Завести машину");
    }

    public void stop() {
        System.out.println("Заглушити машину");
    }

    public abstract String name();

}
