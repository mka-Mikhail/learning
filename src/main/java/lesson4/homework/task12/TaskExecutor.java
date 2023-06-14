package lesson4.homework.task12;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TaskExecutor {
    private final Queue<Long> queue = new LinkedList<>();
    private int maxExecsPerMinute;
    private int lastExecsPerMinute;

    public TaskExecutor(int maxExecsPerMinute) {
        this.maxExecsPerMinute = maxExecsPerMinute;
    }

    public void executeTask(Task task) throws InterruptedException {
        Random random = new Random();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        long currentExecTime;
        while (true) {
            currentExecTime = System.currentTimeMillis();
            if (queue.peek() != null && currentExecTime - queue.peek() > 60000) {
                lastExecsPerMinute--;
                queue.remove();
            }
            if (lastExecsPerMinute < maxExecsPerMinute) {
                task.execute();
                System.out.println(timeFormat.format(new Date(currentExecTime)));
                lastExecsPerMinute++;
                queue.add(System.currentTimeMillis());
            } else {
                System.out.println("LIMIT!!! " + timeFormat.format(new Date(currentExecTime)));
            }
            int sleepTime = random.nextInt(20) * 1000;
            System.out.println("ПАУЗА: " + sleepTime / 1000 + "\n");
            Thread.sleep(sleepTime);
        }
    }
}
