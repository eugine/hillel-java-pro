package ua.ithillel.oop.polymorphism;

//кнопочний телефон
public class ButtonPhone implements Phone {

    @Override
    public void call(String phoneNumber) {
        System.out.println("Кнопочний телефон викликає номер " + phoneNumber);
    }

}
