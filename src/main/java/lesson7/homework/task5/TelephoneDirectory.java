package lesson7.homework.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private static HashMap<String, String> dir = new HashMap<>();

    public static void add(String surname, String number) {
        dir.put(number, surname);
    }

    public static List<String> getNumberBySurname(String surname) {
        List<String> numbers = new ArrayList<>();
        for (Map.Entry<String, String> entry : dir.entrySet()) {
            if (entry.getValue().equals(surname)) {
                numbers.add(entry.getKey());
            }
        }
        return numbers;
    }
}
