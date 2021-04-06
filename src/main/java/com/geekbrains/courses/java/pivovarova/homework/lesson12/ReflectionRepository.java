package com.geekbrains.courses.java.pivovarova.homework.lesson12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReflectionRepository<T> {

    public static Connection connection;
    public static Statement stmt;
    public static PreparedStatement psInsert;
    private Class<T> myClass;
    private String nameClass;
    ArrayList<Field> fieldColumn;
    Field fieldId;

    public ReflectionRepository(Class<T> myClass) {
        this.myClass = myClass;
        nameClass =  myClass.getAnnotation(DbTable.class).name();
        isCorrect(myClass);
        fieldColumn = Arrays.stream(myClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(DbColumn.class))
                .collect(Collectors.toCollection(ArrayList::new));
        fieldId = Arrays.stream(myClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(DbId.class))
                .findAny().orElseThrow(() -> new RuntimeException("The class has no DbColumn fields"));
    }

    public void save(T object) throws SQLException, IllegalAccessException, ClassNotFoundException {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ")
                    .append(nameClass)
                    .append(" (");
        for (Field f : fieldColumn) {
                queryBuilder
                        .append(f.getName())
                        .append(", ");
        }
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(") VALUES (");
        for (Field f : fieldColumn) {
                queryBuilder.append("?, ");
        }
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(");");
        PreparedStatement ps = connection.prepareStatement(queryBuilder.toString());
        int index = 1;
        for (Field f : fieldColumn) {
                ps.setObject(index, f.get(object));
                index++;
        }
        ps.executeUpdate();
    }
    public T saveWithAnAsterisk(T object) throws IllegalAccessException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
            Object myObject = myClass.getConstructor().newInstance();
            ArrayList<Long> idList = new ArrayList<>();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT * FROM ")
                    .append(nameClass)
                    .append(";");
            String query = queryBuilder.toString();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                long id = rs.getInt("id");
                idList.add(id);
            }
            int myId = idList.size() + 1;
            save(object);
            for (Field field : fieldColumn) {
                field.setAccessible(true);
                    if (field.getType().equals(String.class)) {
                        field.set(myObject, field.get(object));
                    } else {
                        field.set(myObject, field.get(object));
                    }
                    fieldId.set(myObject, myId);
            }
            return (T) myObject;
    }
    public void deleteId(Long id) throws SQLException, ClassNotFoundException {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("DELETE FROM ")
                    .append(nameClass)
                    .append(" WHERE id = ")
                    .append(id)
                    .append(";");
        String query = queryBuilder.toString();
            stmt.executeUpdate(query);
    }
    public void clearTable() throws SQLException, ClassNotFoundException {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("DELETE FROM ")
                        .append(nameClass)
                .append(";");
        String query = queryBuilder.toString();
        System.out.println(stmt.executeUpdate(query));
    }
    public ArrayList<T> findAll() throws Exception {
            ArrayList<T> list = new ArrayList<>();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT * FROM ")
                    .append(nameClass)
                    .append(";");
            String query = queryBuilder.toString();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                long id = rs.getInt("id");
                list.add(findById(id));
            }
            return list;
    }

    public T findById(Long id) throws Exception {
        Object object = myClass.getConstructor().newInstance();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM ")
                    .append(nameClass)
                    .append(" WHERE id = ")
                    .append(id)
                    .append(";");
        String query = queryBuilder.toString();
        try (ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                for (Field field : fieldColumn) {
                    field.setAccessible(true);
                        if (field.getType().equals(String.class)) {
                            field.set(object, rs.getString(field.getName()));
                        } else {
                            field.set(object, rs.getInt(field.getName()));
                        }
                        fieldId.set(object, rs.getInt(field.getName()));
                }
            }
        }
        return (T) object;
    }
    public void connect() throws  ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:students.db");
        stmt = connection.createStatement();
    }
    public void disconnection() {
        try {
            if (stmt!=null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psInsert!=null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void isCorrect(Class mclass) {
        if (!mclass.isAnnotationPresent(DbTable.class)) {
            throw new RuntimeException("Unable to save objects for class " + mclass.getSimpleName());
        }
        int idNum = 0;
        Field[] fields = mclass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbId.class)) {
                idNum++;
            }
        }
        if (idNum!=1) {
            throw new RuntimeException("The id must be declared in the class ");
        }
    }
}
