package ua.ithillel.oop;

import ua.ithillel.oop.encapsulation.Cat;

public class ExtendedCat extends Cat {


    public static void main(String[] args) {
        var cat = new ExtendedCat();
        System.out.println(cat.energyProtected);
    }
}
