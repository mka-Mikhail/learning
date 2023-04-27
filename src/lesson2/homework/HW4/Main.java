package lesson2.homework.HW4;

public class Main {

    public static void main(String[] args) {
        Animal cat1 = new Cat();
        Animal dog1 = new Dog();

        System.out.println("\ncat1");
        System.out.println("бег: " + cat1.run(200));
        System.out.println("плаванье: " + cat1.swim(100));
        System.out.println("прыжок: " + cat1.jump(2));

        System.out.println("\ndog1");
        System.out.println("бег: " + dog1.run(200));
        System.out.println("плаванье: " + dog1.swim(100));
        System.out.println("прыжок: " + dog1.jump(2));

        Animal cat2 = new Cat(250, 7, 4);
        Animal dog2 = new Cat(600, 15, 2);

        System.out.println("\ncat2");
        System.out.println("бег: " + cat2.run(200));
        System.out.println("плаванье: " + cat2.swim(100));
        System.out.println("прыжок: " + cat2.jump(2));

        System.out.println("\ndog2");
        System.out.println("бег: " + dog2.run(200));
        System.out.println("плаванье: " + dog2.swim(100));
        System.out.println("прыжок: " + dog2.jump(2));
    }
}
