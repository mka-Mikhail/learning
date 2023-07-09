package lesson8.homework.task3;

import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> strings1 = List.of("asdf", "qwer", "f", "tyh");
        List<String> strings2 = List.of("popg", "sd", "f", "tyh");

        HashSetExtend<String> set1 = new HashSetExtend<>(strings1);
        HashSetExtend<String> set2 = new HashSetExtend<>(strings2);

        HashSet<String> result = set1.union(set2);
        System.out.println("Объединение: " + result);

        result = set1.intersect(set2);
        System.out.println("Пересечение: " +  result);
    }
}
