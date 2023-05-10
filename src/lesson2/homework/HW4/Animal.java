package lesson2.homework.HW4;

public class Animal {
    private int limitRun;
    private int limitSwim;
    private float limitJump;

    public Animal(int limitRun, int limitSwim, float limitJump) {
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public boolean run(int distance) {
        return limitRun >= distance;
    }
    public boolean swim(int distance) {
        if (this instanceof Cat) {
            System.out.println("Коты не плавают");
            return false;
        }
        return limitSwim >= distance;
    }
    public boolean jump(float distance) {
        return limitJump >= distance;
    }
}
