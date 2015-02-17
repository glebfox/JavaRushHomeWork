package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by glebfox on 21.07.14.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();

        return instance;
    }
}
