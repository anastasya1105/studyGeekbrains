package com.geekbrains.courses.java.pivovarova.homework.lesson12;

import java.io.Serializable;

@DbTable(name = "students")
public class Student {
    
    @DbId()
    public long id;
    @DbColumn
    public String name;
    @DbColumn
    public int score;

    public Student(int i, String nastya, int i1) {
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println("id " + id + ", name - " + name + ", score: " + score);
    }
}
