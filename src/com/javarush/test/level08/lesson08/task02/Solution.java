package com.javarush.test.level08.lesson08.task02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        //return removeAllNumbersMoreThen10(set);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set) {
        //Напишите тут ваш код
        ArrayList<Integer> greater10 = new ArrayList<Integer>();
        for (Integer item : set)
            if (item > 10)
                greater10.add(item);

        set.removeAll(greater10);
        return set;
    }

//    public static void main(String[] args) {
//        HashSet<Integer> set = createSet();
//        for (Integer item : set)
//            System.out.println(item);
//    }
}
