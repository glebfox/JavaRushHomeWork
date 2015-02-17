package com.javarush.test.level10.lesson11.home08;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Random;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
        Random random = new Random();
        ArrayList<String>[] arrayLists = new ArrayList[random.nextInt(10)];

        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<String>();
            int n = random.nextInt(10);
            for (int j = 0; j < n; j++) {
                Integer word = random.nextInt();
                arrayLists[i].add(word.toString());
            }
        }


        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}