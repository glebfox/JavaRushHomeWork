package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        copyEvenBytes(reader.readLine(), reader.readLine());

        is.close();
        reader.close();
    }

    private static void copyEvenBytes(String inputFileName, String outputFileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);

        inputStream.read();
        while (inputStream.available() > 0){
            outputStream.write(inputStream.read());
            inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
