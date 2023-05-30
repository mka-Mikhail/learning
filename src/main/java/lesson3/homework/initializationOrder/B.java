package lesson3.homework.initializationOrder;

public class B extends A {
    private static final String B = classMethodB();

    static {
        System.out.println("B статический блок");
    }
    {
        System.out.println("B обычный блок");
    }

    public B() {
        System.out.println("B конструктор");
    }

    private static String classMethodB() {
        System.out.println("B класс");
        return "B";
    }
}
