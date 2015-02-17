package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

import java.awt.*;

public class Circle
{
    //Напишите тут ваш код
    int centerX;
    int centerY;
    int radius;
    int width;
    Color color;

    public void initialize(int centerX, int centerY, int radius, int width, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

    public void initialize(int centerX, int centerY, int radius, int width) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }

    public void initialize(int centerX, int centerY, int radius) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
}
