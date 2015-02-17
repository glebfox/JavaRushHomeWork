package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by glebfox on 22.07.14.
 */
public class Plane implements Flyable {
    private int passengersCount;

    public Plane(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    @Override
    public void fly() {

    }
}
