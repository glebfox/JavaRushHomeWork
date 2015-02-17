package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    public static List<String> goodRows = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName = reader.readLine();
        is.close();
        reader.close();

        getRows(fileName);
        printRows(goodRows);
    }

    private static void printRows(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    private static void getRows(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            String row = reader.readLine();
            if (matchesCount(row.split(" ")) == 2)
                goodRows.add(row);
        }

        fileReader.close();
        reader.close();
    }

    private static int matchesCount(String[] words){
        int count = 0;
        for (int i = 0; i < words.length; i++)
            if (Solution.words.contains(words[i])) count++;
        return count;
    }
}
