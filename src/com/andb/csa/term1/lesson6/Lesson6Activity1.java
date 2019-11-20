package com.andb.csa.term1.lesson6;

import java.util.Scanner;

public class Lesson6Activity1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        double avg = (double) (i1 + i2) / 2;
        System.out.println("The average is: " + avg);
    }
}
