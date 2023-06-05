package lesson5.homework.task1;

import lombok.Getter;

@Getter
public class Bus implements Vehicle {
    private int numOfSeats;

    public Bus() {
        numOfSeats = 20;
    }

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }
}
