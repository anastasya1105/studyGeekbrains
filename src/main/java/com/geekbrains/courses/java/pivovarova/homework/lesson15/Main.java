package com.geekbrains.courses.java.pivovarova.homework.lesson15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1.	Напишите метод, который подсчитывает сколько раз в текстовом файле встречается указанная последовательность символов с учетом регистра
(только для латиницы). Реализуйте решение на основе FileChannel и ByteBuf;
2.	Напишите метод, который последовательно сшивает все текстовые файлы в указанном каталоге в один файл
(подкаталоги обходить не надо) с помощью Java NIO;
3.	Напишите метод, выполняющий поиск файлов размером менее 100 КБ в указанном каталоге и его подкаталогах;
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        1  Задание
        System.out.println(countWordInFile("javaText.txt", "javarush.task"));
//        2  Задание
//        Path pathToFile = Paths.get("C:","Users", "serdy", "IdeaProjects", "studyGeekbrains", "Demo");
//        System.out.println(pathToFile, "outfile2.txt");
//        try {
//            mergeAllFilesInDirectory(pathToFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       3  Задание
//        Path pathToFile3 = Paths.get("C:","Users", "serdy", "IdeaProjects", "studyGeekbrains", "Demo");
//        long fileSize = 102400;
//        for (Path path : searchFilesBySize(pathToFile3, fileSize)) {
//            System.out.println(path);
//        }

    }
    public static int countWordInFile(String fileName, String str) throws IOException {
        char[] charInWords = str.toCharArray();
        int count = 0, ticket = 0;
        try (RandomAccessFile src = new RandomAccessFile(fileName, "rw");
        FileChannel srcChanel = src.getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(str.length());
            int bytesRead = srcChanel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    if ((char) buffer.get() == charInWords[ticket]) {
                        ticket++;
                        if (ticket == str.length()) {
                            count++;
                            ticket=0;
                        }
                    }
                }
                buffer.clear();
                bytesRead = srcChanel.read(buffer);
            }
        }
        return count;
    }
    public static void mergeAllFilesInDirectory(Path path, String nameNewFile) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path, 1)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> !Files.isDirectory(p))
                    .filter(p -> p.getFileName().toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        }
        RandomAccessFile dst = new RandomAccessFile(nameNewFile, "rw");
        FileChannel dstChanel = dst.getChannel();
        for (Path path1 : result) {
            RandomAccessFile src = new RandomAccessFile(String.valueOf(path1), "rw");
            FileChannel srcChanel = src.getChannel();
            dstChanel.transferFrom(srcChanel, dstChanel.size(), srcChanel.size());
        }



    }
    public static List<Path> searchFilesBySize (Path path, long fileSize) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<Path> FilesWithAGivenSize;
        try (Stream<Path> walk = Files.walk(path)) {
            FilesWithAGivenSize = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> !Files.isDirectory(p))
                    .filter(p -> checkFileSize(p, fileSize))
                    .collect(Collectors.toList());
        }
        return FilesWithAGivenSize;
    }
    private static boolean checkFileSize(Path path, long fileSize){
        boolean result = false;
        try {
            if (Files.size(path) <= fileSize) {
                result = true;
            }
        } catch (IOException e) {
            System.out.println("Unable to get the file size of this file: " + path);
        }
        return result;
    }
}
