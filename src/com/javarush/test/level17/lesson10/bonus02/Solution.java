package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        args = "-c Gleb м 06/10/1988 Fox м 06/10/1988".split(" ");
//        performCommand(args);
//        args = "-i 0 1 2 3".split(" ");
//        performCommand(args);
//        args = "-u 2 Fox ж 16/10/1988 3 Gleb ж 16/10/1988".split(" ");
//        performCommand(args);
//        args = "-i 0 1 2 3".split(" ");
//        performCommand(args);
//        args = "-d 2 3".split(" ");
//        performCommand(args);
//        args = "-i 0 1 2 3".split(" ");
        performCommand(args);
    }

    public static void performCommand(String[] args){
        if (args.length > 0) {
            try {
                if (args[0].equals("-c")) {
                    String[] personArgs = new String[3];
                    for (int i = 1; i < args.length; i += 3) {
                        personArgs[0] = args[i];
                        personArgs[1] = args[i + 1];
                        personArgs[2] = args[i + 2];
                        createPerson(personArgs);
                    }
                }
                if (args[0].equals("-u")) {
                    String[] personArgs = new String[4];
                    for (int i = 1; i < args.length; i += 4) {
                        personArgs[0] = args[i];
                        personArgs[1] = args[i + 1];
                        personArgs[2] = args[i + 2];
                        personArgs[3] = args[i + 3];
                        updatePerson(personArgs);
                    }
                }
                if (args[0].equals("-d")) {
                    for (int i = 1; i < args.length; i++) {
                        deletePerson(Integer.parseInt(args[i]));
                    }
                }
                if (args[0].equals("-i")) {
                    for (int i = 1; i < args.length; i++) {
                        printInfo(Integer.parseInt(args[i]));
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
    }

    private  static void printInfo(int id) {
        Person person = allPeople.get(id);
        if (person.getName() != null) {
            System.out.println(person.getName() + " " + parseSexToString(person.getSex())
                    + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
        }
    }

    private  static void deletePerson(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    private  static void updatePerson(String[] args) {
        int index = Integer.parseInt(args[0]);
        Person person = allPeople.get(index);
        if (person != null) {
            person.setName(args[1]);
            person.setSex(parseSex(args[2]));
            try {
                person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createPerson(String[] args) {
        Person person = null;
        try {
            Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[2]);
            person = args[1].equals("м") ? Person.createMale(args[0], bd) : Person.createFemale(args[0], bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //synchronized (allPeople) {
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        //}
    }

    private static Sex parseSex(String sex){
        return sex.equals("м") ? Sex.MALE : Sex.FEMALE;
    }

    private static String parseSexToString(Sex sex) {
        return sex.equals(Sex.MALE) ? "м" : "ж";
    }

}
