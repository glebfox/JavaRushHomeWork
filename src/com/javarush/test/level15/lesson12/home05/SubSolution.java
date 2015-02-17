package com.javarush.test.level15.lesson12.home05;

/**
 * Created by glebfox on 22.07.14.
 */
public class SubSolution extends Solution {
    public SubSolution(Object o) {
        super(o);
    }

    SubSolution(Object o, String s) {
        super(o, s);
    }

    SubSolution(Object o, int n) {
        super(o, n);
    }

    SubSolution(Object o, double d) {
        super(o, d);
    }

    public SubSolution(int n, double d, String s) {
        super(n, d, s);
    }

    protected SubSolution(String s) {
        super(s);
    }

    protected SubSolution(double d) {
        super(d);
    }

    protected SubSolution(int n) {
        super(n);
    }

    public SubSolution() {
    }

    private SubSolution(int n, String s) {
        this.n = n;
        this.s = s;

    }

    private SubSolution(double d, String s) {

        this.d = d;
        this.s = s;
    }

    private SubSolution(int n, double d) {

        this.n = n;
        this.d = d;
    }
}
