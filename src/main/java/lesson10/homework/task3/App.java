package lesson10.homework.task3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    private static final CyclicBarrier barrier = new CyclicBarrier(4);
    private static final AtomicInteger value = new AtomicInteger();
    private static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        Thread generator = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int num = new Random().nextInt(100);
                    System.out.println("Главный поток сгенерировал " + (i + 1) + " число: " + num);
                    value.set(num);
                    barrier.await();
                    Thread.sleep(1000);
                }
                System.out.println("Цикл закончен");
                isRunning.set(false);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread[] workers = new Thread[3];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(() -> {
                try {
                    while (isRunning.get() || barrier.getNumberWaiting() > 0) {
                        barrier.await();
                        if (!isRunning.get()) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " " + value.get());
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        generator.start();
        for (Thread worker :
                workers) {
            worker.start();
        }
        generator.join();
        for (Thread worker :
                workers) {
            worker.join();
        }
    }
}
