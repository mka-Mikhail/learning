package lesson3.homework.initializationOrder;

public class Example {
    private static final String i1 = classMethod();
    private String i2 = objectMethod();

    public Example(String call) {
        System.out.println(call + "\nконструктор");
    }

    static {
        System.out.println("статический блок 1");
    }
    {
        System.out.println("блок 1");
    }
    static {
        System.out.println("статический блок 2");
    }
    {
        System.out.println("блок 2");
    }

    private static String classMethod() {
        System.out.println("метод класса");
        return "1";
    }

    private String objectMethod() {
        System.out.println("метод объекта");
        return "2";
    }

    public static void main(String[] args) {
        new Example("FIRST");
        new Example("SECOND");
    }
}
