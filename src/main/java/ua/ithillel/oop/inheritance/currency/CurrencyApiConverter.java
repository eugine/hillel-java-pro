package ua.ithillel.oop.inheritance.currency;

public class CurrencyApiConverter implements CurrencyConverter {


    @Override
    public double convert(double amount) {
        //сходити в інтернет і взяти актуальний курс.
        return 0;
    }
}
