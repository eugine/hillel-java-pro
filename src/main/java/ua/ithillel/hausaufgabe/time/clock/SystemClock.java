package ua.ithillel.hausaufgabe.time.clock;

import java.time.LocalDate;

public class SystemClock implements Clock {

    @Override
    public LocalDate now() {
        return LocalDate.now();
    }
}
