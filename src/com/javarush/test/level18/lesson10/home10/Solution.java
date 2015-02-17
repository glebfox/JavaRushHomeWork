package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileParts = getFileParts();

        sort(fileParts);
//        Collections.sort(fileParts);

        combineFile(fileParts);
    }

    private static void sort(ArrayList<String> list) {
        // до этого был реализован компаратор в отдельном классе, на всякий случай упростил до самописного метода
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (compareLMD(list.get(j), list.get(j + 1)) > 0){
                    String swap = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, swap);
                }
            }
        }
    }

    private static void combineFile(ArrayList<String> files) throws IOException {
        String fileName = files.get(0).substring(0, files.get(0).lastIndexOf('.'));
        //В него переписать все байты из файлов-частей используя буфер
        FileOutputStream outputStream = new FileOutputStream(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(outputStream);

        FileInputStream inputStream;
        BufferedInputStream reader;
        for (String currFileName : files) {
            inputStream = new FileInputStream(currFileName);
            reader = new BufferedInputStream(inputStream);

            while (inputStream.available() > 0)
                writer.write(reader.read());
            reader.close();
        }
        writer.close();
    }

    private static ArrayList<String> getFileParts() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);

        ArrayList<String> fileParts = new ArrayList<>();
        String currName;
        while (!(currName = reader.readLine()).toUpperCase().equals("END")) {
            fileParts.add(currName);
        }
        is.close();
        reader.close();

        return fileParts;
    }

    public static int compareLMD(String o1, String o2) {
        if (o1.length() > o2.length())
            return 1;
        else if (o1.length() < o2.length())
            return -1;
        else
            return o1.compareTo(o2);
    }
}
