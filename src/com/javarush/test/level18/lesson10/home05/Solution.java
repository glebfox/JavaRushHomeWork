package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        is.close();
        reader.close();

//        FileInputStream inputStream = new FileInputStream(fileName1);
//        FileOutputStream outputStream = new FileOutputStream(fileName2);
//
//        String currNumber = "";
//
//        while (inputStream.available() > 0){
//            int data = inputStream.read();
//            if ((data == 32 || data == 10) && currNumber.length() > 0 || inputStream.available() == 0){
//                float number = Float.parseFloat(currNumber);
//                currNumber = "";
//                String rounded = String.valueOf(Math.round(number));
//                outputStream.write(rounded.getBytes());
//                //if (inputStream.available() > 0) {
//                    outputStream.write(32);
//                //}
//            } else
//                currNumber += (char)data;
//        }
//
//        inputStream.close();
//        outputStream.close();

        FileReader fileReader = new FileReader(fileName1);
        reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String line;
        while ((line = reader.readLine()) != null){
            String[] numbers = line.split(" ");
            for (String number : numbers){
                if (!number.isEmpty()){
                    int num = Math.round(Float.parseFloat(number));
                    writer.write(num + " ");
                }
            }
        }

        fileReader.close();
        reader.close();
        //fileWriter.close();
        writer.close();
    }
}
