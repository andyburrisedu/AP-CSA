package com.andb.csa.term1.lesson7;

import java.util.Scanner;

public class Lesson7Activity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Here are the three digits:");
        int first = (num / 100) % 10;
        int second = (num / 10) % 10;
        int third = num % 10;
        System.out.println("Here are the digits:");
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(first + " + " + second + " + " + third + " = " + (first + second + third));
    }
}
