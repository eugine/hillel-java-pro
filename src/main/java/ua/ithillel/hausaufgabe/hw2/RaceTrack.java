package ua.ithillel.hausaufgabe.hw2;

public class RaceTrack implements Obstacle {

    private final int length;

    public RaceTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(length);
    }

    @Override
    public String toString() {
        return "RaceTrack{" +
                "length=" + length +
                '}';
    }
}
