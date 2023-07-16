package ua.ithillel.oop.encapsulation;

public class Cat {
    private int mood; //настрій
    private int hungry; //голодний
    private int energy; //енергія

//    protected int exampleProtected;
//    int exampleDefault;

    public void play() { //погратися
        mood += 10;
        energy -= 10;
    }

    public void feed() { //нагодувати
        mood += 10;
        hungry -= 10;
    }

    public void sleep() { //поспати
        energy += 10;
        hungry += 10;
    }

}
