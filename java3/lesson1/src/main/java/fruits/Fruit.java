package fruits;

public class Fruit {
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public Fruit() {
        this.weight = 0;
    }

    public float getWeight() {
        return this.weight;
    }
}
