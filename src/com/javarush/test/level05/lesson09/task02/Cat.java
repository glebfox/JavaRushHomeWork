package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

import java.awt.*;

public class Cat
{
    //Напишите тут ваш код
    String name;
    int weigh;
    int age;
    Color color;
    String address;

    public Cat(String name) {
        this(name, 5, 2);
    }

    public Cat(String name, int weigh, int age) {
        this.name = name;
        this.weigh = weigh;
        this.age = age;
        color = Color.BLACK;
        address = null;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weigh = 5;
        this.color = Color.BLACK;
        this.address = null;
    }

    public Cat(int weigh, Color color) {
        this(weigh, color, null);
    }

    public Cat(int weigh, Color color, String address) {
        this.weigh = weigh;
        this.color = color;
        this.address = address;
        this.name = null;
        this.age = 0;
    }
}
