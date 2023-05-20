package lesson4.homework.task12;

import java.util.Random;

public class TaskExecutor {
    private int numberOfExecutions = 0;

    public void executeTask(Task task) throws InterruptedException {
        Random random = new Random();
        long timeStop;
        long timeOfLastExecution = 0;
        while (true) {
            timeStop = System.currentTimeMillis() + 60 * 1000;
            while (numberOfExecutions != 10) {
                task.execute();
                timeOfLastExecution = System.currentTimeMillis();
                if (System.currentTimeMillis() >= timeStop - 300) {
                    break;
                }
                numberOfExecutions++;
                System.out.println("Кол-во выполнений: " + numberOfExecutions);
                int sleep = (random.nextInt(10) + 1) * 1000;
                System.out.println("Пауза: " + sleep / 1000);
                Thread.sleep(sleep);
            }
            if (numberOfExecutions == 10) {
                System.out.println("\nМетод отработал 10 раз\n");
            } else {
                System.out.println("\nМетод НЕ отработал 10 раз\n");
            }
            if (timeOfLastExecution < timeStop) {
                System.out.println("Ждём ещё: " + (timeStop - timeOfLastExecution) + "\n");
                Thread.sleep(timeStop - timeOfLastExecution);
            }
            numberOfExecutions = 0;
        }
    }
}
