package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
//    private static HashMap<String, Double> folks = new HashMap<String, Double>();

    public static void main(String[] args) throws IOException {
//        args = "/Users/glebfox/Downloads/javaTestFiles/input.txt".split(" ");
//        calculateValues(args[0]);
//        double max = findMax();
//        printMax(max);
        HashMap<String, Double> folks = new HashMap<String, Double>();

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            if (folks.containsKey(values[0])) {
                double num = Double.parseDouble(values[1]) + folks.get(values[0]);
                folks.put(values[0], num);
            } else
                folks.put(values[0], Double.parseDouble(values[1]));
        }

        fileReader.close();
        reader.close();

        double max = 0;
        for (Map.Entry<String, Double> pair : folks.entrySet()){
            if (max < pair.getValue())
                max = pair.getValue();
        }

        for (Map.Entry<String, Double> pair : folks.entrySet()){
            if (pair.getValue() == max)
                System.out.println(pair.getKey());
        }
    }

//    private static double findMax() {
//        double max = 0;
//        for (Map.Entry<String, Double> pair : folks.entrySet()){
//            if (max < pair.getValue())
//                max = pair.getValue();
//        }
//
//        return max;
//    }

//    private static void printMax(double max) {
//        for (Map.Entry<String, Double> pair : folks.entrySet()){
//            if (pair.getValue() == max)
//                System.out.println(pair.getKey());
//        }
//    }

//    private static void calculateValues(String fileName) throws IOException {
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(fileReader);
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] values = line.split(" ");
//            if (folks.containsKey(values[0])) {
//                double num = Double.parseDouble(values[1]) + folks.get(values[0]);
//                folks.put(values[0], num); // из за него!!
//            } else
//                folks.put(values[0], Double.parseDouble(values[1]));
//        }
//
//        fileReader.close();
//        reader.close();
//    }
}
