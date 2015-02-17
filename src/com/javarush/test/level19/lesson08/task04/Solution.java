package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        System.setOut(consoleStream);
        System.out.println(solveEquation(outputStream.toString()));
    }

    private static String solveEquation(String equation) {
        equation = equation.replaceAll("[=, ,\n]", "");
        String[] params = equation.split("\\D");
        int x = Integer.parseInt(params[0]);
        int y = Integer.parseInt(params[1]);
        String sign = "";
        int result = 0;

        if (equation.contains("+")){
            result = x + y;
            sign = "+";
        }
        if (equation.contains("-")){
            result = x - y;
            sign = "-";
        }
        if (equation.contains("*")){
            result = x * y;
            sign = "*";
        }

        return String.format("%d %s %d = %d", x, sign, y, result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("13 - 6 = ");
        }
    }
}

