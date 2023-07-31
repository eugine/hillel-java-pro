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
            if (iterateOverObstacles(obstacles, participant)) {
                System.out.println("Participant completed the challenge");
            }
        }
    }

    private static boolean iterateOverObstacles(Obstacle[] obstacles, Participant participant) {
        for (Obstacle obstacle: obstacles) {
            if (!obstacle.overcome(participant)) {
                System.out.println("Participant left the challenge on " + obstacle);
                break;
            }
        }
        return true;
    }
}
