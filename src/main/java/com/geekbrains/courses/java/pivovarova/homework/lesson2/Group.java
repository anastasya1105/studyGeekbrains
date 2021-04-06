package com.geekbrains.courses.java.pivovarova.homework.lesson2;
//2.	Создайте класс Группа, включающий в себя название группы и массив
// из максимум 10 сотрудников (не все элементы массива могут быть заполнены).
// Реализуйте возможность добавлять сотрудников в этот массив,
// удалять их из него по индексу, и удалять всех разом;
//3.	В классе Группа должен быть метод, позволяющий отпечатать
// информацию обо всех сотрудниках, входящих в эту группу;
public class Group {
    private String name;
    private Employee[] group = new Employee[10];
    int count = 0;
    public Employee[] getEmployees() {
        return group;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, Employee... list) {
        this.name = name;
        if (list.length < 10) {
            System.arraycopy(list, 0, group, 0, list.length);
            count += list.length;
        }
        else {
            System.out.println("В группе недостаточно места.");
        }
    }
    public void addEmploee(Employee man) {
        if (man == null) {
            System.out.println("невозможно добавить ");
        }
        if (count < 10) {
            group[count] = man;
            count++;
        }
        else {
            System.out.println("В данной группе уже максимальое число сотрудников");
        }
    }
    public void deleteEmploee(int index) {
            System.arraycopy(group, (index) + 1, group, index,(group.length - 1 - index));
            count--;
            group[group.length-1] = null;

    }

    public void deleteAll() {
        for (int i = 0; i < group.length; i++) {
            group[i] = null;
        }
        count = 0;
    }
    public void groupInfo() {
        for (int i = 0; i < group.length; i++) {
            System.out.println(group[i]);
        }
    }

}
