package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println( min( 5, 25 ) );
        System.out.println( min( 27L, 18L ) );
        System.out.println( min( 3.14, 2.71 ) );
    }

    //Напишите тут ваши методы
    public static int min(int n1, int n2){
        return n1 < n2 ? n1 : n2;
    }

    public static long min(long n1, long n2){
        return n1 < n2 ? n1 : n2;
    }

    public static double min(double n1, double n2){
        return n1 < n2 ? n1 : n2;
    }
}
