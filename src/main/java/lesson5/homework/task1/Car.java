package lesson5.homework.task1;

import lombok.Getter;

enum Color {
    RED("Красный"),
    BLUE("Синий"),
    GREEN("Зелёный");

    String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

@Getter
public class Car implements Vehicle {
    private int numOfSeats;
    private String color;

    public Car() {
        numOfSeats = 5;
        int colorNum = (int) (Math.random() * Color.values().length);
        switch (colorNum) {
            case 0:
                color = Color.RED.getColor();
                break;
            case 1:
                color = Color.BLUE.getColor();
                break;
            case 2:
                color = Color.GREEN.getColor();
                break;
        }
    }

    @Override
    public void drive() {
        System.out.println("Машина едет");
    }
}
