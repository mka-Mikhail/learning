package lesson6.homework.ioStreams.forBytes;

import java.io.*;

public class BuffInOutStreams {
    public static void main(String[] args) {
        String source = "data/lesson6/source.txt";
        String copyTo = "data/lesson6/copyTo.txt";
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source), 102400);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copyTo), 102400)) {
            byte[] buffer = new byte[1024];
            long start = System.currentTimeMillis();
            while (in.read(buffer) != -1) {
                out.write(buffer);
            }
            System.out.println("Время работы: " + (System.currentTimeMillis() - start));
        } catch (IOException e) {}
    }
}
