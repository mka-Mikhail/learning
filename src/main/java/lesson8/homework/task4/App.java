package lesson8.homework.task4;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Создаём коллекцию с Persons -> Печатаем
 * Сортируем по имени -> Печатаем
 * Сортируем по возрасту -> Печатаем
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Сергей", 42));
        persons.add(new Person("Даниил", 35));
        persons.add(new Person("Михаил", 29));
        persons.add(new Person("Мария", 30));
        persons.add(new Person("Владимир", 41));

        System.out.println("До сортировки");
        persons.stream().forEach(System.out::println);

        persons.sort(Comparator.comparing(Person::getName));
        System.out.println("\nПосле сортировки по имени");
        persons.stream().forEach(System.out::println);

        persons.sort(Comparator.comparing(Person::getAge));
        System.out.println("\nПосле сортировки по возрасту");
        persons.stream().forEach(System.out::println);
    }
}
