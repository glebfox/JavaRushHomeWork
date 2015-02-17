package com.javarush.test.level15.lesson12.home04;

/**
 * Created by glebfox on 22.07.14.
 */
public class Earth implements Planet {
    private static Earth instance;

    protected Earth() {
    }

    public static Earth getInstance() {
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}
