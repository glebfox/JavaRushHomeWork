package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(fileName);
        int min = Byte.MAX_VALUE;
        int[] bytes = new int[Byte.MAX_VALUE];
        while (file.available() > 0){
            int index = file.read();
            bytes[index]++;
            if (bytes[index] < min)
                min = bytes[index];
        }
        file.close();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min)
                System.out.println(i);
        }
    }
}
