package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int totalCount = inputStream.available();
        int spaceCount = 0;

        while (inputStream.available() > 0){
            if (inputStream.read() == 32)
                spaceCount++;
        }
        inputStream.close();

        System.out.format("%.2f%n", (float)spaceCount / totalCount * 100);
    }
}
