package ua.ithillel.strings;

import java.util.Scanner;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input a = ");
        int a = scanner.nextInt();
        System.out.print("Input b = ");
        int b = scanner.nextInt();

        var calc = new Calculator();

        System.out.println("Result: " + calc.add(a, b));
    }
}
