package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> people = new ArrayList<Human>();

        Human grandfa1 = new Human("gf1", true, 70, null, null);
        people.add(grandfa1);
        Human grandfa2 = new Human("gf2", true, 71, null, null);
        people.add(grandfa2);
        Human grandma1 = new Human("gm1", false, 68, null, null);
        people.add(grandma1);
        Human grandma2 = new Human("gm2", false, 69, null, null);
        people.add(grandma2);

        Human dad = new Human("dad", true, 35, grandfa1, grandma1);
        people.add(dad);
        Human mom = new Human("mom", false, 33, grandfa2, grandma2);
        people.add(mom);

        Human son = new Human("son", true, 15, dad, mom);
        people.add(son);
        Human d1 = new Human("d1", false, 12, dad, mom);
        people.add(d1);
        Human d2 = new Human("d2", false, 7, dad, mom);
        people.add(d2);

        for (Human human : people)
            System.out.println(human);

    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
