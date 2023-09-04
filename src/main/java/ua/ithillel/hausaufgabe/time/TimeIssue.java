package ua.ithillel.hausaufgabe.time;

import java.time.LocalDate;

public class TimeIssue {

    private final LocalDate date = LocalDate.now();

    public LocalDate getDate() {
        return date;
    }
}
