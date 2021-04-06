package com.geekbrains.courses.java.pivovarova.homework.lesson11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TestRunner {
    public static void main(String[] args) {
        try {
            start(Tests.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void start(Class testClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Method> listAnnotationTest = new ArrayList();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod == null) {
                    beforeSuiteMethod = m;
                } else {
                    throw new RuntimeException("не может быть 2 аннотации BeforeSuite");
                }
            }
            if (m.isAnnotationPresent(Test.class)) {
                if (m.getAnnotation(Test.class).priority() > 10 || m.getAnnotation(Test.class).priority() < 0) {
                    throw new RuntimeException("Ошибка в указанном приоритете метода");
                }
                listAnnotationTest.add(m);
            }
            listAnnotationTest.sort(Comparator.comparingInt(i -> -i.getAnnotation(Test.class).priority()));
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod == null) {
                    afterSuiteMethod = m;
                } else {
                    throw new RuntimeException("не может быть 2 аннотации AfterSuite");
                }
            }
        }
        if (beforeSuiteMethod!= null) {
            beforeSuiteMethod.invoke(null);
        }
        for (Method m : listAnnotationTest) {
            m.invoke(null);
        }
        if (afterSuiteMethod!=null) {
            afterSuiteMethod.invoke(null);
        }
    }
    public static void start2(Class testClass) {
        Method[] methods = Tests.class.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(AfterSuite.class) | m.isAnnotationPresent(BeforeSuite.class) | m.isAnnotationPresent(Test.class))
                .sorted(new Comparator<Method>() {
                    @Override
                    public int compare(Method o1, Method o2) {
                        if (o1.isAnnotationPresent(BeforeSuite.class)) {
                            return -1;
                        }
                        if (o1.isAnnotationPresent(AfterSuite.class)) {
                            return 11;
                        }
                        if (o1.isAnnotationPresent(Test.class) && o2.isAnnotationPresent(Test.class)) {
                            return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                        }
                        return 0;
                    }
                })
                .forEach(method -> invokeMethod(method));
        }
        public static void invokeMethod(Method method) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
    }
}
