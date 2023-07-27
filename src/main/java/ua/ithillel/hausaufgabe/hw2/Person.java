package ua.ithillel.hausaufgabe.hw2;

public class Person implements Participant {

    private final int maxRunDistance;
    private final int maxJumpHeight;

    public Person(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if (distance < maxRunDistance) {
            System.out.println("Person runs " + distance);
            return true;
        } else {
            System.out.println("Person can't run more than " + maxRunDistance);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height < maxJumpHeight) {
            System.out.println("Person jumps " + height);
            return true;
        } else {
            System.out.println("Person can't jump higher than " + maxJumpHeight);
            return false;
        }
    }
}
