package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        String us = s.toUpperCase();

        char[] chars = s.toCharArray();
        if (chars[0] != ' ')
            chars[0] = us.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] != ' ' & chars[i - 1] == ' ')
                chars[i] = us.charAt(i);
        }
        s = new String(chars);
        System.out.println(s);
    }
}
