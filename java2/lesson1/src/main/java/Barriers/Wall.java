package Barriers;

import Players.Players;

public class Wall extends Barriers{

    public Wall(int height) {
        super(height);
    }

    public void info(){
        int distance = super.getDistance();
        String type = "Wall";
        System.out.println(type + " is " + distance + " meters long.");
    }

    public boolean moving(Players player) {
        info();
        player.jump();

        if (getDistance() <= player.getJumpLimit()) {
            System.out.println('\t' + player.getName() + " jump success.");
            return true;
        } else {
            System.out.println('\t' + player.getName() + " jump unsuccessfully.");
            return false;
        }
    }


    public int getDistance() {
        return super.getDistance();
    }
}
