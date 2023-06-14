package lesson6.homework.ioStreams.forSymbols;

import java.io.*;

public class BuffReaderWriter {
    public static void main(String[] args) {
        String source = "data/lesson6/source.txt";
        String copyTo = "data/lesson6/copyTo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(source), 102400);
             BufferedWriter writer = new BufferedWriter(new FileWriter(copyTo), 102400)) {
            char[] buffer = new char[1024];
            long start = System.currentTimeMillis();
            while (reader.read(buffer) != -1) {
                writer.write(buffer);
            }
            System.out.println("Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }
}
