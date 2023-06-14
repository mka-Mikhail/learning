package lesson6.homework.ioStreams;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class CopyPicture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source;
        File file;
        while (true) {
            source = sc.nextLine();
            file = new File(source);
            if (file.exists() && file.isFile()) {
                break;
            } else {
                System.out.println("File not found or not file");
            }
        }
        String separator;
        if (File.separator.equals("\\") && file.isAbsolute()) {
            separator = "\\\\";
        } else {
            separator = "/";
        }
        String fileName = new LinkedList<>(Arrays.stream(source.split(separator)).toList()).getLast();  // получаем имя файла, разбивая абсолютный путь по разделителю
        String copyTo = "data/lesson6/" + fileName;
        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(copyTo)) {
            char[] buffer = new char[1024];
            while (reader.read(buffer) != -1) {
                writer.write(buffer);
            }
        } catch (IOException e) {}
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copyTo))) {
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
            }
        } catch (IOException e) {}
    }
}
