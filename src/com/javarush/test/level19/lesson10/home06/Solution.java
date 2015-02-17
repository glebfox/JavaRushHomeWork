package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        printFile(reader.readLine());
        is.close();
        reader.close();
    }

    private static void printFile(String inputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            System.out.println(changeSWords(reader.readLine()));
        }

        fileReader.close();
        reader.close();
    }

    private static String changeSWords(String input){
        String result = "";
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (isNumber(words[i]))
                result += getWordNumber(Integer.parseInt(words[i]));
            else result += words[i];
            result += " ";
        }

        return result;
    }

    private static String getWordNumber(int number){
        if (map.containsKey(number))
            return map.get(number);
        return String.valueOf(number);
    }

    private static boolean isNumber(String input){
        try {
            new Integer(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
