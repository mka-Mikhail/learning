package lesson6.homework.exceptions;

public class StringArray {
    public static void sumOfArray(String[][] array) {
        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException();
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (RuntimeException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            System.out.println("сумма: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
