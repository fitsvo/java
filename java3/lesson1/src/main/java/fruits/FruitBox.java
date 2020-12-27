package fruits;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private final List<T> myBox;

    public FruitBox() {
        this.myBox = new ArrayList<>();
    }

    public FruitBox(T[] fruits) {
        this.myBox = new ArrayList<>();
    }

    public float getCount(){
        return myBox.size();
    }

    public float getWeight(){
        if (myBox.size() > 0) return myBox.size() * myBox.get(0).getWeight();
        else return 0f;
    }

    public void append(T fruit){
        myBox.add(fruit);
    }

    public boolean compare(FruitBox otherBox){
        return (this.getWeight() == otherBox.getWeight());
    }

    public void pourAll(FruitBox<T> otherBox) {
        for (T fruit: myBox) {
            otherBox.append(fruit);
        }
        myBox.clear();
    }
}
