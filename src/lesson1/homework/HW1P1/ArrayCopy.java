package lesson1.homework.HW1P1;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("original: " + Arrays.toString(original));
        int[] copyArr1 = new int[original.length];
        int[] copyArr2 = new int[original.length];
        System.arraycopy(original, 0, copyArr1, 0, original.length);
        System.out.println("arr1: " + Arrays.toString(copyArr1));
        System.arraycopy(original, 5, copyArr2, 2, original.length - 6);
        System.out.println("arr2: " + Arrays.toString(copyArr2));
    }
}
