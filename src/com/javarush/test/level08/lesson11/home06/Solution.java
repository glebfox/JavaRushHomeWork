package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human cl1 = new Human("cl1", true, 5, new ArrayList<Human>());
        Human cl2 = new Human("cl2", false, 7, new ArrayList<Human>());
        Human cl3 = new Human("cl3", true, 9, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(cl1);
        children.add(cl2);
        children.add(cl3);
        Human f = new Human("f", true, 32, children);
        Human m = new Human("m", false, 30, children);
        children = new ArrayList<Human>();
        children.add(f);
        Human gf1 = new Human("gf1", true, 71, children);
        Human gm1 = new Human("gm1", false, 70, children);
        children = new ArrayList<Human>();
        children.add(m);
        Human gf2 = new Human("gf2", true, 72, children);
        Human gm2 = new Human("gm2", false, 73, children);

        System.out.println(gf1);
        System.out.println(gm1);
        System.out.println(gf2);
        System.out.println(gm2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        Boolean sex;
        Integer age;
        ArrayList<Human> children;

        public Human(String name, Boolean sex, Integer age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
