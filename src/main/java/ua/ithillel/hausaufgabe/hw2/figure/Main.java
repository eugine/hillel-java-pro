package ua.ithillel.hausaufgabe.hw2.figure;

public class Main {

    public static void main(String[] args) {
        Figure[] figures = new Figure[2];
        figures[0] = new Square(10);
        figures[1] = new Triangle(10, 15);


        double total = 0;
        for (var figure: figures) {
            total += figure.area();
        }

        System.out.println("Total area: " + total);


    }
}
