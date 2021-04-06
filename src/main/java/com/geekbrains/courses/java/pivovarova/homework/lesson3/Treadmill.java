package com.geekbrains.courses.java.pivovarova.homework.lesson3;

public class Treadmill implements Obstacle{
    private int length;

    public int getLength() {
        return length;
    }

    public Treadmill(int length) {
        this.length = length;
    }
    @Override
    public boolean interact(Participants p) {
        return p.run(length);
    }
}
