package lesson6.homework.ioStreams.forBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutStreams {
    public static void main(String[] args) {
        String source = "data/lesson6/source.txt";
        String copyTo = "data/lesson6/copyTo.txt";
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(copyTo)) {
            byte[] buffer = new byte[1024];
            int numOfBytesRead;
            long iterations = 0;
            long start = System.currentTimeMillis();
            while ((numOfBytesRead = in.read(buffer)) != -1) {
                System.out.println("Прочитано байт: " + numOfBytesRead + ", повторение: " + ++iterations);
                //в таком случае копирование шло около 100 миллисекунд при размере буфера (массива buffer) 102400
                out.write(buffer);
                //в таком случае копирование шло около 5-ти минут
                /*for (int i = 0; i < numOfBytesRead; i++) {
                    out.write(buffer[i]);
                }*/
            }
            System.out.println("Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }
}
