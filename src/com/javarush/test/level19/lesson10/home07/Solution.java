package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        copyLongWords(args[0], args[1]);
    }

    private static void copyLongWords(String inputFileName, String outputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String result = "";
        while (reader.ready()){
            String[] words = reader.readLine().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6)
                    result += words[i] + ",";
            }
        }
        fileReader.close();
        reader.close();

        FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(result.substring(0, result.length() - 1));

        writer.close();
    }
}
