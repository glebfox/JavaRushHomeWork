package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        reader.close();

        request = request.substring(request.indexOf('?') + 1);
        String[] params = request.split("&");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < params.length; i++) {
            String[] paramsParts = params[i].split("=");
            if (paramsParts.length > 1 && paramsParts[0].equals("obj")){
                list.add(paramsParts[1]);
            }
            System.out.print(paramsParts[0] + " ");
        }
        System.out.println();
        for (String item : list){
//            if (item.contains("."))
//                alert(Double.parseDouble(item));
//            else alert(item);
            try {
                alert(Double.parseDouble(item));
            } catch (NumberFormatException e) {
                alert(item);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
