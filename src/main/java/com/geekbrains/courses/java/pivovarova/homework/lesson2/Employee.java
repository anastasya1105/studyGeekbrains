package com.geekbrains.courses.java.pivovarova.homework.lesson2;

import java.io.PrintStream;

//1.	Создайте класс Сотрудник, с полями:
// имя, email, возраст, должность.
// Сотрудник должен уметь отпечатать в консоль информацию о себе;
public class Employee {
    private String name;
    private String email;
    private int age;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String name, String email, int age, String position) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.position = position;
    }
    public void info() {
        System.out.println(this);
    }
    public String toString() {
        String str = String.format("Employee: name: %s, email сотрудника: %s, Должность: %s, Возраст: %s" , name, email, position, age);
        return str;
    }
}
