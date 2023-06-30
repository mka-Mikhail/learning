package lesson8.homework.task5;

import java.util.LinkedList;
import java.util.List;
import java.util.function.*;

/**
 * Реализация функциональных интерфейсов Java: Predicate, Consumer, Supplier, Function, UnaryOperator
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> {
            boolean result = x % 3 == 0;
            System.out.printf("Проверка делимости числа %d на 3: %b\n", x, result);
            return result;
        };
        predicate.test(12);

        System.out.println();

        Consumer<String> consumer = str -> System.out.println("Принятая строка: " + str);
        consumer.accept("QWERTY");

        System.out.println();

        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        Supplier<Integer> supplier = () -> {
            Integer result = list.getLast();
            System.out.println("Вывод последнего числа из списка: " + result);
            return result;
        };
        supplier.get();

        System.out.println();

        Function<Integer, Double> function = Integer::doubleValue;
        System.out.println("Преобразование из целого в дробное, число 12: " + function.apply(12));

        System.out.println();

        UnaryOperator<Double> unaryOperator = x -> {
            double result = Math.pow(x, 3);
            System.out.printf("Возведение числа %.2f в 3-ю степень: %.2f\n", x, result);
            return result;
        };
        unaryOperator.apply(3.0);
    }
}
