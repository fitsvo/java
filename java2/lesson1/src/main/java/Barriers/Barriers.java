package Barriers;

import Players.Players;

public abstract class Barriers {

    private final int distance;

    public Barriers(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void info() {}

    public abstract boolean moving(Players player);
}
