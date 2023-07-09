package lesson9.homework.task2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> strings = List.of("Astra", "Gorod Moskva", "River", "Ruslan", "Albatross");

        Map<String, String> map2 = strings.stream()
                .collect(
                        Collectors.groupingBy(
                                str -> str.substring(0, 1),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(String::length)),
                                        str -> str.filter(s -> s.length() <= 10).orElse(null)
                                ))
                );

        map2.entrySet().stream().forEach(System.out::println);
    }
}
