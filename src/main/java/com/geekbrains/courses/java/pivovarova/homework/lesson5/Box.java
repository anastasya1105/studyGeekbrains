package com.geekbrains.courses.java.pivovarova.homework.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit > {
    private List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

//    public Box(ArrayList<T> list) {
//        this.list = list;
//    }
    public void addFruit(T fruit) {
            this.getList().add(fruit);
    }

    public float getWeight() {
        if (list.isEmpty()) {
            return 0.0f;
        }
            return (list.get(0)).getWeight() * list.size();
    }
    public boolean compare(Box<?> b) {
        return  Math.abs(this.getWeight()-b.getWeight()) < 0.001f;
    }
    public void pourOver(Box b) {
        if (b == this) {
            return;
        }
        if (!b.getList().contains(this)) {
            System.out.println("Невозможно пересыпать фрукты из текущей коробки в коробку с другим типом фруктов");
            return;
        }
            b.list.addAll(list);
            list.clear();
    }
}
