package lesson6.homework.ioStreams.forSymbols;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
    public static void main(String[] args) {
        String source = "data/lesson6/source.txt";
        String copyTo = "data/lesson6/copyTo.txt";
        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(copyTo)) {
            char[] buffer = new char[1024];
            long start = System.currentTimeMillis();
            while (reader.read(buffer) != -1) {
                writer.write(buffer);
            }
            System.out.println("Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }
}
