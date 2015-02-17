package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static final int OFFSET = 1;

    public static void main(String[] args) {
        performCommand(args);
    }

    private static void performCommand(String args[]){
        if (args.length > 0){
            try {
                if (args[0].toUpperCase().equals("-E")){
                    encode(args[1], args[2]);
                }
                if (args[0].toUpperCase().equals("-D")){
                    decode(args[1], args[2]);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Неверное количество аргументов.");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void encode(String inputFileName, String outputFileName) throws IOException{
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);

        while (inputStream.available() > 0){
            outputStream.write(inputStream.read() + OFFSET);
        }

        inputStream.close();
        outputStream.close();
    }

    private static void decode(String inputFileName, String outputFileName) throws IOException{
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);

        while (inputStream.available() > 0){
            outputStream.write(inputStream.read() - OFFSET);
        }

        inputStream.close();
        outputStream.close();
    }
}