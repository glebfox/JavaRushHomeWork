package com.javarush.test.level15.lesson04.task01;

/* Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2 Удалите реализации всех лишних методов
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1);   //double
        print((Number) 1);  //Object
        print(1);           //double
        print((Integer) 1); //Integer
        print((int) 1);     //double
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    } // ok

//    public static void print(int i) {
//        System.out.println("Это Integer");
//    }

//    public static void print(Short i) {
//        System.out.println("Это Object");
//    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }   // ok

    public static void print(double i) {
        System.out.println("Это double");
    }   // ok

//    public static void print(Double i) {
//        System.out.println("Это double");
//    }

//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}
