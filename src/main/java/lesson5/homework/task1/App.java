package lesson5.homework.task1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        long time = System.currentTimeMillis();
        while (true) {
            vehicles.add(new Car());
            vehicles.add(new Bus());
            System.out.println((System.currentTimeMillis() - time) / 1000);
        }
    }
}
