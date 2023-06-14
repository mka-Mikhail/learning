package lesson4.homework.task12;

public class App {
    public static void main(String[] args) throws InterruptedException {
        TaskExecutor taskExecutor = new TaskExecutor(10);
        taskExecutor.executeTask(new Task());
    }
}
