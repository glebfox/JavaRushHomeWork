package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        printReverse(reader.readLine());
        is.close();
        reader.close();
    }

    private static void printReverse(String inputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            System.out.println(reverseString(reader.readLine()));
        }

        fileReader.close();
        reader.close();
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
