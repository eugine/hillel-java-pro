package ua.ithillel.hausaufgabe.hw2;

public class Main {

    public static void main(String[] args) {
        Participant[] participants = new Participant[] {
                new Person(100, 100),
                new Person(200, 200),
        };

        Obstacle[] obstacles = new Obstacle[] {
                new Wall(150),
                new RaceTrack(150)
        };

        for (Participant participant: participants) {
            System.out.println("========= Participant starts");
            boolean completed = true;
            for (Obstacle obstacle: obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println("Participant left the challenge on " + obstacle);
                    completed = false;
                    break;
                }
            }
            if (completed) {
                System.out.println("Participant completed the challenge");
            }

        }
    }
}
