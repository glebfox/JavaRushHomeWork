package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(/*reader.readLine()*/"/Users/glebfox/Downloads/numbers.txt"));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String line;
        while ((line = file.readLine()) != null){

            try {
                Integer n = Integer.parseInt(line);
                if (n % 2 == 0) numbers.add(n);
            } catch (NumberFormatException e) {

            }
        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String inputFile = reader.readLine();
//
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        BufferedReader reader1 = new BufferedReader(
//                new FileReader(inputFile));
//
//        String line = null;
//        while ( (line = reader1.readLine()) != null)
//        {
//            String[] ws = line.trim().split("\\s");
//
//            for (String s : ws)
//            {
//                if (checkString(s))
//                {
//                    Integer a =Integer.parseInt(s);
//                    if (a % 2 == 0)
//                    numbers.add(a);
//                }
//            }
//        }

        sort(numbers);

        for (int n : numbers)
            System.out.println(n);
    }

    private static void sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)){
                    int swap = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, swap);
                }
            }
        }
    }

    public static boolean checkString(String string)
    {
        try{
            Integer.parseInt(string);
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
