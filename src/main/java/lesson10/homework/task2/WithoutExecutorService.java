package lesson10.homework.task2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Посчитать сумму элементов массива размером 1 млн,
 * распределив по 200000 элементов в разные потоки, без ExecutorService.
 * Каждый поток рассчитывают свою сумму, и возвращают эту сумму основному потоку,
 * основной поток суммирует результаты потоков
 */

class Sum extends Thread {
    private int startIdx;
    private int endIdx;
    private int[] array;
    private long sum;

    public Sum(int startIdx, int endIdx, int[] array) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = startIdx; i < endIdx; i++) {
            sum += array[i];
        }
    }

    public long getSum() {
        return sum;
    }
}

public class WithoutExecutorService {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1_000_000];
        Arrays.fill(array, 1);
        long totalSum = 0;
        for (int i = 0; i < 5; i++) {
            int startIdx = i * 200_000;
            int endIdx = (i + 1) * 200_000;
            Sum sum = new Sum(startIdx, endIdx, array);
            sum.start();
            sum.join();
            totalSum += sum.getSum();
        }
        System.out.println(totalSum);
    }
}
