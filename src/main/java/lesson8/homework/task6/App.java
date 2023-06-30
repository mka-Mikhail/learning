package lesson8.homework.task6;

public class App {
    public static void main(String[] args) {
        ThreeFunction<Integer, Integer> sumOfThreeNums = (x1, x2, x3) -> x1 + x2 + x3;
        System.out.println("Сумма 1, 9, 67: " + sumOfThreeNums.method(1, 9, 67));
        ThreeFunction<String, String> concat = (str1, str2, str3) -> str1 + str2 + str3;
        System.out.println("Конкатенация 3-х строк: " + concat.method("Hello", ", World", "!"));
    }
}
