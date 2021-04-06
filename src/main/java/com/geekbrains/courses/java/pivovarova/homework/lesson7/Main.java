package com.geekbrains.courses.java.pivovarova.homework.lesson7;
/*
1	Напишите тесты для сравнения скорости обращения по индексу к среднему элементу ArrayList и LinkedList.
В коллекциях должно быть по 10, 100, 10.000, 100.000 элементов.
Чтобы это заняло хоть сколько-то значительное время можно выполнить 10.000 обращений.
Результаты напишите в комментариях к коду, примерно так:
2	Напишите тест для удаления центральных элементов по индексу из ArrayList и LinkedList,
каждый раз удаляете по половине элементов (протестировать размеры коллекций:
100 [удалить 50], 10000 [удалить 5000], 100000 [удалить 50000]).
3	Создайте класс MyEntry включающий в себя Integer (что-то вроде ключа) и Integer (что-то вроде значения).
Заполните ArrayList<MyEntry> 50.000 записями, где ключ равен индексу элемента, а значение абсолютно случайное.
Создайте HashMap и заполните его теми же значениями.
Проведите тест, в котором 100.000 раз, по ключу будете искать значение, ключ выбирается случайно в пределах от 0 до 49999.
При поиске в ArrayList надо обходить все записи, и искать запись с указанным ключом.

 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//        arraytest(100000);
//        linkedtest(100000);
//        arrayRemoveTest(100000);
//        linkedRemoveTest(100000);
        ArrayList<MyEntry> listMyEntry = new ArrayList<>();
        Map<Integer, Integer> mapMyEntry = new HashMap<>();
        for (int i = 0; i < 50_000; i++) {
            int random= ThreadLocalRandom.current().nextInt(0,  Integer.MAX_VALUE);
            listMyEntry.add(new MyEntry(i, random));
            mapMyEntry.put(i, random);
        }
        testGetHashMap(mapMyEntry);
        testGetArray(listMyEntry);
    }
    public static void arraytest(int n) {
        List array = new ArrayList();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            array.get(n/2);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    public static void linkedtest(int n) {
        List linked = new LinkedList();
        for (int i = 0; i < n; i++) {
            linked.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linked.get(n/2);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    /*
    result test 1
                10  100   10000   100000
    ArrayList   1    1      1        1
    LinkedList  1    2     79       873
     */
    public static void arrayRemoveTest(int n) {
        List array = new ArrayList();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n/2; i++) {
            array.remove(array.size()/2);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    public static void linkedRemoveTest(int n) {
        List linked = new LinkedList();
        for (int i = 0; i < n; i++) {
            linked.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n/2; i++) {
            linked.remove(linked.size()/2);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    /*
    result test 2
               100   10000   100000
    ArrayList   0      3       145
    LinkedList  0      33     3048
     */
    public static void testGetArray(ArrayList<MyEntry> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            int random= ThreadLocalRandom.current().nextInt(0,  49999);
            for (MyEntry entry : list) {
                if (random == entry.getKey()) {
                    break;
                }
            }
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    public static void testGetHashMap(Map<Integer, Integer> map) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            int random= ThreadLocalRandom.current().nextInt(0,  49999);
            map.get(random);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
    /*
    result test 3
               50000
    ArrayList  9284
    HashMap     15
     */


}
