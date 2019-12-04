package com.andb.csa.term2.assignments.assignment1;

/**
 * Class to represent and manipulate a fraction
 *
 * @author Andy Burris
 * @version 22 Nov 2019
 */
public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Default constructor that creates a 1/1 fraction
     */
    public Fraction() {
        this(1, 1);
    }

    /**
     * Constructor that creates an n/d fraction
     *
     * @param n Numerator for fraction
     * @param d Denominator for fraction
     */
    public Fraction(int n, int d) {
        this.numerator = Math.max(n, 1);
        this.denominator = Math.max(d, 1);
    }

    /**
     * Adds a fraction to the object's fraction
     *
     * @param n numerator of fraction to add
     * @param d denominator of fraction to add
     */
    public void add(int n, int d) {
        if (n <= 0 || d <= 0) {
            return;
        }

        int lcd = denominator * d;
        int newNum1 = n * denominator;
        int newNum2 = numerator * d;
        numerator = newNum1 + newNum2;
        denominator = lcd;
    }

    /**
     * Returns a mixed number representation of the fraction
     *
     * @return String in format of "whole n/d"
     */
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

    /**
     * Returns a string representation of a fraction n/d
     *
     * @param n numerator of fraction
     * @param d denominator of fraction
     * @return String in format of "n/d"
     */
    private static String fractionString(int n, int d) {
        return n + "/" + d;
    }

    /**
     * String representation of Fraction object
     * @return String of improper fraction in format of "n/d"
     */
    @Override
    public String toString() {
        return fractionString(numerator, denominator);
    }
}
