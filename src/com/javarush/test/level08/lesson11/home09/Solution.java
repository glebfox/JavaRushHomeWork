package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        Date dt = new Date(date);
        Date start = new Date(date);
        start.setMonth(0);
        start.setDate(1);

        long difference = dt.getTime() - start.getTime();
        difference /= (1000 * 60 * 60 * 24);

        return difference % 2 == 0;
    }
}
