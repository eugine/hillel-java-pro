package ua.ithillel.oop.encapsulation;

public class Cat {
    private int mood; //настрій
    int exampleDefault;
    protected int energyProtected; //енергія
    public int hungryPublic; //голодний

    public void play() { //погратися
        mood += 10;
        energyProtected -= 10;
    }

    public void feed() { //нагодувати
        mood += 10;
        hungryPublic -= 10;
    }

    public void sleep() { //поспати
        energyProtected += 10;
        hungryPublic += 10;
    }

    public static void main(String[] args) {
        var cat = new Cat();
        System.out.println(cat.mood);
    }

}
