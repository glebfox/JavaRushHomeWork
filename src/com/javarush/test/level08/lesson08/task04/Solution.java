package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        for (Integer i = 0; i < 9; i++) {
            Date date = new Date();
            date.setMonth(i);
            map.put(i.toString(), date);
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        ArrayList<String> months = new ArrayList<String>();
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            int month = pair.getValue().getMonth();
            if (month > 4 && month < 8)
                months.add(pair.getKey());
        }

        for (String item : months)
            map.remove(item);
    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        for (Map.Entry<String, Date> pair : map.entrySet())
            System.out.println(pair.getKey() + " - " + pair.getValue());
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}
