package ua.ithillel.oop.polymorphism;

public class SmartPhone implements Phone {

    @Override
    public void call(String phoneNumber) {
        System.out.println("Смартфон викликає номер " + phoneNumber);
    }

}
