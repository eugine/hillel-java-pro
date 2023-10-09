package ua.ithillel.patterns.creational.fabricmethod.button;

public class HtmlButton implements Button {
    @Override
    public void render(int x, int y) {
        System.out.println("render html button");
    }

    @Override
    public void onClick(String event) {
        System.out.println("onClick html event: " + event);
    }
}
