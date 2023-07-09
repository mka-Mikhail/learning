package lesson8.homework.task5;

public class UsingCustomInterface {
    public static void main(String[] args) {
        OperationOnTwoNumbers multiplication = (x1, x2) -> x1 * x2;
        System.out.println("Умножение: " + multiplication.operation(2, 2));
        OperationOnTwoNumbers addition = new OperationOnTwoNumbers() {
            @Override
            public double operation(double x1, double x2) {
                return x1 + x2;
            }
        };
        System.out.println("Сложение: " + addition.operation(3, 7));
        OperationOnTwoNumbers subtraction = (x1, x2) -> {
            return x1 - x2;
        };
        System.out.println("Вычитание: " + subtraction.operation(9, -1));
    }
}
