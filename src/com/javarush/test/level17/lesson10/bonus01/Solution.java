package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        args = "-c Gleb м 06/10/1988".split(" ");
//        performCommand(args);
//        args = "-i 2".split(" ");
//        performCommand(args);
//        args = "-u 2 Fox ж 16/10/1988".split(" ");
//        performCommand(args);
//        args = "-i 2".split(" ");
//        performCommand(args);
//        args = "-c Миронов м 15/04/1990".split(" ");
//        performCommand(args);
//        args = "-i 2".split(" ");
        performCommand(args);
    }

    public static void performCommand(String[] args){
        if (args.length > 0) {
            try {
                if (args[0].equals("-c"))
                    createPerson(args);
                if (args[0].equals("-u"))
                    updatePerson(args);
                if (args[0].equals("-d"))
                    deletePerson(Integer.parseInt(args[1]));
                if (args[0].equals("-i"))
                    printInfo(Integer.parseInt(args[1]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
    }

    private static void printInfo(int id) {
        Person person = allPeople.get(id);
        System.out.println(person.getName() + " " + getStringSex(person.getSex())
                + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
    }

    private static void deletePerson(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    private static void updatePerson(String[] args) {
        int index = Integer.parseInt(args[1]);
        Person person = allPeople.get(index);
        person.setName(args[2]);
        person.setSex(getSex(args[3]));
        try {
            person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void createPerson(String[] args) {
        Person person = null;
        try {
            person = args[2].equals("м") ? Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])) : Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    private static Sex getSex(String sex){
        return sex.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    private static String getStringSex(Sex sex) {
        return sex.equals(Sex.MALE) ? "м" : "ж";
    }
}
