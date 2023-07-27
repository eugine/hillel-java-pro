package ua.ithillel.hausaufgabe.hw2.figure;

public class Square implements Figure {

    private final int side; //10

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
