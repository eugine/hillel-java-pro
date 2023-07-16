package ua.ithillel.oop.inheritance;

public class Main {
    public static void main(String[] args) {
        var audi = new Audit();
        var vw = new VW();

        // Audi
        System.out.println("-----------------");
        System.out.println(audi.getMake());
        audi.start();
        audi.stop();

        // VW
        System.out.println("-----------------");
        System.out.println(vw.getMake());
        vw.start();
        vw.stop();
    }
}
