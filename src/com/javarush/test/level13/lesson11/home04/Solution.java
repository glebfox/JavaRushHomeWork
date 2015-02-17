package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileWriter file = new FileWriter(fileName);

        while (true) {
            String line = reader.readLine();
            file.write(line + "\r\n");
            if (line.equals("exit"))
                break;
        }
        file.close();
    }
}
