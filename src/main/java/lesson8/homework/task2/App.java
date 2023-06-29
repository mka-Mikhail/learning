package lesson8.homework.task2;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap с кастомным компаратором: сначала сортировка происходит по длине строки, потом по алфавиту
 */
public class App {
    public static void main(String[] args) {
        TreeMap<String, String> strings = new TreeMap<>((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });
        strings.put("aaa", "aaa");
        strings.put("aa", "aa");
        strings.put("ab", "ab");
        strings.put("abb", "abb");
        strings.put("acb", "acb");
        strings.put("a", "a");
        for (Map.Entry<String, String> entry : strings.entrySet() ){
            System.out.println(entry.getValue());
        }
    }
}
