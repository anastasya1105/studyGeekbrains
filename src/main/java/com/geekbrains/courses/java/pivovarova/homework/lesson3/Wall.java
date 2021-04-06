package com.geekbrains.courses.java.pivovarova.homework.lesson3;

public class Wall implements Obstacle{
    private int height;

    public int getHeight() {
        return height;
    }

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean interact(Participants p) {
        return p.jump(height);
    }
}
