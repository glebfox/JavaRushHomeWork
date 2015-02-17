package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        is.close();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        byte[] buffer1 = new byte[inputStream.available()];
        inputStream.read(buffer1);
        inputStream.close();

        inputStream = new FileInputStream(fileName2);
        byte[] buffer2 = new byte[inputStream.available()];
        inputStream.read(buffer2);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        outputStream.write(buffer2);
        outputStream.write(buffer1);
        outputStream.close();

    }
}
