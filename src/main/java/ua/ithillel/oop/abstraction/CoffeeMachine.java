package ua.ithillel.oop.abstraction;

import java.util.List;

public class CoffeeMachine {

    /*
    Приготувати каву
     */
    public void brew() {
        System.out.println("Нагріти воду");
        System.out.println("Змолоти каву");
        System.out.println("Залити воду у каву");
        System.out.println("Додати цукор");
        System.out.println("Кава готова");
    }

    @Override
    public String toString() {
        return "CoffeeMachine{}";
    }

    public static void main(String[] args) {
        var machine = new CoffeeMachine();
        machine.brew();

    }
}
