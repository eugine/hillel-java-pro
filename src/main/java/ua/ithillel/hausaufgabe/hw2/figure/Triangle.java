package ua.ithillel.hausaufgabe.hw2.figure;

public class Triangle implements Figure {
    private final int size;
    private final int height;

    public Triangle(int size, int height) {
        this.size = size;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * size * height;
    }
}
