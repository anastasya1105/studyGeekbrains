package com.geekbrains.courses.java.pivovarova.homework.lesson12;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        ReflectionRepository<Student> rrStudent = new ReflectionRepository<>(Student.class);
        try {
//            rrStudent.save(new Student("Misha", 72));
//            rrStudent.save(new Student("Masha", 81));
//            rrStudent.save(new Student("Dasha", 79));
            rrStudent.save(new Student( "Nastya", 83));
//            rrStudent.deleteId(3L);
//            rrStudent.clearTable();
//           rrStudent.findById(3L).info();
//            rrStudent.saveWithAnAsterisk(new Student("Bob", 89)).info();
//            ArrayList<Student> list = rrStudent.findAll();
//            for (Student student : list) {
//                student.info();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}