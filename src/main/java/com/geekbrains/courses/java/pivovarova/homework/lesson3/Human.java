package com.geekbrains.courses.java.pivovarova.homework.lesson3;

public class Human implements Participants{
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

    public Human(String name) {
        this.name = name;
        maxLength = (int) (400 + Math.random()*900);
        maxHeight = (int) (200 + Math.random()*400);
    }
    @Override
    public boolean jump(int height) {
        if (height < maxHeight){
            System.out.println("Человек " + getName() + " перепрыгнул" );
            return true;
        }
        System.out.println("Человек " + getName() + " не перепрыгнул" );
        return false;
    }

    @Override
    public boolean run(int length) {
        if (length < maxLength) {
            System.out.println("Человек " + getName() + " пробежал" );
            return true;
        }
        System.out.println("Человек " + getName() + " не пробежал" );
        return false;
    }
}
