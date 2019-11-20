package com.andb.csa.term2.assignments.assignment1;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(1, 1);
    }

    public Fraction(int n, int d) {
        this.numerator = Math.max(n, 1);
        this.denominator = Math.max(d, 1);
    }

    void add(int n, int d) {

    }

    String mixedNumber() {
        int whole = numerator / denominator;
        int remainder = numerator % denominator;
        return whole + " " + remainder + "/" + denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
