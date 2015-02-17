package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        is.close();
        reader.close();

        FileReader fileReader = new FileReader(fileName1);
        reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            allLines.add(line);
        }
        fileReader.close();
        reader.close();

        fileReader = new FileReader(fileName2);
        reader = new BufferedReader(fileReader);
        while ((line = reader.readLine()) != null) {
            forRemoveLines.add(line);
        }
        fileReader.close();
        reader.close();
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
