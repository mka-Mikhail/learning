package lesson3.homework.task;

import java.util.Scanner;

public class Task {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String mask = "00000000";
        System.out.println(mask);
        String num;
        while (true) {
            num = sc.nextLine();
            try {
                if (Integer.parseInt(num) >= 1 && Integer.parseInt(num) <= 10000) {
                    break;
                } else {
                    System.out.println("Неверный формат");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат");
            }
        }
        StringBuilder numLog = new StringBuilder(mask);
        numLog.insert((mask.length() - num.length()), num).delete(mask.length(), numLog.length());
        System.out.println(numLog);
    }
}
