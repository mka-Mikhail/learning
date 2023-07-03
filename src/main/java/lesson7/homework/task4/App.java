package lesson7.homework.task4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String[] words = {
                "dog", "cat", "car", "table", "world",
                "car", "note", "little", "dog", "mouse",
                "car", "book", "piano", "stream", "piano"
        };
        List<String> listOfWords = List.of(words);
        System.out.println("Список всех слов:\n" + listOfWords);
        List<String> unique = getUnique(listOfWords);
        System.out.println("Список без повторений:\n" + unique);
        quantityOfWord(listOfWords, unique);
        System.out.println("\n");
        numsOfWord(listOfWords);
    }

    private static void numsOfWord(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        System.out.println("Уникальные слова: " + map.keySet());
        System.out.println("Кол-во уникальных слов: " + map);
    }

    private static void quantityOfWord(List<String> words, List<String> unique) {
        int count = 0;
        for (String word : unique) {
            for (String el : words) {
                if (word.equals(el)) {
                    count++;
                }
            }
            System.out.printf("\n%s: %d раз", word, count);
            count = 0;
        }
    }

    private static List<String> getUnique(List<String> array) {
        HashSet<String> unique = new HashSet<>(array);
        return unique.stream().toList();
    }
}
