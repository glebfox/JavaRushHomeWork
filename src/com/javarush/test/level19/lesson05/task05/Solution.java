package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        deletePunctuation(reader.readLine(), reader.readLine());

        is.close();
        reader.close();
    }

    private static void deletePunctuation(String inputFileName, String outputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line.replaceAll("\\p{Punct}", ""));
            writer.newLine();
        }

        fileReader.close();
        reader.close();
        //fileWriter.close();
        writer.close();
    }
}
