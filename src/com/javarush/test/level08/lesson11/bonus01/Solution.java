package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException, ParseException
    {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        Date date = new Date(month + "1 2014");
        System.out.println(month + " is " + (date.getMonth() + 1) + " month");

        Date dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
        System.out.println(month + " is " + (dateFormat.getMonth() + 1) + " month");
    }

}
