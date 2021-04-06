package com.geekbrains.courses.java.pivovarova.homework.lesson11;

public class Tests {
    @Test(priority = 10)
    public static void metod1() {
        System.out.println("metod1, Test, priority = 10");
    }
    @Test(priority = 7)
    public static void metod2() {
        System.out.println("metod2, Test, priority = 7");
    }
//    @AfterSuite
//    public static void metod3() {
//        System.out.println("metod3");
//    }
    @AfterSuite
    public static void metod4() {
        System.out.println("metod3, AfterSuite");
    }
    @Test(priority = 4)
    public static void metod5() {
        System.out.println("metod5, Test, priority = 4");
    }
    @Test(priority = 8)
    public static void metod6() {
        System.out.println("metod6, Test, priority = 8");
    }
    @BeforeSuite
    public static void metod7() {
        System.out.println("metod7, BeforeSuite");
    }
    @Test(priority = 1)
    public static void metod8() {
        System.out.println("metod8, Test, priority = 1");
    }
//    @BeforeSuite
//    public static void metod9() {
//        System.out.println("metod9");
//    }

}
