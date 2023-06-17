package lesson6.homework.exceptions;

public class App {
    public static void main(String[] args) {
        String[][] arr1 = {
                {"0", "1", "2", "3"},
                {"1", "4", "5", "6"},
                {"2", "7", "8", "9"},
                {"3", "10", "11", "12"}
        };
        String[][] arr2 = new String[2][2];
        String[][] arr3 = {
                {"0", "1", "2", "3"},
                {"1", "-", "5", "6"},
                {"2", "7", "8", "9"},
                {"3", "10", "str", "12"}
        };
        StringArray.sumOfArray(arr1);
        StringArray.sumOfArray(arr2);
        StringArray.sumOfArray(arr3);
    }
}
