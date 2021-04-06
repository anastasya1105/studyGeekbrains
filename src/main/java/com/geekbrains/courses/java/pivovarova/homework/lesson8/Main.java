package com.geekbrains.courses.java.pivovarova.homework.lesson8;
/*
1	Взять строку, состоящую из 100 слов разделенных пробелом, получить список слов длиннее 5 символов,
и склеить их в одну строку с пробелом в качестве разделителя;
2	Найти список уникальных слов в двумерном массиве размером 5х5;
3	Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);
4	Посчитать суммарную длину строк в одномерном массиве;
5	Из массива слов получить первые три слова в алфавитном порядке;

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String stringOf100Words = "Рядом со под драгоценной дочерью под руку робко он он робко полу в храма жену храма он накануне как влюбился с как взгляда влюбился в свою будущую жену накануне её свадьбы с другим как глупо постеснялся своим признанием нарушить счастливую жизнь молодой пары которая всё равно как оказалось вскоре была обречена на расставание волею судьбы предоставив ему шанс на победное блаженство любви длинною в вечность тут внушительных размеров бородатый дядька как-то не по-мужски трепетно вскинув голову вмиг разглядел вдалеке среди множества других улыбающихся лиц единственно бесконечно обожаемые глаза нежно погладил дочь по руке и смело повёл её к алтарю";

        String[][] strings = new String[5][5];
        List<String> string = Arrays.asList(stringOf100Words.split(" "));
        int g = 1;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                strings[i][j] = string.get(g);
                g++;
            }
        }
        String[] newWordsMassiv = new String[12];
        for (int i = 0; i < newWordsMassiv.length; i++) {
            newWordsMassiv[i] = string.get(i);
        }
        System.out.println(myStringLorder5(stringOf100Words));
        System.out.println(uniqueWords(strings));
        System.out.println(sumFrom100Befor200());
        System.out.println(sumLenght(newWordsMassiv));
        System.out.println(firstThreeWords(newWordsMassiv));
    }
    //1	Взять строку, состоящую из 100 слов разделенных пробелом, получить список слов длиннее 5 символов,
    //и склеить их в одну строку с пробелом в качестве разделителя;
    public static String myStringLorder5(String text) {
        return Arrays.stream(text.split(" "))
                .filter(p -> p.length() > 5)
                .collect(Collectors.joining(" "));
    }
    //2	Найти список уникальных слов в двумерном массиве размером 5х5;
    public static List<String> uniqueWords(String[][] massiv) {
        return Arrays.stream(massiv).flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }
    //3	Посчитать сумму четных чисел в пределах от 100 до 200 (включительно);
    public static long sumFrom100Befor200() {
        return IntStream.rangeClosed(100, 200)
                .filter(n -> n % 2 == 0)
                .sum();
    }
    //Посчитать суммарную длину строк в одномерном массиве;
    public static int sumLenght(String[] text) {
          return Arrays.stream(text)
                .mapToInt(String::length).sum();

    }
    //Из массива слов получить первые три слова в алфавитном порядке;
    public static List firstThreeWords(String[] text) {
        return Arrays.stream(text)
                .map(s -> s.toLowerCase())
                .sorted(String :: compareTo)
                .limit(3)
                .collect(Collectors.toList());
    }
}
