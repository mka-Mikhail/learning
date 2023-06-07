package lesson5.homework.task2;

public class App {
    public static void main(String[] args) {
        int count = 0;
        String mask = "#";
        while (true) {
            String num = mask + (++count);
            A a = new A(num);
            a = null;
        }
    }
}
