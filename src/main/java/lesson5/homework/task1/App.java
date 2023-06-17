package lesson5.homework.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx256m -XX:+HeapDumpOnOutOfMemoryError - флаги запуска программы:
 * размер кучи 256 Мб, сделать heap dump после падения программы в ошибку OutOfMemoryError
 */
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
