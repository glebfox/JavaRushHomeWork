package com.javarush.test.level15.lesson12.home04;

/**
 * Created by glebfox on 22.07.14.
 */
public class Moon implements Planet {
    private static Moon instance;

    protected Moon() {
    }

    public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}
