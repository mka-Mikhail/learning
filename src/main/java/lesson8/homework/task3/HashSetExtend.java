package lesson8.homework.task3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс, расширяющий HashSet:
 * метод объединения двух множеств,
 * метод пересечения двух множеств
 */
public class HashSetExtend<T> extends HashSet<T> {
    public HashSetExtend(List<T> set) {
        super(set);
    }

    public HashSet<T> union(Set<T> set) {
        HashSet<T> result = new HashSet<>(this);
        result.addAll(set);
        return result;
    }

    public HashSet<T> intersect(Set<T> set) {
        HashSet<T> result = new HashSet<>(this);
        result.retainAll(set);
        return result;
    }
}
