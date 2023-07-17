package ua.ithillel.oop.inheritance.currency;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter1 = new DummyCurrencyConvert();
//        CurrencyConverter converter2 = new SimpleCurrencyConverter();

        execute(converter1);
    }

    public static void execute(CurrencyConverter converter) {
        System.out.println("Result: " + converter.convert(100));
    }
}
