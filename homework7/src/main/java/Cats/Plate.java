package Cats;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info(){
        System.out.println("Plate has " + food + " food.");
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    // метод, с помощью которого можно добавлять еду в тарелку
    public void addFood(int amount) {
        System.out.println("Add " + amount + " food.");
        this.food += amount;
    }

    public int getFood() {
        return food;
    }
}
