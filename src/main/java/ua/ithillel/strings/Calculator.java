package ua.ithillel.strings;

import java.io.IOException;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public Result divideAnother(int a, int b) {
        if (b == 0) {
            return new Result(0, -1);
        }
        return new Result(a / b, 0);
    }

    public record Result(int value, int err) {
    }


    public int divide(int a, int b) throws IOException {
        if (true) {
//            throw new RuntimeException("there is a runtime exception");
            throw new IOException("there is an io exception");
        }
        return a / b;
    }

    public static void main(String[] args) {
        var calc = new Calculator();

        try {
            var result1 = calc.divide(10, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
