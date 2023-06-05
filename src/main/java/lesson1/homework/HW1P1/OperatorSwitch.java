package lesson1.homework.HW1P1;

import java.util.Scanner;

public class OperatorSwitch {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        helpOutput();

        System.out.println("Введите два целых числа:");
        int a, b;
        a = sc.nextInt();
        sc.nextLine();
        b = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("Выбор действия: ");
            String operation = sc.nextLine();
            switch (operation) {
                case "*":
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                case "/":
                    System.out.println(a + " / " + b + " = " + ((float) a / (float) b));
                    break;
                case "+":
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case "//":
                    System.out.println(a + " // " + b + " = " + (a / b));
                    break;
                case "%":
                    System.out.println(a + " % " + b + " = " + (a % b));
                    break;
                case "\\q":
                    return;
                case "\\h":
                    helpOutput();
                    break;
                case "\\en":
                    a = sc.nextInt();
                    sc.nextLine();
                    b = sc.nextInt();
                    sc.nextLine();
                    break;
            }
        }
    }

    private static void helpOutput() {
        System.out.println("\nСПРАВКА:\n" +
                "\\h - вызов справки\n" +
                "\\q - завершение работы программы\n" +
                "\\en - ввести новую пару целых чисел\n" +
                "ВОЗМОЖНЫЕ ДЕЙСТВИЯ НАД ЧИСЛАМИ:\n" +
                "* - умножение чисел\n" +
                "/ - деление\n" +
                "+ - сложение\n" +
                "- - вычитание\n" +
                "% - остаток от деления\n" +
                "// - целочисленное деление\n");
    }
}
