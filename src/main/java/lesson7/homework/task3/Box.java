package lesson7.homework.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private float weight;

    public Box() {
        fruits = new ArrayList<>();
        weight = 0.0f;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
        weight += fruit.getWeight();
    }

    public float getWeight() {
        return weight;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    private void removeAll() {
        fruits = null;
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.weight - another.getWeight()) < 0.0001;
    }

    public void pourOver(Box<T> from) {
        this.fruits.addAll(from.getFruits());
        this.weight += from.getWeight();
        from.removeAll();
    }
}
