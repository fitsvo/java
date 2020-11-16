package Cats;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate){

        if (this.appetite > plate.getFood()) System.out.println("Cat " + name + " have too many appetite!");
        else if (this.satiety) System.out.println("Cat " + name + " is full!"); // проверка сытости кота
        else {
            System.out.println("Cat " + name + " eats!");
            plate.decreaseFood(this.appetite);
            this.satiety = true;
        }
    }

    public void info(){
        System.out.println("Cat " + this.name + ", appetite: " + this.appetite + ", satiety: " + this.satiety);
    }
}
