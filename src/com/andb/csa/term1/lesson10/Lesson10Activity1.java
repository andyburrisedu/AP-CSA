package com.andb.csa.term1.lesson10;

import java.util.Scanner;

public class Lesson10Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d1 = scanner.nextDouble();
        double d2 = scanner.nextDouble();
        double diff = minNoRoundoff(d1, d2);
        System.out.println(diff);
    }

    public static double minNoRoundoff(double d1, double d2) {
        int i1 = (int) (d1 * 1000);
        int i2 = (int) (d2 * 1000);
        int minus = i1 - i2;
        return ((double) minus) / 1000;
    }
}
