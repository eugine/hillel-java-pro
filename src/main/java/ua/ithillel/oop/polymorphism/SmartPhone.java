package ua.ithillel.oop.polymorphism;

public class SmartPhone implements Phone {

    @Override
    public void call(String phoneNumber) {
        System.out.println("Смартфон викликає номер " + phoneNumber);
    }

    public void installApp(String appId) {
        System.out.println("Встановлюю програму: " + appId);
    }

    public void runApp(String appId) {
        System.out.println("Запускаю програму: " + appId);

    }

}
