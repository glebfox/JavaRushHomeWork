package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
//        for (Integer i = 0; i < 10; i++) {
//            Integer name = i / 2;
//            map.put(i.toString(), name.toString());
//        }

        map.put("Сидоров", "Сидор");
        map.put("Федоров", "Сидор");
        map.put("Николаев", "Коляба");
        map.put("Егоров", "Жорик");
        map.put("Светка", "Чветка");
        map.put("Костин", "Костямба");
        map.put("Киров", "Кирюха");
        map.put("Стоянова", "Стоя");
        map.put("Петров", "Петруччо");
        map.put("Оля", "Коля");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        Map<String, String> map2 = new HashMap<String, String>(map);
        Map<String, String> map3 = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : map2.entrySet())
        {
            map3.remove(pair.getKey());

            if (map3.containsValue(pair.getValue()))
            {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        Print(map);
        System.out.println();
        removeTheFirstNameDuplicates(map);
        Print(map);
    }

    private static void Print(HashMap<String, String> map){
        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}
