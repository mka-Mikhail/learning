package lesson8.homework.task4;

import java.util.Comparator;

/**
 * Компаратор для сравнения по имени
 */
public class ComparatorPersonByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
