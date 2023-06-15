package lesson6.homework.ioStreams;

import java.io.*;

/**
 * При размере буфера 1024:
 * FileInputStream \ FileOutputStream: 831 мсек
 * BufferedInputStream \ BufferedOutputStream: 81 мсек (в конструкторе ещё указан размер буфера: 102400)
 * BufferedInputStream \ BufferedOutputStream: 212 мсек (в конструкторе не указан размер буфера)
 * FileReader \ FileWriter: 378 мсек
 * BufferedFileReader \ BufferedFileWriter: 227 мсек
 *
 * При размере буфера 4096:
 * FileInputStream \ FileOutputStream: 315 мсек
 * BufferedInputStream \ BufferedOutputStream: 66 мсек (в конструкторе ещё указан размер буфера: 102400)
 * BufferedInputStream \ BufferedOutputStream: 172 мсек (в конструкторе не указан размер буфера)
 * FileReader \ FileWriter: 178 мсек
 * BufferedFileReader \ BufferedFileWriter: 208 мсек
 */
public class MethodsOfCopying {
    private static String source = "data/lesson6/source.txt";
    private static String copyTo = "data/lesson6/copyTo.txt";

    public static void main(String[] args) {
        try {
            createFileCopyTo();
            int sizeOfBuff = 1024;
            System.out.println("\nРазмер буфера " + sizeOfBuff);
            fileInOutStreams(sizeOfBuff);
            buffInOutStreams(sizeOfBuff);
            readerWriter(sizeOfBuff);
            buffReaderWriter(sizeOfBuff);
            sizeOfBuff = 4096;
            System.out.println("\nРазмер буфера " + sizeOfBuff);
            fileInOutStreams(sizeOfBuff);
            buffInOutStreams(sizeOfBuff);
            readerWriter(sizeOfBuff);
            buffReaderWriter(sizeOfBuff);
        } catch (IOException e) {}
    }

    private static void createFileCopyTo() throws IOException {
        File file = new File(copyTo);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private static void fileInOutStreams(int sizeOfBuff) {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(copyTo)) {
            byte[] buffer = new byte[sizeOfBuff];
            long start = System.currentTimeMillis();
            while (in.read(buffer) != -1) {
                out.write(buffer);
            }
            System.out.println("fileInOutStreams Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }

    private static void buffInOutStreams(int sizeOfBuff) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source)/*, 102400*/);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copyTo)/*, 102400*/)) {
            byte[] buffer = new byte[sizeOfBuff];
            long start = System.currentTimeMillis();
            while (in.read(buffer) != -1) {
                out.write(buffer);
            }
            System.out.println("buffInOutStreams Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }

    private static void readerWriter(int sizeOfBuff) {
        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(copyTo)) {
            char[] buffer = new char[sizeOfBuff];
            long start = System.currentTimeMillis();
            while (reader.read(buffer) != -1) {
                writer.write(buffer);
            }
            System.out.println("readerWriter Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }

    private static void buffReaderWriter(int sizeOfBuff) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(copyTo))) {
            char[] buffer = new char[sizeOfBuff];
            long start = System.currentTimeMillis();
            while (reader.read(buffer) != -1) {
                writer.write(buffer);
            }
            System.out.println("buffReaderWriter Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }
}
