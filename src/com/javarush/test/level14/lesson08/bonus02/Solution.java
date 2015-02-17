package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n1 = Long.parseLong(reader.readLine());
        long n2= Long.parseLong(reader.readLine());
        System.out.println(GCD(n1, n2));

    }
    /*
    НОД(0, n) = n; НОД(m, 0) = m; НОД(m, m) = m;
НОД(1, n) = 1; НОД(m, 1) = 1;
Если m, n чётные, то НОД(m, n) = 2*НОД(m/2, n/2);
Если m чётное, n нечётное, то НОД(m, n) = НОД(m/2, n);
Если n чётное, m нечётное, то НОД(m, n) = НОД(m, n/2);
Если m, n нечётные и n > m, то НОД(m, n) = НОД((n-m)/2, m);
Если m, n нечётные и n < m, то НОД(m, n) = НОД((m-n)/2, n);
     */
    static long GCD(long a, long b)
    {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a == 1 || b == 1) return 1;
        if ((a % 2 == 0) && (b % 2 == 0)) return 2 * GCD(a / 2, b / 2);
        if ((a % 2 == 0) && (b % 2 != 0)) return GCD(a / 2, b);
        if ((a % 2 != 0) && (b % 2 == 0)) return GCD(a, b / 2);
        return GCD(b, (long)Math.abs(a - b));
    }
}
