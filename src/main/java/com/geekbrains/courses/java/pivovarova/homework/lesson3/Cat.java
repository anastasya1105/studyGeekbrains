package com.geekbrains.courses.java.pivovarova.homework.lesson3;

public class Cat implements Participants{
    private String name;
    private int maxLength;
    private int maxHeight;

    public String getName() {
        return name;
    }

    public Cat(String name) {
        this.name = name;
        maxLength = (int) (200 + Math.random()*500);
        maxHeight = (int) (100 + Math.random()*300);
    }

    @Override
    public boolean jump(int height) {
        if (height < maxHeight){
            System.out.println("Cat " + getName() + " перепрыгнул" );
            return true;
        }
        System.out.println("Cat " + getName() + " не перепрыгнул" );
        return false;
    }

    @Override
    public boolean run(int length) {
        if (length < maxLength) {
            System.out.println("Cat " + getName() + " пробежал" );
            return true;
        }
        System.out.println("Cat " + getName() + " не пробежал" );
        return false;
    }
}
