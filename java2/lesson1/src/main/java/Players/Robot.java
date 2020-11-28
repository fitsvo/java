package Players;
import Barriers.*;

public class Robot implements Players{
    private final String TYPE = "Robot";
    private String name = "NoNameRobot";
    private final int runLimit;
    private final int jumpLimit;

    public Robot(String name) {
        this.name = name;
        this.runLimit = 1000;
        this.jumpLimit = 2;
    }

    public Robot(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public void info(){
        System.out.println(TYPE + " name is "+ name +
                ". His limits in run is " + this.runLimit + ", in jump is " + this.jumpLimit + ".");
    }


    public void run(){
        System.out.println("    Robot " + name + " running.");
    }

    public void jump(){
        System.out.println("    Robot " + name + " jumping.");
    }

    public int getRunLimit() {
        return runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }
    public String getName() { return name;}
}
