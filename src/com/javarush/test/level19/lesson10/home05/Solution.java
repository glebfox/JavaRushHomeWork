package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = "/Users/glebfox/Downloads/javaTestFiles/input.txt /Users/glebfox/Downloads/javaTestFiles/output.txt".split(" ");
        copyWordsWithDigits(args[0], args[1]);
    }

    private static void copyWordsWithDigits(String inputFileName, String outputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        while (reader.ready()){
            String[] words = reader.readLine().split(" ");
            String result = getWordsWithDigits(words);
            if (result.length() > 0)
                writer.write(result);
        }

        fileReader.close();
        reader.close();
        writer.close();
    }

    private static String getWordsWithDigits(String[] words) {
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("\\D", "");
            if (word.length() > 0)
                result +=  words[i] + " ";
        }
        return result;
    }
}
