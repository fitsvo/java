import Barriers.*;
import Players.*;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Players[] players = new Players[10];
        players[0] = new Human("Vitya", 5000, 1);
        players[1] = new Human("Denis", 2000, 2);
        players[2] = new Human("Vova", 3000, 2);
        players[3] = new Cat("Tom", 40, 2);
        players[4] = new Cat("Leopold", 30, 3);
        players[5] = new Cat("Matroskin", 20, 1);
        players[6] = new Robot("R2D2", 10000, 0);
        players[7] = new Robot("Terminator", 1100, 4);
        players[8] = new Robot("Bender", 3000, 5);
        players[9] = new Robot("C-3PO", 1000, 1);

        Barriers[] barriers = new Barriers[3];

        Random rand = new Random();
        boolean isBarr;
        for (int i = 0; i < barriers.length; i++) {
            int distance = rand.nextInt(10000);
            int height = rand.nextInt(5);
            isBarr = rand.nextBoolean();
            if (isBarr) {
                barriers[i] = new RunningTrack(distance);
            } else {
                barriers[i] = new Wall(height);
            }
        }

        boolean result;
        for(Players player : players)
            for(Barriers barrier : barriers) {
                result = barrier.moving(player);
                if (!result) break;
            }
    }
}
