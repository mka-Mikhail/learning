package lesson4.homework.cookable;

abstract class Cookable {
    abstract void cook(String str);
}

class Food {
    public void prepare(Cookable c, String str) {
        c.cook(str);
    }
}

public class App {
    public static void main(String[] args) {
        Food food = new Food();
        food.prepare(new Cookable() {
            @Override
            void cook(String str) {
                System.out.println("Начинаем готовить");
                System.out.println(str);
            }
        }, "котлеты");
    }
}
