package lesson7.homework.task3;

public class App {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        /**
         * appleBox1: 6 яблок
         * appleBox2: 4 яблока
         */
        for (int i = 0; i < 6; i++) {
            appleBox1.addFruit(new Apple());
            if (i < 4) {
                appleBox2.addFruit(new Apple());
            }
        }
        /**
         * orangeBox1: 4 апельсина
         * orangeBox2: 4 апельсина
         */
        for (int i = 0; i < 4; i++) {
            orangeBox1.addFruit(new Orange());
            orangeBox2.addFruit(new Orange());
        }

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Вес orangeBox1: " + orangeBox1.getWeight());
        System.out.println("Вес orangeBox2: " + orangeBox2.getWeight());

        System.out.println("\nappleBox1 и orangeBox1: " + compare(appleBox1, orangeBox1));
        System.out.println("appleBox1 и appleBox2: " + compare(appleBox1, appleBox2));

        System.out.println("\nПересыпаем из orangeBox1 в orangeBox2");
        orangeBox2.pourOver(orangeBox1);
        System.out.println("Вес orangeBox2 после: " + orangeBox2.getWeight());
    }

    private static <T extends Fruit> String compare(Box<?> box1, Box<?> box2) {
        return box1.compare(box2) ? "Вес равен" : "Вес не равен";
    }
}
