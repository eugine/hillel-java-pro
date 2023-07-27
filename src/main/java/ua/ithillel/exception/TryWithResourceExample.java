package ua.ithillel.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourceExample {

    public static void main(String[] args) {
        var example = new TryWithResourceExample();

        example.tryWithResourceExample();
   }

    public void oldStyle() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("README.md"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Enter finally block");
            if (scanner != null) {
                System.out.println("Closing scanner");
                scanner.close();
            }
        }
    }

    public void tryWithResourceExample() {
        //AutoCloseable interface
        try (Scanner scanner = new Scanner(new File("README.md"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
