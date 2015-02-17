package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final String targetWord = "WORLD";
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        String fileName = reader.readLine();
        System.out.println(worldCount(fileName));

        is.close();
        reader.close();
    }

    private static int worldCount(String fileName) throws IOException {
        int count = 0;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null){
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].toUpperCase().contains(targetWord))
                    count++;
            }
        }

        fileReader.close();
        reader.close();

        return count;
    }
}
