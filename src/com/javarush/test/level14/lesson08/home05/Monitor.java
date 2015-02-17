package com.javarush.test.level14.lesson08.home05;

/**
 * Created by glebfox on 21.07.14.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
