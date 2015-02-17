package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
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

    public void initialize(String name) {
        initialize(name, 5, 2);
    }

    public void initialize(String name, int weigh, int age) {
        this.name = name;
        this.weigh = weigh;
        this.age = age;
        color = Color.BLACK;
        address = null;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weigh = 5;
        this.color = Color.BLACK;
        this.address = null;
    }

    public void initialize(int weigh, Color color) {
        initialize(weigh, color, null);
    }

    public void initialize(int weigh, Color color, String address) {
        this.weigh = weigh;
        this.color = color;
        this.address = address;
        this.name = null;
        this.age = 0;
    }
}
