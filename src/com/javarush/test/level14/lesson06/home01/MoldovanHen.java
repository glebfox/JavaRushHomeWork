package com.javarush.test.level14.lesson06.home01;

/**
 * Created by glebfox on 21.07.14.
 */
public class MoldovanHen extends Hen {
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }
}
