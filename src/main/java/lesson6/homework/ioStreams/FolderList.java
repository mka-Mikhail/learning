package lesson6.homework.ioStreams;

import java.io.File;
import java.util.Scanner;

public class FolderList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File folder;
        while (true) {
            String source = sc.nextLine();
            folder = new File(source);
            if (folder.exists() && folder.isDirectory()) {
                break;
            } else {
                System.out.println("Folder is not found or it is not folder");
            }
        }
        sc.close();
        getSubFolders(folder);
    }

    private static void getSubFolders(File folder) {
        if (folder.isDirectory()) {
            File[] allFiles = folder.listFiles();
            for (File f : allFiles) {
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                    getSubFolders(f);
                }
            }
        }
    }
}
