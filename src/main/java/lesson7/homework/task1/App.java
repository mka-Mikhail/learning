package lesson7.homework.task1;

import java.util.ArrayList;
import java.util.Arrays;

class Clazz {
    private int num;

    public Clazz(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Clazz: " + num;
    }
}

class Swapper {
    public static <T> ArrayList<T> swapToElements(ArrayList<T> array, int from, int to) {
        T el = array.get(from);
        array.set(from, array.get(to));
        array.set(to, el);
        return array;
    }
}

public class App {
    private static final ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
    private static final ArrayList<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three"));
    private static final ArrayList<Clazz> clazzes = new ArrayList<>(Arrays.asList(new Clazz(1), new Clazz(2)));

    public static void main(String[] args) {
        System.out.println("До перемены мест");
        System.out.println(integers);
        System.out.println(strings);
        System.out.println(clazzes);

        System.out.println("\nПосле перемены мест");
        System.out.println("3 и 1: " + Swapper.swapToElements(integers, 3, 1));
        System.out.println("0 и 1: " + Swapper.swapToElements(strings, 0, 1));
        System.out.println("1 и 0: " + Swapper.swapToElements(clazzes, 1, 0));
    }
}