package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4

/Users/glebfox/Downloads/javaTestFiles/input1.txt
/Users/glebfox/Downloads/javaTestFiles/input2.txt
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        mergeFiles(reader.readLine(), reader.readLine());
        is.close();
        reader.close();

        printLines();
    }

    private static void printLines() {
        for (LineItem item : lines)
            System.out.println(item.type + " " + item.line);
    }

    private static void mergeFiles(String inputFileName1, String inputFileName2) throws IOException {
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(inputFileName1);
        InputStreamReader streamReader = new InputStreamReader(inputStream, "utf8");
        BufferedReader reader = new BufferedReader(streamReader);
        while (reader.ready()) {
            file1.add(reader.readLine());
        }
        inputStream.close();
        reader.close();

        inputStream = new FileInputStream(inputFileName2);
        streamReader = new InputStreamReader(inputStream, "utf8");
        reader = new BufferedReader(streamReader);
        while (reader.ready()) {
            file2.add(reader.readLine());
        }
        inputStream.close();
        reader.close();

        for (int file2index = 0, file1index = 0; file2index < file2.size() || file1index < file1.size(); file2index++, file1index++) {
            if (file2index < file2.size() && file1index < file1.size()) {
                String file1currLine = file1.get(file1index);
                String file2currLine = file2.get(file2index);
                if (file1currLine.equals(file2currLine))
                    lines.add(new LineItem(Type.SAME, file2currLine));
                else {
                    String file2nextLine = null;
                    if ((file2index + 1) < file2.size())
                        file2nextLine = file2.get(file2index + 1);

                    if (!file2currLine.isEmpty() && file1currLine.equals(file2nextLine)) {
                        lines.add(new LineItem(Type.ADDED, file2currLine));
                        file1index--;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, file1currLine));
                        file2index--;
                    }
                }
            } else {
                if (file1index < file1.size())
                    lines.add(new LineItem(Type.REMOVED, file1.get(file1index)));
                if (file2index < file2.size())
                    lines.add(new LineItem(Type.ADDED, file2.get(file2index)));
            }
        }
    }
    /*
    1   1   1   1
    1   2   2   1
    3   3   1

    1   1   1   1
    2   3   1   2
    1   4       1
     */


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
