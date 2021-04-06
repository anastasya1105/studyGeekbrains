package com.geekbrains.courses.java.pivovarova.homework.lesson2;

public class MainApp {
    public static void main(String[] args) {
        Employee masha = new Employee("Masha", "masha@gmail.ru", 26, "manager");
        masha.info();
        Employee[] list = new Employee[2];
        list[0] = new Employee("IvanLm","ivan@mail.ru",31,"manager");
        list[1] = new Employee("Dmitriy","dmitriy@gmail.ru",28,"manager");
        System.out.println("--------------------");
        Group group = new Group("otdel", list);
        group.addEmploee(masha);
        group.addEmploee(new Employee("Ivanov","ivanov@mail.ru",25,"admin"));
        group.addEmploee(new Employee("Sidorov","sidorov@mail.ru",36,"designer"));
        group.addEmploee(new Employee("Fedorov","fedorov@gmail.ru",40,"programmer"));
        group.addEmploee(new Employee("Fedorov","fedorov@mail.ru",40,"programmer"));
        group.addEmploee(new Employee("Dmitriy","dmitriy@gmail.ru",19,"manager"));
        group.addEmploee(new Employee("Nastya","dmitriy@mail.ru",32,"manager"));
        group.addEmploee(new Employee("Misha","misha@gmail.ru",26,"manager"));
        group.groupInfo();
        System.out.println("--------------------");
        group.deleteEmploee(3);
        group.groupInfo();
        System.out.println("--------------------");
        group.deleteAll();
        group.groupInfo();

    }
}
