package lesson10.homework.task2;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Посчитать сумму элементов массива размером 1 млн,
 * распределив по 200000 элементов в разные потоки, используя ExecutorService.
 * Каждый поток рассчитывают свою сумму, и возвращают эту сумму основному потоку,
 * основной поток суммирует результаты потоков
 */
public class UsingExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[1_000_000];
        Arrays.fill(array, 1);
        long totalSum = 0;
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIdx = i * 200_000;
            int endIdx = (i + 1) * 200_000;
            Future<Long> sumByOneThread = service.submit(() -> {
                long sum = 0;
                for (int j = startIdx; j < endIdx; j++) {
                    sum += array[j];
                }
                return sum;
            });
            totalSum += sumByOneThread.get();
        }
        service.shutdown();
        System.out.println(totalSum);
    }
}
