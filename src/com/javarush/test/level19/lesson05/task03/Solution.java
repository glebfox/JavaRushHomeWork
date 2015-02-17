package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        copyNumbers(reader.readLine(), reader.readLine());

        is.close();
        reader.close();
    }

    private static void copyNumbers(String inputFileName, String outputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputFileName);

        String line;
        while ((line = reader.readLine()) != null){
            fileWriter.write(getNumbers(line));
        }

        fileReader.close();
        reader.close();
        fileWriter.close();
    }

    private static String getNumbers(String line) {
        String[] words = line.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (isNumber(words[i]))
                result += words[i] +  " ";
        }

        return result;
    }

    private static boolean isNumber(String number){
        try {
            new Double(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
