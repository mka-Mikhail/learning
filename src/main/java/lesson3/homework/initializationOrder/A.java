package lesson3.homework.initializationOrder;

public class A {
    private static final String A = classMethodA();

    static {
        System.out.println("A статический блок");
    }
    {
        System.out.println("A обычный блок");
    }

    public A() {
        System.out.println("A конструктор");
    }

    private static String classMethodA() {
        System.out.println("A класс");
        return "A";
    }
}
