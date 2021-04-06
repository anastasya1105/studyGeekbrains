package com.geekbrains.courses.java.pivovarova.homework.lesson10;

public class RaceApp {
    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40), new FinishLine());
        race.begin();
    }

}
