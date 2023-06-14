package lesson6.homework.ioStreams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Генерируется файл размером 100 Мб с рандомными символами согласно кодировке ASCII
 */

public class GenerateLargeFile {
    public static void main(String[] args) {
        File source = new File("data/lesson6/source.txt");
        File copyTo = new File("data/lesson6/copyTo.txt");  // для создания файла, куда будем копировать текст из исходного
        try (FileWriter writer = new FileWriter(source, StandardCharsets.US_ASCII)) {
            source.createNewFile();
            copyTo.createNewFile();
            for (int i = 0; i < 100 * 1024 * 1024; i++) {
                writer.write((char) (Math.random() * 127));
            }
        } catch (IOException e) {}
        System.out.println("Размер файла: " + (source.length() / (1024 * 1024)) + " Мб");
    }
}
