package com.javarush.test.level15.lesson12.home04;

/**
 * Created by glebfox on 22.07.14.
 */
public class Sun implements Planet {
    private static Sun instance;

    protected Sun() {
    }

    public static Sun getInstance(){
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}
