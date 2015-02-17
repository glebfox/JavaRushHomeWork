package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        is.close();
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream = new FileInputStream(fileName2);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        outputStream.write(buffer);
        inputStream.close();
        inputStream = new FileInputStream(fileName3);
        buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        outputStream.write(buffer);
        inputStream.close();

        outputStream.close();
    }
}
