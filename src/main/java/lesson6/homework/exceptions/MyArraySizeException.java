package lesson6.homework.exceptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Неверный размер массива");
    }
}
