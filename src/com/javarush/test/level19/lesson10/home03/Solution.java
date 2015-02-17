package com.javarush.test.level19.lesson10.home03;

import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
//        args = "/Users/glebfox/Downloads/javaTestFiles/input.txt".split(" ");
        readDataFromFile(args[0]);
//        printPeople();
    }

    private static void printPeople(){
        for (Person person : PEOPLE){
            System.out.println(person.getName() + " " + new SimpleDateFormat("dd/MM/yyy").format(person.getBirthday()));
        }
    }

    private static void readDataFromFile(String fileName) throws IOException, ParseException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()){
            String line = reader.readLine();
            String[] parts = line.split(" ");
            int lastIndex = parts.length - 1;
            int day = Integer.parseInt(parts[lastIndex - 2]);
            int month = Integer.parseInt(parts[lastIndex - 1]);
            int year = Integer.parseInt(parts[lastIndex]);
            String name = line.substring(0, line.indexOf(parts[lastIndex - 2]) - 1);
            PEOPLE.add(new Person(name, new SimpleDateFormat("dd/MM/yyyy").parse(String.format("%d/%d/%d", day, month, year))));
        }

        fileReader.close();
        reader.close();
    }

}
