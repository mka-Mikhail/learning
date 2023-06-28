package lesson7.homework.task4;

import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String[] words = {
                "dog", "cat", "car", "table", "world",
                "car", "note", "little", "dog", "mouse",
                "car", "book", "piano", "stream", "piano"
        };
        List<String> arrayOfWords = List.of(words);
        System.out.println("Список всех слов:\n" + arrayOfWords);
        List<String> unique = getUnique(arrayOfWords);
        System.out.println("Список без повторений:\n" + unique);
        quantityOfWord(arrayOfWords, unique);
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
