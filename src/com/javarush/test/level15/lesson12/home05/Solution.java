package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    int n;
    double d;
    String s;
    Object o;

    public Solution(Object o) {
        this.o = o;
    }

    public Solution(int n, double d, String s) {
        this.n = n;
        this.d = d;
        this.s = s;
    }

    private Solution(int n, String s) {
        this.n = n;
        this.s = s;

    }

    private Solution(double d, String s) {

        this.d = d;
        this.s = s;
    }

    private Solution(int n, double d) {

        this.n = n;
        this.d = d;
    }

    protected Solution(String s) {

        this.s = s;
    }

    protected Solution(double d) {

        this.d = d;
    }

    protected Solution(int n) {

        this.n = n;
    }

    public Solution() {

    }

    Solution(Object o, String s) {
        this.o = o;
        this.s = s;
    }

    Solution(Object o, int n) {
        this.o = o;
        this.n = n;
    }

    Solution(Object o, double d) {
        this.o = o;
        this.d = d;
    }
}

