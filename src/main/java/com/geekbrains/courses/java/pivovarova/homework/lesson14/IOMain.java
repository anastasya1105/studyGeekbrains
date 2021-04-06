package com.geekbrains.courses.java.pivovarova.homework.lesson14;
/*
1.	Напишите метод, который подсчитывает сколько раз в текстовом файле встречается указанная
последовательность символов с учетом регистра (только для латиницы);
2.	Напишите метод, который последовательно сшивает все текстовые файлы в указанном каталоге в один файл (подкаталоги обходить не надо);
3.	Напишите метод, позволяющий удалить каталог с вложенными файлами и каталогами;

 */
import java.io.*;
import java.util.*;

public class IOMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//      1  Задание
        File file = new File("javaText.txt");
        System.out.println(countWordInFile(file, "javarush.task"));
//        2 Задание
        File file2 = new File("C:\\Users\\serdy\\IdeaProjects\\studyGeekbrains\\Demo");
        try {

            mergeAllFilesInDirectory(file2, new File("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        3 Задание
        File file3 = new File("C:\\Users\\serdy\\IdeaProjects\\studyGeekbrains\\Demo41");
       deleteDirectory(file3);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    public static int countWordInFile(File file, String str) {
        int count = 0;
        int countStrCrar = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String string;
            while ((string = reader.readLine()) != null) {
                for (countStrCrar = 0; countStrCrar!= -1; ) {
                    countStrCrar = string.indexOf(str, countStrCrar);
                    if (countStrCrar != -1) {
                        count++;
                        countStrCrar += str.length();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
    //2. Напишите метод, который последовательно сшивает все текстовые файлы в указанном каталоге в один файл (подкаталоги обходить не надо);
    public static File mergeAllFilesInDirectorySimple(File file,File newFile) throws IOException {
        if (file.isFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true ))){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String string;
                while ((string = reader.readLine()) != null) {
                    writer.write(string + "\n");
                }
            }
        }
        return newFile;
    }
    public static File mergeAllFilesInDirectory(File file,File newFile) throws IOException {
        if (file.isFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true ))){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String string;
                while ((string = reader.readLine()) != null) {
                    writer.write(string + "\n");
                }
            }
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
                for (File f : files) {
                    mergeAllFilesInDirectory(f, newFile);
                }
        }
        return newFile;
    }

//    3.	Напишите метод, позволяющий удалить каталог с вложенными файлами и каталогами;
    public static void deleteDirectory(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteDirectory(f);
            }
        }
        file.delete();
    }
}
