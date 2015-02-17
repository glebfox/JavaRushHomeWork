package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
//    private static TreeMap<String, Double> folks = new TreeMap<String, Double>();
    public static void main(String[] args) throws IOException {
//        args = "/Users/glebfox/Downloads/javaTestFiles/input.txt".split(" ");
//        calculateValues(args[0]);
//
//        printToConsole(folks);

        TreeMap<String, Double> map = new TreeMap<String, Double>();

        String fileName = args[0];
        String name = "";
        double dig = 0;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(inputStreamReader);

        while (br.ready()){
            String[] arr = br.readLine().split(" ");
            name = arr[0];
            dig = Double.parseDouble(arr[1]);
            if(map.containsKey(name))
                dig = dig + map.get(name);
            map.put(name, dig);
        }
        inputStreamReader.close();
        br.close();
        for(Map.Entry<String, Double> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }

//    private static void printToConsole(TreeMap<String, Double> folks) {
//        for (Map.Entry<String, Double> pair : folks.entrySet())
//            System.out.println(pair.getKey() + " " + pair.getValue());
//    }
//
//    private static void calculateValues(String fileName) throws IOException {
//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(fileReader);
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] values = line.split(" ");
//            if (folks.containsKey(values[0])) {
//                double num = Double.parseDouble(values[1]) + folks.get(values[0]);
//                folks.replace(values[0], num);
//            } else
//                folks.put(values[0], Double.parseDouble(values[1]));
//        }
//
//        fileReader.close();
//        reader.close();
//    }
}
