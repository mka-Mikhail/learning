package lesson6.homework.exceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super(String.format("Неверный формат данных в ячейке: [%d][%d]", row, col));
    }
}
