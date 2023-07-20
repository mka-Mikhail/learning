package lesson9.homework.task2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> strings = List.of("Astra", "Gorod Moskva", "River", "Ruslan", "Albatross", "Gorod");

        BinaryOperator<String> operator = (x1, x2) -> {
            if (x1 == null && x2.length() <= 10) {
                return x2;
            } else if (x1 == null && x2.length() > 10) {
                return null;
            } else if (x1.length() <= 10 && x2.length() <= 10) {
                return x1.length() > x2.length() ? x1 : x2;
            } else if (x1.length() <= 10 && x2.length() > 10) {
                return x1;
            } else if (x1.length() > 10 && x2.length() > 10) {
                return null;
            } else if (x1.length() > 10 && x2.length() <= 10) {
                return x2;
            } else {
                return null;
            }
        };

        Map<Character, Optional<String>> resultMap = strings.stream()
                .collect(Collectors.groupingBy(str -> str.charAt(0),
                        Collectors.reducing(operator)));

        resultMap.entrySet().stream().forEach(e -> {
            if (e.getValue().isPresent() && e.getValue().get().length() > 10) {
                e.setValue(Optional.empty());
            }
        });

        resultMap.entrySet().stream().forEach(System.out::println);
    }
}
