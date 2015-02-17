package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        byte[] buffer = new byte[inputStream.available()];
        int half = inputStream.available() / 2 + inputStream.available() % 2;
        inputStream.read(buffer);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(fileName2);
        outputStream.write(buffer, 0, half);
        outputStream.close();

        outputStream = new FileOutputStream(fileName3);
        outputStream.write(buffer, half, buffer.length - half);
        outputStream.close();
    }
}
