package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        FileInputStream inputStream;
        String name = null;

        try {
            while (true) {
                name = reader.readLine();
                inputStream = new FileInputStream(name);
                inputStream.close();
            }
        } catch (IOException e) {
            System.out.println(name);
        }
        is.close();
        reader.close();
    }
}
