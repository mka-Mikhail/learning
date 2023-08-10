package lesson10.homework.task1;

/**
 * Метод generateThreads создаёт заданное кол-во потоков,
 * которые печатают одну букву определённое кол-во раз.
 * Потоки работают таким образом: буквы выводятся в последовательность алфавитного порядка,
 * последовательность выводится определённое кол-во раз
 */
public class App {
    private static Object monitor = new Object();
    private static char currentLetter = 'A';

    public static void main(String[] args) {
        generateThreads(5, 3);
    }

    private static void generateThreads(int countThreads, int countLetter) {
        for (int i = 0; i < countThreads; i++) {
            int forLetter = i;
            new Thread(() -> {
                synchronized (monitor) {
                    try {
                        char letter = (char) ('A' + forLetter);
                        for (int j = 0; j < countLetter; j++) {
                            while (currentLetter != letter) {
                                monitor.wait();
                            }
                            System.out.print(letter);
                            if (currentLetter - 'A' + 1 == countThreads) {
                                currentLetter = 'A';
                                System.out.println();
                            } else {
                                currentLetter += 1;
                            }
                            monitor.notifyAll();
                        }
                    } catch (InterruptedException e) {}
                }
            }).start();
        }
    }
}
