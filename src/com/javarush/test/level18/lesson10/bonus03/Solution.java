package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    private static String fileName;
//    private static String tempFileName;
    private static ArrayList<String> lines = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        fileName = reader.readLine();
//        args = "-c Gleb Gorelov 145.16 45".split(" ");
//        args = "-u 19846 Gleb Gorelov 145.16 45".split(" ");
//        args = "-d 19847983".split(" ");
//        fileName = "/Users/glebfox/Downloads/javaTestFiles/input.txt";

//        tempFileName = fileName + ".temp";
        is.close();
        reader.close();

        performCommand(args);
    }

    public static void performCommand(String[] args) throws IOException {
        if (args.length > 0){
//            if (args[0].toUpperCase().equals("-C")){
//                String[] localArgs = getCArgs(args);
//                createEntry(localArgs);
//            }
            if (args[0].toUpperCase().equals("-U")){
                String[] localArgs = getUArgs(args);
                updateEntry(localArgs);
            }
            if (args[0].toUpperCase().equals("-D")){
                deleteEntry(Integer.parseInt(args[1]));
            }
        }
    }

//    private static void copyFilePart(BufferedReader originalFile, BufferedWriter tempFile, int id) throws IOException {
//        String line;
//        while ((line = originalFile.readLine()) != null){
//            int currId = getIdFromString(line);
//            if (currId == id)
//                break;
//            tempFile.write(line);
//            tempFile.newLine();
//        }
//    }

    private static void copyFileToList(String fileName) throws IOException {
        lines.clear();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready())
            lines.add(reader.readLine());

        fileReader.close();
        reader.close();
    }

    private static void deleteEntry(int id) throws IOException {
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(fileReader);
        copyFileToList(fileName);
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (String item : lines) {
            if (getIdFromString(item) != id) {
                writer.write(item);
                writer.newLine();
            }
        }
//        copyFilePart(reader, writer, id);
//        copyFilePart(reader, writer, -1);

        writer.close();
//        fileReader.close();
//        reader.close();
//
//        File file = new File(fileName);
//        file.delete();
//        File tempFile = new File(tempFileName);
//        tempFile.renameTo(file);
    }

    private static void updateEntry(String[] args) throws  IOException {
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(fileReader);
        copyFileToList(fileName);
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

//        copyFilePart(reader, writer, id);
        int id = Integer.parseInt(args[0]);
        for (String item : lines) {
            if (getIdFromString(item) == id)
                writer.write(String.format("%-8d%-30s%-8.2f%-4s%n", id, args[1], Float.parseFloat(args[2]), args[3]));
            else {
                writer.write(item);
                writer.newLine();
            }
        }
        writer.close();
//        copyFilePart(reader, writer, -1);
//        fileReader.close();
//        reader.close();
//
//        File file = new File(fileName);
//        file.delete();
//        File tempFile = new File(tempFileName);
//        tempFile.renameTo(file);
    }

    private static String[] getUArgs(String[] args) {
        String[] resultArgs = new String[4];
        int inputArgsLength = args.length;
        resultArgs[3] = args[inputArgsLength - 1];
        resultArgs[2] = args[inputArgsLength - 2];
        resultArgs[1] = "";
        resultArgs[0] = args[1];

        for (int i = 2; i < inputArgsLength - 2; i++) {
            resultArgs[1] += args[i] + " ";
        }

        if (resultArgs[1].length() > 30)
            resultArgs[1] = resultArgs[1].substring(0, 30);

        return resultArgs;
    }

//    private static String[] getCArgs(String[] args) {
//        String[] resultArgs = new String[3];
//        int inputArgsLength = args.length;
//        resultArgs[2] = args[inputArgsLength - 1];
//        resultArgs[1] = args[inputArgsLength - 2];
//        resultArgs[0] = "";
//
//        for (int i = 1; i < inputArgsLength - 2; i++) {
//            resultArgs[0] += args[i] + " ";
//        }
//
//        if (resultArgs[0].length() > 30)
//            resultArgs[0] = resultArgs[0].substring(0, 30);
//
//        return resultArgs;
//    }

//    private static void createEntry(String[] args) throws IOException {
//        int id = getMaxId() + 1;
//
//        FileWriter outputStream = new FileWriter(fileName, true);
//        BufferedWriter writer = new BufferedWriter(outputStream);
//        writer.write(String.format("%-8d%-30s%-8.2f%-4s%n", id, args[0], Float.parseFloat(args[1]), args[2]));
//        writer.close();
//    }

//    private static int getMaxId() throws IOException {
//        int maxId = 0;
//        int id;
//        FileReader inputStream = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(inputStream);
//        String line;
//        while ((line = reader.readLine()) != null){
//            id = getIdFromString(line);
//            if (maxId < id)
//                maxId = id;
//        }
//
//        inputStream.close();
//        reader.close();
//        return maxId;
//    }

    private static int getIdFromString(String line) {
        return Integer.parseInt(line.substring(0, 8).trim());
    }
}
