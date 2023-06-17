package lesson1.homework.HW1P2;

public class HW1P2 {

    public static void main(String[] args) {
        byte a = 127;
        short b = 9999;
        int c = 999_999_999;
        long d = 999_999_999_999_999_999L;
        float e = 12.67434f;
        double f = -12345.3456;
        boolean g = true;
        char h = 'c';

        System.out.println("3: a * (b + (c / d)) = " + calculate(2, 1, 5.7, 9));
        System.out.println("4: " + checkSum(9, 4));
        System.out.println("5: " + checkNum(0));
        System.out.println("6: " + checkNum1(-1));
        System.out.print("7: "); hello("MKA");
        int year = 2023;
        System.out.println("8:\n" +
                year + " год " + (isLeapYear(year) ? "високосный" : "не високосный"));
    }

    private static double calculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean checkSum(int a, int b) {
        return 10 < (a + b) && (a + b) <= 20;
    }

    private static String checkNum(int a) {
        return a < 0 ? "Число " + a + " отрицительное" : "Число " + a + " положительное";
    }

    private static boolean checkNum1(int a) {
        return !(a >= 0);
    }

    private static void hello(String name) {
        System.out.println("Привет, " + name);
    }

    private static boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0) || year % 400 == 0;
    }
}
