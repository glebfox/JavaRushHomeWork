package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by glebfox on 22.07.14.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink(){
        //выбирает чашку, кладет ингредиенты, заливает жидкостью.
        getRightCup();
        putIngredient();
        pour();
    }
}
