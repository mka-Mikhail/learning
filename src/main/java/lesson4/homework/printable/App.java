package lesson4.homework.printable;

interface Printable {
    String print(String str);
}

public class App {
    public static void main(String[] args) {
        String str = new Printable() {
            @Override
            public String print(String str) {
                return "STRING: " + str;
            }
        }.print("строка");
        System.out.println(str);
    }
}
