package com.geekbrains.courses.java.pivovarova.homework.lesson3;
/*
1.	Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль:
успешно пробежал, не смог пробежать и т.д.).
2.	Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать).
У препятствий есть длина (для дорожки) или высота (для стены),
а у участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
3.	Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

 */

public class Main {
    public static void main(String[] args) {
        Human dima = new Human("Dima");
        Human nastya = new Human("Nastya");

        Robot valli = new Robot("Valli");
        Robot transformer = new Robot("Transformer");

        Cat barsik = new Cat("Barsik");
        Cat leopold = new Cat("Leopold");

        Wall obstacle1 = new Wall(30);
        Wall obstacle2 = new Wall(70);
        Treadmill obstacle3 = new Treadmill(120);
        Treadmill obstacle4 = new Treadmill(260);
        Wall obstacle5 = new Wall(100);
        Treadmill obstacle6 = new Treadmill(550);
        Participants[] participants = {dima, nastya, valli, transformer, barsik, leopold};
        Obstacle[] obstacles = {obstacle1, obstacle2, obstacle3, obstacle4, obstacle5, obstacle6};
        for (Participants p : participants) {
            for (Obstacle o : obstacles) {
                if (!o.interact(p)) {
                    System.out.println("следующий");
                    break;
                }
            }
        }
    }
}
