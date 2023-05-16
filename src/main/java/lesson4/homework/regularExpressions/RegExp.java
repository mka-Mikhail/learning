package lesson4.homework.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        //1
        System.out.println("\n1 Проверка по шаблону: [\\w]+");
        System.out.println("aA1_" + " - " + "aA1_".matches("[\\w]+"));
        System.out.println("aA1_-" + " - " + "aA1_-".matches("[\\w]+"));
        //2
        System.out.println("\n2 Проверка по шаблону: ([a-z]+_[a-z]+)+");
        System.out.println("hello_world" + " - " + "hello_world".matches("([a-z]+_[a-z]+)+"));
        System.out.println("hello-world" + " - " + "hello-world".matches("([a-z]+_[a-z]+)+"));
        System.out.println("hello" + " - " + "hello".matches("([a-z]+_[a-z]+)+"));
        System.out.println("hello_" + " - " + "hello_".matches("([a-z]+_[a-z]+)+"));
        //3
        System.out.println("\n3 Проверка по шаблону: [^gG].*[gG].*[^gG]");
        System.out.println("good" + " - " + "good".matches("[^gG].*[gG].*[^gG]"));
        System.out.println("DOG" + " - " + "DOG".matches("[^gG].*[gG].*[^gG]"));
        System.out.println("doggy" + " - " + "doggy".matches("[^gG].*[gG].*[^gG]"));
        //4
        System.out.println("\n4 Найти все html-теги в тексте");
        String content = "<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>";
        pattern = Pattern.compile("</?\\w+>");
        matcher = pattern.matcher(content);
        System.out.println("Текст: " + content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        //5
        System.out.println("\n5 Валидация email");
        System.out.println("1-wR_@qwe1.ru" + " - " + "1-wR_@qwe1.ru".matches("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,3}"));
        System.out.println("1-wR_@qwe1-.ru" + " - " + "1-wR_@qwe1-.ru".matches("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,3}"));
        System.out.println("1-wR_qwe1.ru" + " - " + "1-wR_qwe1.ru".matches("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,3}"));
        System.out.println("1-wR_@qwe1-.russ" + " - " + "1-wR_@qwe1-.russ".matches("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,3}"));
        System.out.println("1-wR_@qwe1.ru1" + " - " + "1-wR_@qwe1.ru1".matches("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,3}"));
    }
}
