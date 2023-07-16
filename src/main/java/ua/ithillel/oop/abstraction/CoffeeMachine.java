package ua.ithillel.oop.abstraction;

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


    public static void main(String[] args) {
        System.out.println(new CoffeeMachine());
    }
}
