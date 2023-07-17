package ua.ithillel.oop.inheritance.currency;

public class DummyCurrencyConvert implements CurrencyConverter {

    @Override
    public double convert(double amount) {
        return amount * 10;
    }

}
