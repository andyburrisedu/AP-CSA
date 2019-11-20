package com.andb.csa.term1.lesson6;

import java.util.Scanner;

public class Lesson6Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d1 = scanner.nextDouble();
        double x100 = d1 * 100;
        double mod = x100 % 100;
        int round = (int) mod;
        System.out.println("Answer: " + round);
    }
}
