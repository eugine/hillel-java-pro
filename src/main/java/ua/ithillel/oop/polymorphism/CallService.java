package ua.ithillel.oop.polymorphism;

public class CallService {

    public void callPhone(Phone phone) {
        phone.call("911");
    }

    public void callPhone(Phone phone, String phoneNumber) {
        phone.call(phoneNumber);
    }

    public static void main(String[] args) {
        var service = new CallService();

        var smartPhone = new SmartPhone();
        var buttonPhone = new ButtonPhone();

        service.callPhone(smartPhone, "112");

        service.callPhone(buttonPhone);

    }
}
