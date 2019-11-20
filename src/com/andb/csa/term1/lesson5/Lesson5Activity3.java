package com.andb.csa.term1.lesson5;

import java.util.Scanner;

public class Lesson5Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        System.out.println("Circumference: " + (2 * Math.PI * r));
        System.out.println("Area: " + (Math.PI * r * r));
    }
}
