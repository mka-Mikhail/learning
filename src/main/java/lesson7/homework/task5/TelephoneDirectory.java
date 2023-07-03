package lesson7.homework.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private static Map<String, List<String>> dir = new HashMap<>();

    public static void add(String surname, String number) {
        List<String> numbers = new ArrayList<>();
        if (dir.containsKey(surname)) {
            numbers.addAll(dir.get(surname));
        }
        numbers.add(number);
        dir.put(surname, numbers);
    }

    public static List<String> getNumberBySurname(String surname) {
        return dir.get(surname);
    }
}
