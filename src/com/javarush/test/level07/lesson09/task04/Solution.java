package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list.add("лома");
        list.add("роза");
        list.add("лира");
        list.add("зола");
        list.add("абв");
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //add your code here -  добавь код тут
        boolean hasL;
        boolean hasR;
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            //hasL = list.get(i).toUpperCase().contains("Л");
            //hasR = list.get(i).toUpperCase().contains("Р");
            hasL = list.get(i).contains("л");
            hasR = list.get(i).contains("р");
            if (hasL && hasR || !hasL && !hasR)
                output.add(list.get(i));
            else if (hasL) {
                output.add(list.get(i));
                output.add(list.get(i));
            }
        }
        return output;
    }
}