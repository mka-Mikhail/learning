package lesson1.homework.HW2;

import java.util.Arrays;
import java.util.Random;

public class HW2 {

    public static void main(String[] args) {
        System.out.println("\n1:");
        int[] arr1 = {1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) arr1[i] = 0;
            else arr1[i] = 1;
        }
        System.out.println(Arrays.toString(arr1));

        System.out.println("\n2:");
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2));

        System.out.println("\n3:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        System.out.println("\n4:");
        int[][] arr4 = new int[4][4];
        for (int i = 0; i < 4; i++) {
            arr4[i][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n5:");
        int[] arr5 = new Random().ints(10, -100, 101).toArray();
        System.out.println(Arrays.toString(arr5));
        int max = -101;
        int min = 101;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min) {
                min = arr5[i];
            }
            if (arr5[i] > max) {
                max = arr5[i];
            }
        }
        System.out.println("max = " + max + ", min = " + min);

        System.out.println("\n6:");
        int[] arr6 = {1, 2, 3, 1, 6, 1};
        System.out.println(Arrays.toString(arr6) + " " + checkBalance(arr6));

        System.out.println("\n7:");
        int[] arr7 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr7));
        int n = 3;
        System.out.println("при n = " + n + ": " + Arrays.toString(offsetArray(arr7, n)));
    }

    private static boolean checkBalance(int[] arr) {
        int sumLeft = 0, sumRight = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sumRight += arr[i];
        }
        while (sumLeft != sumRight && count < arr.length) {
            sumRight -= arr[count];
            sumLeft += arr[count];
            count++;
        }
        return sumLeft == sumRight;
    }

    private static int[] offsetArray(int[] arr, int n) {
        int lastElement;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                lastElement = arr[arr.length - 1];
                for (int j = arr.length - 1 - 1; j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[0] = lastElement;
            }
            return arr;
        } else if (n < 0) {
            for (int i = -1; i >= n; i--) {
                lastElement = arr[0];
                for (int j = 0; j <= arr.length - 1 - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = lastElement;
            }
            return arr;
        } else {
            return arr;
        }
    }
}
