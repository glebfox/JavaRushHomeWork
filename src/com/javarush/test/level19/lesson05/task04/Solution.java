package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        replaceDots(reader.readLine(), reader.readLine());

        is.close();
        reader.close();
    }

    private static void replaceDots(String inputFileName, String outputFileName) throws IOException {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line.replaceAll("[.]", "!"));
            writer.newLine();
        }

        fileReader.close();
        reader.close();
//        fileWriter.close();
        writer.close();
    }
}
