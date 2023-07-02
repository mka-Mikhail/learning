package lesson7.homework.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4};
        String[] strs = {"one", "two", "three"};
        ArrayList<Integer> integers = toArrayList(nums);
        ArrayList<String> strings = toArrayList(strs);
        System.out.println(integers);
        System.out.println(strings);
        System.out.println(Arrays.asList(nums));
    }

    public static <T> ArrayList<T> toArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T el : array) {
            arrayList.add(el);
        }
        return arrayList;
    }
}
