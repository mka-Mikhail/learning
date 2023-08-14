package lesson11.homework.task1;

import lesson6.homework.ioStreams.GenerateLargeFile;

import java.io.*;
import java.util.Scanner;

public class App {
    private static final String SOURCE = "data/lesson6/source.txt";
    private static final String COPY_TO = "data/lesson6/copyTo.txt";
    private static volatile boolean isRunning = true;

    public static void main(String[] args) {
//        GenerateLargeFile.main(null);

        Thread inputThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (isRunning) {
                    String input = scanner.nextLine();
                    if (input.equals("quit")) {
                        isRunning = false;
                        break;
                    }
                }
            }
        });
        inputThread.start();

        try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(COPY_TO))) {
            char[] buffer = new char[1024];
            int numOfBytesRead;
            long totalCopied = 0;
            while ((numOfBytesRead = reader.read(buffer)) != -1 && isRunning) {
                writer.write(buffer);
                totalCopied += numOfBytesRead;
                if (totalCopied % (1024 * 1024) == 0) {
                    System.out.print("\rСкопировано: "  + (totalCopied / (1024 * 1024)) + "Мб");
                    Thread.sleep(10);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        } catch (InterruptedException e) {}
        System.out.println("\nКопирование завершено, нажмите любую клавишу");
        isRunning = false;
    }
}
