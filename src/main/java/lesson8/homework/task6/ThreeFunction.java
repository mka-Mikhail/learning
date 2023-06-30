package lesson8.homework.task6;

@FunctionalInterface
public interface ThreeFunction<T, R> {
    R method(T x1, T x2, T x3);
}
