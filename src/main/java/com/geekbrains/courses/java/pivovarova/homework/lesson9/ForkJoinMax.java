package com.geekbrains.courses.java.pivovarova.homework.lesson9;
/*
1	С помощью RecursiveTask и ForkJoinPool.commonPool() реализуйте поиск максимального элемента
в целочисленном массиве (int[]). Размер массива: 100.000.000, в каждой ячейке лежит случайное число от 0 до 100000.
Сравните скорость выполнения с однопоточным вариантом;
2	Ту же задачу выполните через stream() и parallelStream();
3	Ответьте на вопрос: какой вариант самый быстрый? Замеры времени в мс добавьте в комментариях к коду.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
//С помощью RecursiveTask и ForkJoinPool.commonPool() Time: 179
// Через parallelStream() Time: 73
// Через stream Time: 73
// WithoutStream Time: 54
public class ForkJoinMax {
    private static Random random = new Random();
    private static final int N = 100_000_000;
    private static int[] massiv= new int[N];
    private static final int HOLD = 10000;

    public static void main(String[] args) {
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = random.nextInt(100_000);
        }
        ForkJoinMax forkJoinMax = new ForkJoinMax();
        long start = System.currentTimeMillis();
        int max = new ForkJoinPool().invoke(new FindMaxTask(0, N));
        System.out.println("Time across RecursiveTask and ForkJoinPool.commonPool(): " + (System.currentTimeMillis() - start));
        System.out.println(max);
        long start1 = System.currentTimeMillis();
        searchForMaximumParallel(massiv);
        System.out.println("Time across parallelStream(): " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        searchForMaximum(massiv);
        System.out.println("Time across stream: " + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        searchWithoutStream(massiv);
        System.out.println("Time WithoutStream: " + (System.currentTimeMillis() - start3));
    }
    //Task1
        static class FindMaxTask extends RecursiveTask<Integer> {
            private int start;
            private int end;
            private FindMaxTask(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            protected Integer compute() {
                int length = end - start;
                if (length < 10000) {
                    return directly();
                }
                    int seredina = length / 2;
                    FindMaxTask left = new FindMaxTask(start, start + seredina);
                    left.fork();
                    FindMaxTask right = new FindMaxTask(start + seredina, end);
                    right.fork();
                    return Math.max(right.join(), left.join());

            }
            private Integer directly() {
                int max = 0;
                for (int i = start; i < end; i++) {
                    if (massiv[i] > max) {
                        max = massiv[i];
                    }
                }
                return max;
            }

        }

    // Через parallelStream()
    public static int searchForMaximumParallel(int[] massiv) {
        return IntStream.of(massiv).parallel().max().orElse(0);
    }
    //// Через stream
    public static int searchForMaximum(int[] massiv) {
        return IntStream.of(massiv).max().orElse(0);
    }
    public static int searchWithoutStream(int[] massiv) {
        int max = 0;
        for (int m : massiv) {
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

}
