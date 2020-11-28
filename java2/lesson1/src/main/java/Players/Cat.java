package Players;
import Barriers.*;

public class Cat implements Players{
    private final String TYPE = "Cat";
    private String name = "NoNameCat";
    private final int runLimit;
    private final int jumpLimit;

    public Cat(String name) {
        this.name = name;
        this.runLimit = 20;
        this.jumpLimit = 3;
    }

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public void info(){
        System.out.println(TYPE + " name is "+ name +
                ". His limits in run is " + this.runLimit + ", in jump is " + this.jumpLimit + ".");
    }

    public void run(){
        System.out.println("    Cat " + name + " running.");
    }

    public void jump(){
        System.out.println("    Cat " + name + " jumping.");
    }

    public int getRunLimit() {
        return runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }
    public String getName() { return name;}
}
