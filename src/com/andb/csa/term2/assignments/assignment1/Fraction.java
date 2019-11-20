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

    public void add(int n, int d) {
        if (n < 0 || d < 0) {
            return;
        }

        int lcd = denominator * d;
        int newNum1 = n * denominator;
        int newNum2 = numerator * d;
        n = newNum1 + newNum2;
        d = lcd;
    }

    public String mixedNumber() {
        int whole = numerator / denominator;
        int remainder = numerator % denominator;
        String out = "";
        if (whole != 0) {
            out += whole + " ";
        }
        if (remainder != 0) {
            out += fractionString(remainder, denominator);
        }
        return out;
    }

    private static String fractionString(int n, int d) {
        return n + "/" + d;
    }

    @Override
    public String toString() {
        return fractionString(numerator, denominator);
    }
}
