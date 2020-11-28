package Barriers;

import Players.Players;

public class RunningTrack extends Barriers{

    public RunningTrack(int distance) {
        super(distance);
    }
    public void info(){
        int distance = super.getDistance();
        String type = "Running Track";
        System.out.println(type + " is " + distance + " meters.");
    }

    public boolean moving(Players player) {
        info();
        player.run();

        if (getDistance() <= player.getRunLimit()) {
            System.out.println('\t' + player.getName() + " run success.");
            return true;
        } else {
            System.out.println('\t' + player.getName() + " run unsuccessfully.");
            return false;
        }
    }

    @Override
    public int getDistance() {
        return super.getDistance();
    }
}
