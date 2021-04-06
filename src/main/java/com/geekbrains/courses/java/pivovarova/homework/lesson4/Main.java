package com.geekbrains.courses.java.pivovarova.homework.lesson4;
/*
1	Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2	Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3	В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
MyArrayDataException и вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) {
        String [][] strings = {{"4", "12", "3", "10"}, {"9", "1", "5", "19"}, {"3", "16", "36", "68"}, {"14", "25", "31", "16"}};
        try {
            System.out.println(sumArray4on4(strings));
        }
        catch (MyArrayDataException e) {

        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
    public static int sumArray4on4(String [][] strings) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (strings.length!=4) {
            throw new MyArraySizeException("Был получен массив не корректного размера. Должен быть 4*4");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length!=4) {
                throw new MyArraySizeException("Был получен массив не корректного размера. Должен быть 4*4");
            }
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Строка под номером " + j + " в " + i + " строке не может быть преобразована в целое число.");
                }
            }
        }
        return sum;
    }
}
