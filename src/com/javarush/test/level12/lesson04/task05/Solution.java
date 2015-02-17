package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static int max(int n1, int n2){
        return n1 > n2 ? n1 : n2;
    }

    public static long max(long n1, long n2){
        return n1 > n2 ? n1 : n2;
    }

    public static double max(double n1, double n2){
        return n1 > n2 ? n1 : n2;
    }
}
