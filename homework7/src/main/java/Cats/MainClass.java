package Cats;

public class MainClass {

    public static void main(String[] args) {
        Cat[] catArray = new Cat[6];
        catArray[0] = new Cat("Milan", 10);
        catArray[1] = new Cat("Tom", 150);
        catArray[2] = new Cat("Leopold", 17);
        catArray[3] = new Cat("Gav", 3);
        catArray[4] = new Cat("Matroskin", 100);
        catArray[5] = new Cat("Simon", 30);

        Plate plate = new Plate(150);

        for(Cat cat: catArray){
            cat.eat(plate);
            cat.info();
            plate.addFood(5);
            plate.info();
            System.out.println();
        }

        plate.addFood(10);
        catArray[5].eat(plate);  // проверка сытости кота
        plate.info();
    }
}
