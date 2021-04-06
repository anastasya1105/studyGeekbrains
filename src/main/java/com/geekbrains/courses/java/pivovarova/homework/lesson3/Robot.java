package com.geekbrains.courses.java.pivovarova.homework.lesson3;

public class Robot implements Participants {
    private String name;
    private int maxLength;
    private int maxHeight;

    public String getName() {
        return name;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public Robot(String name) {
        this.name = name;
        maxLength = (int) (300 + Math.random()*600);
        maxHeight = (int) (150 + Math.random()*400);
    }
    @Override
    public boolean jump(int height) {
        if (height < maxHeight){
            System.out.println("Робот " + getName() + " перепрыгнул" );
            return true;
        }
        System.out.println("Робот " + getName() + " не перепрыгнул" );
        return false;
    }

    @Override
    public boolean run(int length) {
        if (length < maxLength) {
            System.out.println("Робот " + getName() + " пробежал");
            return true;
        }
        System.out.println("Робот " + getName() + " не пробежал");
        return false;
    }
}
