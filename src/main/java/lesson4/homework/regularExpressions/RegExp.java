package lesson4.homework.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        Pattern ptn;
        Matcher matcher;
        String pattern;
        //1
        pattern = "[\\w]+";
        System.out.println("\n1 Проверка по шаблону: " + pattern);
        System.out.println("aA1_" + " - " + "aA1_".matches(pattern));
        System.out.println("aA1_-" + " - " + "aA1_-".matches(pattern));
        //2
        pattern = "([a-z]+_[a-z]+)+";
        System.out.println("\n2 Проверка по шаблону: " + pattern);
        System.out.println("hello_world" + " - " + "hello_world".matches(pattern));
        System.out.println("hello-world" + " - " + "hello-world".matches(pattern));
        System.out.println("hello" + " - " + "hello".matches(pattern));
        System.out.println("hello_" + " - " + "hello_".matches(pattern));
        //3
        pattern = "[^gG].*[gG].*[^gG]";  //  \\B[gG]\\B
        System.out.println("\n3 Проверка по шаблону: " + pattern);
        System.out.println("good" + " - " + "good".matches(pattern));
        System.out.println("DOG" + " - " + "DOG".matches(pattern));
        System.out.println("doggy" + " - " + "doggy".matches(pattern));
        //4
        System.out.println("\n4 Найти все html-теги в тексте");
        String content = "<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>";
        ptn = Pattern.compile("</?\\w+>");
        matcher = ptn.matcher(content);
        System.out.println("Текст: " + content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        //5
        pattern = "[\\w-\\.]+@[a-z0-9-]+\\.[a-z]{2,3}";
        System.out.println("\n5 Валидация email");
        System.out.println("1-wR_@qwe1.ru" + " - " + "1-wR_@qwe1.ru".matches(pattern));
        System.out.println("1.-wR_@qwe1.ru" + " - " + "1.-wR_@qwe1.ru".matches(pattern));
        System.out.println("1-wR_@qwe1-.ru" + " - " + "1-wR_@qwe1-.ru".matches(pattern));
        System.out.println("1-wR_qwe1.ru" + " - " + "1-wR_qwe1.ru".matches(pattern));
        System.out.println("1-wR_@qwe1-.russ" + " - " + "1-wR_@qwe1-.russ".matches(pattern));
        System.out.println("1-wR_@qwe1.ru1" + " - " + "1-wR_@qwe1.ru1".matches(pattern));
    }
}
