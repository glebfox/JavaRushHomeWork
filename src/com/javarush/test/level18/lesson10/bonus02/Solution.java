package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    private static String fileName;
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        fileName = reader.readLine();
        is.close();
        reader.close();
//        args = "-c Gleb Gorelov 145.16 45".split(" ");
//        fileName = "/Users/glebfox/Downloads/javaTestFiles/input.txt";

        performCommand(args);
    }

    private static void performCommand(String[] args) throws IOException {
        if (args.length > 0){
            if (args[0].toUpperCase().equals("-C")){
                    String[] localArgs = getArgs(args);
                    createEntry(localArgs);
            }
        }
    }

    private static String[] getArgs(String[] args) {
        String[] resultArgs = new String[3];
        int inputArgsLength = args.length;
        resultArgs[2] = args[inputArgsLength - 1];
        resultArgs[1] = args[inputArgsLength - 2];
        resultArgs[0] = "";

        for (int i = 1; i < inputArgsLength - 2; i++) {
            resultArgs[0] += args[i] + " ";
        }

        if (resultArgs[0].length() > 30)
            resultArgs[0] = resultArgs[0].substring(0, 30);

        return resultArgs;
    }

    private static void createEntry(String[] args) throws IOException {
        int id = getMaxId() + 1;

        FileWriter outputStream = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(outputStream);
        writer.write(String.format("%-8d%-30s%-8.2f%-4s%n", id, args[0], Float.parseFloat(args[1]), args[2]));
        writer.close();
    }

    private static int getMaxId() throws IOException {
        int maxId = 0;
        int id;
        FileReader inputStream = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(inputStream);
        String line;
        while ((line = reader.readLine()) != null){
            id = Integer.parseInt(line.substring(0, 8).trim());
            if (maxId < id)
                maxId = id;
        }

        inputStream.close();
        reader.close();
        return maxId;
    }
}
