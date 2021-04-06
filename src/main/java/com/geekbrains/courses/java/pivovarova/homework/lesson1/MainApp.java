package com.geekbrains.courses.java.pivovarova.homework.lesson1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(sumFrom10Before20(4, 12));
        positiveOrNegative(5);
        System.out.println(negativeNumber(2));
        helloName("Дима");
        replacement0On1();
        fillTheArray();
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyBy2(arr);
        diagonal();
        minAndMax();
        int month = 1900;
        if (leapYear(month) == true) {
            System.out.println(" год является високосным");
        }
        if (leapYear(month) == false){
            System.out.println(" год является невисокосным");
        }
        int[] balance = {2, 2, 2, 2, 1, 2, 2, 10, 1, 2};
        System.out.println(checkBalance(balance));
    }
    /*1. Написать метод, принимающий на вход два целых числа и проверяющий,
     что их сумма лежит в пределах от 10 до 20 (включительно),
     если да – вернуть true, в противном случае – false
     */
    public static boolean sumFrom10Before20(int a, int b) {
            return (a+b >= 10 && a+b <= 20);
    }
    /*2. Написать метод, которому в качестве параметра передается целое число,
     метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     Замечание: ноль считаем положительным числом.
     */
    public static void positiveOrNegative(int a) {
        if (a  >= 0) {
            System.out.println(a + " является положительным числом");
        }
        else {
            System.out.println(a + " является отрицательным числом");
        }
    }
    /*3.	Написать метод, которому в качестве параметра передается целое число.
     Метод должен вернуть true, если число отрицательное.
     */
    public static boolean negativeNumber(int a) {
            return a < 0;
    }
    /*4.	Написать метод, которому в качестве параметра передается строка,
     обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */
    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }
    /* 5.	Задать целочисленный массив, состоящий из элементов 0 и 1.
     С помощью цикла и условия заменить 0 на 1, 1 на 0
     */
    public static void replacement0On1() {
        int[] add = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < add.length; i++) {
            add[i] = 1 - add[i];
        }
        System.out.println(Arrays.toString(add));
    }
    /*6.	Задать пустой целочисленный массив размером 8. С помощью цикла
     заполнить его значениями 2 5 8 11 14 17 20 23;
     */
    public static void fillTheArray() {
        int[] arr = new int[8];
        for (int i = 0, b = 2; i < arr.length; i++, b+=3) {
            arr[i] = b;
        }
        System.out.println(Arrays.toString(arr));
    }
    //7.	Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    public static void multiplyBy2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i]*=2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //8.	Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void diagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i][i] = 1;
            arr[i][j] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    //9.	* Задать одномерный массив и найти в нем минимальный и максимальный элементы;
    public static void minAndMax() {
        int[] arr = {9, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(min + " является минимальным элементом в массиве, " + max + " является максимальным элементом в массиве");
    }
    /*10.	* Написать метод, который определяет, является ли год високосным,
     и выводит сообщение в консоль. Каждый 4-й год является високосным,
     кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean leapYear(int year) {
        return (year%400 == 0 || (year%100 != 0 && year%4 ==0));
    }
    /*11.	* Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true, если в массиве есть место, в котором сумма левой и
     правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkBalance(int[] check) {
        int sum = 0;
        for (int i = 0; i < check.length; i++) {
            sum += check[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int sum1 = 0;
        for (int j = 0; j < check.length; j++) {
            sum1 += check[j];
            if (sum1 * 2 == sum) {
                System.out.println(j + 1);
                return true;
            }
            if (sum1 *2 > sum) {
                return false;
            }
        }
        return false;
    }
}
