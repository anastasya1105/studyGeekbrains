package com.geekbrains.courses.java.pivovarova.homework.lesson5;

import java.util.ArrayList;

/*
3.	Задача:
a.	Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b.	Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c.	Для хранения фруктов внутри коробки можно использовать ArrayList;
d.	Сделать метод getWeight(), который высчитывает вес коробки, зная  вес одного фрукта и их количество:
 вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e.	Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
f.	Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в первой;
g.	Не забываем про метод добавления фрукта в коробку.

 */
public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> box1 = new Box<>();
        Fruit[] fruits = {new Apple(), new Orange(), new Apple(), new Orange(), new Apple(), new Orange()};
        for(Fruit f : fruits) {
            if (f instanceof Apple) {
                appleBox.addFruit((Apple) f);
            }
            if (f instanceof Orange) {
                orangeBox.addFruit((Orange) f);
            }
        }
        box1.addFruit(new Apple());
//        System.out.println(appleBox.getList().get(0).getClass());
//        System.out.println(appleBox.getWeight());
//        System.out.println(orangeBox.getWeight());
//        System.out.println(box1.getWeight());
//        System.out.println(appleBox.compare(orangeBox));
//        appleBox.pourOver(box1);
//        orangeBox.pourOver(appleBox);
        orangeBox.pourOver(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(box1.getWeight());

    }
    public static Object[] swapElements(Object[] obj, int one, int two) {
        if (one < 0 || one > obj.length || two < 0 || two > obj.length) {
            throw new IndexOutOfBoundsException();
        }
        if (one == two) {
            return obj;
        }
        Object num = obj[one];
        obj[one] = obj[two];
        obj[two] = num;
        return obj;
    }
    public static ArrayList transforms(Object[] obj) {
        ArrayList list = new ArrayList();
        for (Object o : obj) {
            list.add(o);
        }
        return list;
    }

}
