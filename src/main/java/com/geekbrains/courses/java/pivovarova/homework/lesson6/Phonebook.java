package com.geekbrains.courses.java.pivovarova.homework.lesson6;

import java.util.*;

public class Phonebook {
    Map<String, Set> phonebook = new HashMap<>();
    public void add(String sername, String number) {
        Set<String> setNumber = phonebook.getOrDefault(sername, new HashSet<>());
        setNumber.add(number);
        phonebook.put(sername, setNumber);
    }
    public String get(String sername) {
        String result = "В телефонной книге под фамилией " + sername + "записаны номера: " + phonebook.get(sername);
        return result;
    }
}
