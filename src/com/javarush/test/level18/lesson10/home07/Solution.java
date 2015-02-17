package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int targetId = Integer.parseInt(args[0]);
//        int targetId = 7;

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(is);
        String fileName = reader.readLine();
        is.close();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);

        int id = 0;
        String productName = "";
        double price = 0;
        int quantity = 0;
        while (reader.ready()){
            String line = reader.readLine();
            if (line.length() > 0) {
                String[] parts = line.split(" ");

                for (int i = 0; i < parts.length; i++) {
                    id = Integer.parseInt(parts[i++]);
                    productName = "";
                    while (!Character.isDigit(parts[i].charAt(0))){
                        productName += parts[i++] + " ";
                    }
                    price = Double.parseDouble(parts[i++]);
                    quantity = Integer.parseInt(parts[i]);
                    if (id == targetId) {
                        System.out.print(id + " ");
                        System.out.print(productName);
                        System.out.print(price + " ");
                        System.out.println(quantity);
                        //System.out.printf("%d %s%f %d%n", id, productName, price, quantity);
                    }
                }

            }
        }

        fileReader.close();
        reader.close();
    }
}
